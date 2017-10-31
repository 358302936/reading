package com.hx.reader.components.aop.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FooImpl2 implements Foo{

	private final static Logger log = LoggerFactory.getLogger(FooImpl2.class);
	
	@Override
	public void doAction() {
		log.info("实现方法2");
	}

}
