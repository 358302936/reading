package com.hx.reader.components.aop.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RealSubject implements Subject{

    private final static Logger log = LoggerFactory.getLogger(RealSubject.class);

    
    public RealSubject(){
    	
    }
    
	@Override
	public void request() {
		log.info("实际做事的人！");
	}

}
