package com.hx.reader.components.apiVersion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

//拦截器的注册
@Configuration
public class WebConfig extends WebMvcConfigurationSupport{

	@Override  
    @Bean  
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {  
        RequestMappingHandlerMapping handlerMapping = new CustomRequestMappingHandlerMapping();  
        handlerMapping.setOrder(0);  
        handlerMapping.setInterceptors(getInterceptors()); 
        Object[] objs = getInterceptors();
        System.out.println(objs.length);
        System.out.println(getInterceptors().toString());
        return handlerMapping;  
    }  
}
