package com.hx.reader.components.aop.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.InvocationHandler;


public class CommonInvocationHandler implements InvocationHandler{

	private Object target;
	
	//支持空构造函数
	public CommonInvocationHandler(){
		
	}
	
	//支持构造函数注入
	public CommonInvocationHandler(Object obj){
		this.target = obj;
	}
	
	//支持setter方法注入
	public void setTarget(Object target) {
		this.target = target;
	}
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		return method.invoke(target, args);
	}

}
