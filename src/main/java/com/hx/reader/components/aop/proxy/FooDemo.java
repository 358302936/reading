package com.hx.reader.components.aop.proxy;

import org.springframework.cglib.proxy.Proxy;

public class FooDemo {

	public static void main(String[] args) {
		// 1.通用的动态代理实现
		CommonInvocationHandler handler = new CommonInvocationHandler();
		
		Foo f;
		// 2.接口实现1 
		handler.setTarget(new FooImpl());
		
		
		f = (Foo)Proxy.newProxyInstance(Foo.class.getClassLoader(),new Class[]{Foo.class}, handler);
		
		f.doAction();
		// 3.接口实现2 
		handler.setTarget(new FooImpl2());
		
		f = (Foo)Proxy.newProxyInstance(Foo.class.getClassLoader(), new Class[]{Foo.class}, handler);
		
		f.doAction();
	}
}
