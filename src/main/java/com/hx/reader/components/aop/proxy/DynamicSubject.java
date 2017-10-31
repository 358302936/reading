package com.hx.reader.components.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynamicSubject implements InvocationHandler{

	private final static Logger log = LoggerFactory.getLogger(DynamicSubject.class);
	
	private Object obj;
	
	public DynamicSubject(Object obj){
		this.obj=obj;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		log.info("调用前："+method);
		
		method.invoke(obj, args);
		
		log.info("调用后："+method);
		return null;
	}

}
