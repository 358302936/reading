package com.hx.reader.components.shiro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.servlet.AdviceFilter;
import org.apache.shiro.web.util.WebUtils;
import org.json.JSONObject;

import com.hx.reader.components.ReturnData;
import com.hx.reader.redis.RedisService;

public class SSOAdviceFilter extends AdviceFilter{

	public static SSOAdviceFilter ssoAdviceFilter;
	
	@Resource
	private RedisService redisService;
	
	public void setRedisServer(RedisService redisService) {
		this.redisService = redisService;
	}  
	
	@PostConstruct
	public void init(){
		ssoAdviceFilter = this;
		ssoAdviceFilter.redisService=this.redisService;
	}
	@SuppressWarnings("deprecation")
	@Override  
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {  
		
		boolean status = false;
		
		HttpServletResponse httpResponse ;
    	HttpServletRequest httpRequest;
    	Map<String, Object> map = new HashMap<String, Object>();
    	httpResponse = WebUtils.toHttp(response); 
    	httpRequest = WebUtils.toHttp(request); 
		WebUtils.saveRequest(request);
		if(httpRequest.getRequestURI() == null){
    		map.put("requestUri", "");
    	}else{
    		map.put("requestUri", httpRequest.getRequestURI());
    	}
    	if(httpRequest.getRequestURL() == null){
    		map.put("requestUrl", "");
    	}else{
    		map.put("requestUrl", httpRequest.getRequestURL());
    	}
    	
    	httpResponse.setStatus(200, "redirect");
    	httpResponse.setCharacterEncoding("UTF-8");
    	httpResponse.setContentType("application/json; charset=utf-8");  
    	PrintWriter out = null;
    	
    	try{
    		String sessionid = httpRequest.getSession().getId();    		
//    		List<String> info = redisService.lrange(sessionid);
    		String info = redisService.get(sessionid);
    		if(info.isEmpty()){
    			out = httpResponse.getWriter(); 
    			ReturnData ret = ReturnData.newRedirectReturnData();
    			ret.setMessage("用户已过期，请重新登录！");
    			ret.setData(httpResponse.toString());
    			ret.setMap(map);
    			JSONObject responseJSONObject = new JSONObject(ret);
    			out.append(responseJSONObject.toString());
    			status = false;
    		}else{
//    			for(int i=0,j=info.size();i<j;i++){
//    			}
				System.out.println(info);
    			
    			System.out.println("当前session:"+sessionid);
    			status = true;
    		}
    		
    	}catch(IOException e){
    		e.printStackTrace();
    	}finally {  
    		 if (out != null) {  
    			 out.close();  
    		}  
    	}        
    	return status;
    	
    }  
    @Override  
    protected void postHandle(ServletRequest request, ServletResponse response) throws Exception {  
        System.out.println("====后处理/后置返回处理");  
    }  
    @Override  
    public void afterCompletion(ServletRequest request, ServletResponse response, Exception exception) throws Exception {  
        System.out.println("====完成处理/后置最终处理");  
    }
}
