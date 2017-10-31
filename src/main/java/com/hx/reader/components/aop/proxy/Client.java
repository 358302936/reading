package com.hx.reader.components.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {

	public static void main(String[] args) {
		RealSubject rs = new RealSubject();
		InvocationHandler ds = new DynamicSubject(rs);
		Class<?> cls = rs.getClass();
		
		Subject sub = (Subject)Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), ds);
		sub.request();
	}

}
