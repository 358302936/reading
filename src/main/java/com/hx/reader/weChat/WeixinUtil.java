package com.hx.reader.weChat;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.hx.reader.components.upload.SpringUtils;
import com.hx.reader.model.dao.WeixinMenuMapper;
import com.hx.reader.weChat.vo.MyX509TrustManager;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import java.io.*;
import java.net.ConnectException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author yanuun
 * @Date 15:03 2018/2/28
 **/
@Component
public class WeixinUtil {

    @Autowired
    private WeixinMenuMapper weixinMenuMapper;

    public void setWeixinMenuMapper(WeixinMenuMapper weixinMenuMapper) {
        this.weixinMenuMapper = weixinMenuMapper;
    }

    public static WeixinUtil weixinUtil;
    @PostConstruct
    public void init(){
        weixinUtil = this;
        weixinUtil.weixinMenuMapper = this.weixinMenuMapper;
    }


    public static final String DEFAULT_APPID = "wx384850d6a13cd619";
    public static final String DEFAULT_SECRET = "b706d6ebe83f762482d2c18745130584";

    //yuetinghs
    public static final String WECHAT_APPID = "wx748220b52a13e1b9";
    public static final String WECHAT_SECRET = "36fb6cb8430e1cc3bac27ed99105374d";


    private static Logger log = LoggerFactory.getLogger(WeixinUtil.class);
    //微信获取access_token的url  需要微信appid和微信secret
    public static final String WXCHAR_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+WECHAT_APPID+"&secret="+WECHAT_SECRET;
    //微信公众号根据模板发送消息的url   需要access_token
    public static final String WXCHAR_TEMP_SEND_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";
    //微信公众号根据模板发送消息的url   需要access_token
    public static final String WXCHAR_SEND_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=";
    //微信公众号  医生问询通知模板id
    public static final String WXCHAR_TEMP_SEND_ID = "qEs592-JIOHw40LBwKNQpFNtsD3rl7S2-5QUsZY8K0c";


