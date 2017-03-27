package com.hx.reader.components.shiro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.util.WebUtils;
import org.json.JSONObject;

import com.hx.reader.components.ReturnData;

/**
 * 用户拦截器，用户已经身份验证/记住我登录的都可
 * @author chuhx
 * @version 20160329
 */
public class UserLevelFilter extends UserFilter  {

	/**
	     * Returns <code>true</code> if the request is a
	     * {@link #isLoginRequest(javax.servlet.ServletRequest, javax.servlet.ServletResponse) loginRequest} or
	     * if the current {@link #getSubject(javax.servlet.ServletRequest, javax.servlet.ServletResponse) subject}
	     * is not <code>null</code>, <code>false</code> otherwise.
	     *
	     * @return <code>true</code> if the request is a
	     * {@link #isLoginRequest(javax.servlet.ServletRequest, javax.servlet.ServletResponse) loginRequest} or
	     * if the current {@link #getSubject(javax.servlet.ServletRequest, javax.servlet.ServletResponse) subject}
	     * is not <code>null</code>, <code>false</code> otherwise.
	     */
	    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
	        if (isLoginRequest(request, response)) {
	            return true;
	        } else {
	            Subject subject = getSubject(request, response);
	            // If principal is not null, then the user is known and should be allowed access.
	            return subject.getPrincipal() != null;
	        }
	    }
	
	    /**
	     * This default implementation simply calls
	     * {@link #saveRequestAndRedirectToLogin(javax.servlet.ServletRequest, javax.servlet.ServletResponse) saveRequestAndRedirectToLogin}
	     * and then immediately returns <code>false</code>, thereby preventing the chain from continuing so the redirect may
	     * execute.
	     */
	    @SuppressWarnings("deprecation")
		protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
	        //saveRequestAndRedirectToLogin(request, response);
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
	    		System.out.println(httpRequest.getRequestURL());
	    	}
	    	httpResponse.setStatus(200, "redirect");
	    	httpResponse.setCharacterEncoding("UTF-8");
	    	httpResponse.setContentType("application/json; charset=utf-8");  
	    	PrintWriter out = null;
	    	
	    	try{
	    		out = httpResponse.getWriter(); 
	    		ReturnData ret = ReturnData.newRedirectReturnData();
	    		ret.setMessage("用户已过期，请重新登录！");
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
