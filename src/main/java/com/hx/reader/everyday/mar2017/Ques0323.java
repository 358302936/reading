package com.hx.reader.everyday.mar2017;

public class Ques0323 {

	final String s = "outer class member variable";    
    
    public void Method() {
        String s1 = "inner class variable";        
        @SuppressWarnings("unused")
		class InnerClass {            
            public void innerMethod() {                
                int test = 20;
                System.out.println(s);
                System.out.println("Integer value is:"+test);
                System.out.println(s1);
            }
        }
    }
}