    /**
     * 发起https请求并获取结果
     * @param requestUrl 请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @param outputStr 提交的数据
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
     */
    public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = { new MyX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
            httpUrlConn.setSSLSocketFactory(ssf);

            httpUrlConn.setDoOutput(true);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            httpUrlConn.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod))
                httpUrlConn.connect();

            // 当有数据需要提交时
            if (null != outputStr) {
                OutputStream outputStream = httpUrlConn.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 将返回的输入流转换成字符串
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            httpUrlConn.disconnect();
            jsonObject = new JSONObject(buffer);
            // jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (ConnectException ce) {
            log.error("Weixin server connection timed out.");
        } catch (Exception e) {
            log.error("https request error:{}", e);
        }
        return jsonObject;
    }

    /**
     * 根据网页授权编码获得token,返回用户基本信息openID
     * @param code
     */
    public static String getOpenId(String code) throws UnsupportedEncodingException {
        // 根据网页授权编码获得token
        String get_access_token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?" + "appid=APPID"
                + "&secret=SECRET&" + "code=CODE&grant_type=authorization_code";
        // 根据网页授权编码获得token
        get_access_token_url = get_access_token_url.replace("APPID", WECHAT_APPID);
        get_access_token_url = get_access_token_url.replace("SECRET", WECHAT_SECRET);
        get_access_token_url = get_access_token_url.replace("CODE", code);
        String json = HttpUtil.getUrl(get_access_token_url);
        JSONObject jsonObject = new JSONObject(json);
        System.out.println("weixin:" + jsonObject.toString());
        String openId = jsonObject.getString("openid");
        return openId;
    }


    /**
     * 根据网页授权编码获得token,返回用户基本信息
     * @param code
     */
    public static Map<String,Object> getUserInfo(String code) throws UnsupportedEncodingException {
        // 根据网页授权编码获得token
        String get_access_token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?" + "appid=APPID"
                + "&secret=SECRET&" + "code=CODE&grant_type=authorization_code";
        // 根据网页授权编码获得token
        get_access_token_url = get_access_token_url.replace("APPID", WECHAT_APPID);
        get_access_token_url = get_access_token_url.replace("SECRET", WECHAT_SECRET);
        get_access_token_url = get_access_token_url.replace("CODE", code);
        String json = HttpUtil.getUrl(get_access_token_url);
        JSONObject jsonObject = new JSONObject(json);
        System.out.println("weixin:" + jsonObject.toString());


        //通过access_token和openid拉取用户信息
        String get_userinfo_url = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
        get_userinfo_url = get_userinfo_url.replace("ACCESS_TOKEN", jsonObject.getString("access_token"));
        get_userinfo_url = get_userinfo_url.replace("OPENID", jsonObject.getString("openid"));
        String userInfoUrl = HttpUtil.getUrl(get_userinfo_url);
        JSONObject userInfoObject = new JSONObject(userInfoUrl);
        System.out.println("用户信息："+userInfoObject.toString());
        Map<String,Object> dataMap = new HashMap<String,Object>();
        dataMap.put("country", userInfoObject.getString("country"));
        dataMap.put("province", userInfoObject.getString("province"));
        dataMap.put("city", userInfoObject.getString("city"));
        dataMap.put("openid", userInfoObject.getString("openid"));
        dataMap.put("sex", userInfoObject.getInt("sex"));
        dataMap.put("nickname", userInfoObject.getString("nickname"));
        dataMap.put("headimgurl", userInfoObject.getString("headimgurl"));
        dataMap.put("token", jsonObject.getString("access_token"));
        return dataMap;
    }

    /**
     * 根据地址获得经纬度
     * @param address
     * @return
     */
    public static JSONObject getXY(String address) {
        String baidu_url = "http://api.map.baidu.com/geocoder/v2/?" + "address=ADDRESS" + "&output=json&ak=AK"
                + "&callback=showLocation";
        baidu_url = baidu_url.replace("ADDRESS", address);
        baidu_url = baidu_url.replace("AK", "lVwnztI2XYy62EDIu0zQRVhVRmKVGqzu");
        String json = HttpUtil.getUrl(baidu_url);
        json = json.substring(0, json.length() - 1);
        String[] jsons = json.split("\\{");
        String[] location = jsons[3].split("\\}");
        JSONObject jsonObject = new JSONObject("{" + location[0] + "}");
        return jsonObject;
    }


    /**
     * 微信公众号获取access_token
     * @author add by wanggl at 2017-01-05
     * @return
     */
    public static String getAccessToken() {
        String token = "";
        try {
            String code = HttpUtil.getUrl(WXCHAR_TOKEN_URL);
            JSONObject jb = new JSONObject(code);
            token = jb.getString("access_token");
            System.out.println(token);
        } catch (Exception e) {

        }
        return token;
    }

    public static String codeToOpenid(String code){
        return codeToOpenid(code, null, null);
    }

    public static String codeToOpenid(String code,String appid,String appsecret){
        String openid = "";
        appid = SpringUtils.isNull(appid)?DEFAULT_APPID:appid;
        appsecret = SpringUtils.isNull(appsecret)?DEFAULT_SECRET:appsecret;
        try {
            String result = HttpUtil.getUrl("https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid
                    +"&secret="+appsecret+"&code="+code+"&grant_type=authorization_code");
            JSONObject jb = new JSONObject(result);
            openid = jb.getString("openid");
            System.out.println(openid);
        } catch (Exception e) {

        }
        return openid;
    }


    //生成带参数二维码
    public static void qrcodeCreate(){
        String create_url="https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token="+getAccessToken();
        JSONObject jsonObject = new JSONObject();
        Map<String,Object> paramMap = new HashMap<>();
//        paramMap.put("expire_seconds",86400);
        paramMap.put("action_name","QR_LIMIT_STR_SCENE");

        Map<String,Object> scene = new HashMap<>();
        scene.put("scene_str","111111111");
        Map<String,Object> actionInfo = new HashMap<>();
        actionInfo.put("scene",scene);
        paramMap.put("action_info",actionInfo);
        JSONObject result =  HttpUtil.httpPost(create_url,new JSONObject(paramMap),false);
        System.out.println("ticket:"+result);
    }

    public static JSONObject getWordInfo(String word){
        String youdao_url="http://dict.youdao.com/jsonresult?q=newWord&keyfrom=deskdict.main&type=1&pos=-1&client=deskdict&id=beb6879046841d902&vendor=unknown&in=YoudaoDictSetup&appVer=7.5.2.0&appZengqiang=0&abTest=&le=en&LTH=0";
        youdao_url = youdao_url.replace("newWord",word);
        String result = HttpUtil.getUrl(youdao_url);
        JSONObject jsonObject = new JSONObject(result);

        return jsonObject;
    }


    /**
     * 字符串转换unicode
     */
    public static String stringToUnicode(String string) {

        StringBuffer unicode = new StringBuffer();

        for (int i = 0; i < string.length(); i++) {
            // 取出每一个字符
            char c = string.charAt(i);

            // 转换为unicode
            unicode.append("\\u" + Integer.toHexString(c));
        }
        return unicode.toString();
    }

    /**
     * unicode 转字符串
     */
    public static String unicodeToString(String unicode) {

        StringBuffer string = new StringBuffer();

        String[] hex = unicode.split("\\\\u");

        for (int i = 1; i < hex.length; i++) {

            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 16);

            // 追加成string
            string.append((char) data);
        }

        return string.toString();
    }


    public static void getProductInfo(){
        String userInfoUrl = HttpUtil.getUrl("https://detail.tmall.com/item.htm?id=564648104692");
        log.info(userInfoUrl);
    }



    public static void main(String[] args){
        HttpUtil.htmlPage("https://detail.tmall.com/item.htm?id=564648104692");
    }


}
