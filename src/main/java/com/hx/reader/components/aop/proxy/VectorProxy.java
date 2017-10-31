package com.hx.reader.components.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VectorProxy implements InvocationHandler{

	private final static Logger log = LoggerFactory.getLogger(VectorProxy.class);
	
	private Object obj=null;
	
	public VectorProxy(){
		
	}
	
	public VectorProxy(Object obj){
		this.obj=obj;
	}
	
	public static Object factory(Object obj){
		Class<?> cls = obj.getClass();
		return Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), new VectorProxy(obj));
	}
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		log.info("调用方法前："+method);
		if(args != null){
			for(int i=0;i<args.length;i++){
				log.info(i+"参数："+args[i].toString());
			}
		}
		Object object = method.invoke(obj, args);
		
		log.info("调用方法后:"+method);
		return object;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List<String> v = (List<String>)factory(new Vector<String>(10));
		v.add("杭州");
		v.add("上海");
		log.info(v.toString());
		
		v.remove(0);
		log.info(v.toString());
	}

}
