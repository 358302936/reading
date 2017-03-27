package com.hx.reader.components.shiro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.authc.PassThruAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.json.JSONObject; 

import com.hx.reader.components.ReturnData;

/**
 * 基于表单的拦截器；如“/**=authc”，如果没有登录会跳到相应的登录页面登录；主要属性：usernameParam：表单提交的用 户 名 参 数 名 （ username ） ；
 * passwordParam：表单提交的密码参数名（password）； rememberMeParam：表单提交的密码参数名（rememberMe）；loginUrl：登录页面地址（/login.jsp）；
 * successUrl：登录成功后的默认重定向地址； failureKeyAttribute：登录失败后错误信息存储 key（shiroLoginFailure）
 * @author chuhx
 * @version 20160329
 */
public class AuthcLevelFilter extends PassThruAuthenticationFilter {

	@SuppressWarnings("deprecation")
	@Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
    	HttpServletResponse httpResponse ;
    	HttpServletRequest httpRequest;
    	Map<String, Object> map = new HashMap<String, Object>();
    	httpResponse = WebUtils.toHttp(response); 
    	httpRequest = WebUtils.toHttp(request); 
    	
    	if(isLoginRequest(httpRequest, httpResponse)){
    		return true;
    	}else{    	
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
	    	map.put("requestWXUrl", "../html/last.html");
	    	httpResponse.setStatus(200, "redirect");
	    	httpResponse.setCharacterEncoding("UTF-8");
	    	httpResponse.setContentType("application/json; charset=utf-8");  
	    	System.out.println(httpRequest.getRequestURL());
	    	PrintWriter out = null;
	    	
	    	try{
	    		out = httpResponse.getWriter(); 
	    		ReturnData ret = ReturnData.newRedirectReturnData();
	    		ret.setMessage("用户未认证，试图访问！");
    			ret.setData(httpResponse.toString());
    			ret.setMap(map);
	    		JSONObject responseJSONObject = new JSONObject(ret);
	    		out.append(responseJSONObject.toString());
	    	}catch(IOException e){
	    		e.printStackTrace();
	    	}finally {  
	    		 if (out != null) {  
	    			 out.close();  
	    		}  
	    	}        	
	        return false;	
    	}
    }
}
