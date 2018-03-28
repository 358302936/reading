package com.hx.reader.everyday.mar2017;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import javafx.scene.input.DataFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ques0301 {

	private int a = getB();
	private int b = 1;

	public int getB() {
		return b;
	}
	
	public static void main(String[] args) {
		new Ques0301().jsonTest();
	}
	
	/**
	 * 在系统装载类时，会先初始化各成员变量，根据变量类型赋默认值，例子中，在执行类体语句前，成员变量a、b已被赋值为0，
	 * 在执行a = getB()时，因为还未执行b = 1语句，所以getB()返回的是变量b的默认值，所以输出结果是0。
	 */


	String str_android="Mozilla/5.0 (Linux; Android 5.0.2; PLK-AL10 Build/HONORPLK-AL10; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/53.0.2785.49 Mobile MQQBrowser/6.2 TBS/043632 Safari/537.36 MicroMessenger/6.5.8.1060 NetType/WIFI Language/zh_CN";

    String str_ios="Mozilla/5.0 (iPhone; CPU iPhone OS 11_1_2 like Mac OS X) AppleWebKit/604.3.5 (KHTML, like Gecko) Mobile/15B202 MicroMessenger/6.6.0 NetType/WIFI Language/zh_CN";

    String str_ipad="Mozilla/5.0 (iPad; CPU OS 8_2 like Mac OS X) AppleWebKit/600.1.4 (KHTML, like Gecko) Mobile/12D508 MicroMessenger/6.5.9 NetType/WIFI Language/zh_CN";

    public void zhengze(){
    	if(str_android.indexOf("Android")>-1){
			String p="(?<=Android)[\\s\\d.]{1,}";
			Pattern pattern = Pattern.compile(p);
			Matcher matcher = pattern.matcher(str_android);
			if(matcher.find()){
				System.out.println(matcher.group());
			}
		}
		if(str_ios.indexOf("iPhone")>-1){
			String p="(?<=iPhone OS)[\\s\\d_]{1,}";
			Pattern pattern = Pattern.compile(p);
			Matcher matcher = pattern.matcher(str_ios);
			if(matcher.find()){
				System.out.println(matcher.group().replaceAll("_","."));
			}
		}

		if(str_ipad.indexOf("iPad")>-1){
			String p="(?<=CPU OS)[\\s\\d_]{1,}";
			Pattern pattern = Pattern.compile(p);
			Matcher matcher = pattern.matcher(str_ipad);
			if(matcher.find()){
				System.out.println(matcher.group().replaceAll("_","."));
			}
		}

		String pWord = "([1-9a-zA-Z]+)|([a-zA-Z]+)|([0-9]+)";
		String pNumber = "[0-9]+";
		String pNumWord = "[1-9a-zA-Z]+";
		Pattern pattern = Pattern.compile(pWord);
		Matcher matcher = pattern.matcher("1");
		if(matcher.find()){
			System.out.println("111="+matcher.group());
		}

		String p = "(卫衣|外套|夹克|褂子|衣服|棉服|上衣|衬衫|打底衫|针织衫)+";
		Pattern pattern1 = Pattern.compile(p);
		Matcher matcher1 = pattern1.matcher("缪佳短袖女2018新款春夏新款韩版纯色短袖t恤女学生白色针织衫衣上服潮");
		if(matcher1.find()){
			System.out.println(matcher1.group());
		}
		String up="222";
		System.out.println(up.toUpperCase());


		}

	String strSize="${recommendShoes}${recommendPants}${recommendPants}${recommendPants}，但由于每个人的穿着习惯不同，最终由您决定哦/:^x^";


	public void jsonTest(){

		String a = "尺码表3";
		String b = "尺码表2";
		System.out.println("cc="+a.compareTo(b));

		Pattern pattern = Pattern.compile("\\$\\{([^\\}]+)\\}");
		Matcher matcher = pattern.matcher(strSize);
		String date = "2018-01-01~2018-04-01";
		String[] dates = date.split("~");
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date today = dateFormater.parse(dateFormater.format(new Date()));
			System.out.println(today.toString());
			System.out.println(today.compareTo(dateFormater.parse(dates[1])));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		while (matcher.find()) {
			String name = matcher.group(1);
			if(name.equals("recommendPants")){
				strSize = strSize.replaceFirst("\\$\\{recommendPants\\}","");
				System.out.println(strSize);
			}

		}

		String productType="[{\"paramId\":\"clothes\",\"paramValue\":\"{\\\"name\\\":\\\"衣服\\\", \\\"type\\\":\\\"select\\\",\\\"options\\\":[\\\"卫衣\\\",\\\"外套\\\",\\\"夹克\\\",\\\"T恤\\\",\\\"褂子\\\",\\\"衣服\\\",\\\"短袖\\\",\\\"棉服\\\",\\\"上衣\\\",\\\"衬衫\\\",\\\"打底衫\\\",\\\"针织衫\\\"]}\",\"orderNo\":\"1\"},{\"paramId\":\"pants\",\"paramValue\":\"{\\\"name\\\":\\\"裤子\\\", \\\"type\\\":\\\"select\\\",\\\"options\\\":[\\\"裤\\\"]}\",\"orderNo\":\"2\"},{\"paramId\":\"shoe\",\"paramValue\":\"{\\\"name\\\":\\\"鞋子\\\", \\\"type\\\":\\\"select\\\",\\\"options\\\":[\\\"鞋\\\",\\\"靴\\\"]}\",\"orderNo\":\"3\"}]";

        List<DefaultSizeProductTypeVo> typeVos = JSONObject.parseArray(replaceText(productType),DefaultSizeProductTypeVo.class);
        for(int i=0;i<typeVos.size();i++){
			System.out.println(typeVos.get(i).getParamValue().getName());
		}
	}

	private String replaceText(String text) {
		//将"xx":"{}"，替换成"xx":{}
		Pattern pattern = Pattern.compile("\"\\{");
		Matcher matcher = pattern.matcher(text);
		String s1 = matcher.replaceAll("\\{");

		Pattern pattern2 = Pattern.compile("}\"");
		Matcher matcher2 = pattern2.matcher(s1);
		String s2 = matcher2.replaceAll("}");

		Pattern pattern3 = Pattern.compile("\\\\\"");
		Matcher matcher3 = pattern3.matcher(s2);
		String s3 = matcher3.replaceAll("\"");
		return s3;
	}

	public void sort(){
		//这里的顺序，是我自己定义的一个List<String>
		String[] regulation = {"诸葛亮","鲁班","貂蝉","吕布"};
		final List<String> regulationOrder = Arrays.asList(regulation);
		String[] ordered = {"貂蝉","诸葛亮","吕布","貂蝉","鲁班","诸葛亮","貂蝉","鲁班","诸葛亮"};
		List<String> orderedList = Arrays.asList(ordered);

		Collections.sort(orderedList, new Comparator<String>()
		{
			public int compare(String o1, String o2)
			{
				int io1 = regulationOrder.indexOf(o1);
				int io2 = regulationOrder.indexOf(o2);
				return io1 - io2;
			}
		});
		System.out.println(orderedList.subList(0,9));
	}
}
