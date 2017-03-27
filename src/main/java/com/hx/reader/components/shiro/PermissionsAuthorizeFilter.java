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
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.json.JSONObject;

import com.hx.reader.components.ReturnData;

/**
 * 权限拦截
 * @author chuhx
 * @Date 2016年11月3日
 */
public class PermissionsAuthorizeFilter extends PermissionsAuthorizationFilter {

	 //TODO - complete JavaDoc

    @SuppressWarnings("deprecation")
	public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {

        Subject subject = getSubject(request, response);
        String[] perms = (String[]) mappedValue;

        boolean isPermitted = true;
        if (perms != null && perms.length > 0) {
            if (perms.length == 1) {
                if (!subject.isPermitted(perms[0])) {
                    isPermitted = false;
                }
            } else {
                if (!subject.isPermittedAll(perms)) {
                    isPermitted = false;
                }
            }
        }
        if(!isPermitted){
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
	    		out = httpResponse.getWriter(); 
	    		ReturnData ret = ReturnData.newRedirectReturnData();
	    		ret.setMessage("用户权限不足，试图访问！");
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
        }
        return isPermitted;
    }
}
