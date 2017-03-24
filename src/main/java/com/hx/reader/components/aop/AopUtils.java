package com.hx.reader.components.aop;

import org.springframework.stereotype.Controller;

@Controller
public class AopUtils {

	 public void LogBefore()
	    {
	        System.out.println("Log before method");
	    }
	    
    public void LogAfter()
    {
        System.out.println("Log after method");
    }
}
