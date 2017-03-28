package com.hx.reader.everyday.mar2017;

public class Ques0321 {

	 public static void main(String[] args) {
	        Ques0321 test = new Ques0321();
	        test.method(null);
	    }    
	    
	    public void method(Object o) {
	        System.out.println("Object");
	    }    
	    
//	    public void method(String s) {
//	        System.out.println("String");
//	    }
	    
	    public void method(Integer s) {
	        System.out.println("Integer");
	    }
	    
	    public void method(int s) {
	        System.out.println("int");
	    }
	    
	    /**
	     * 当传入null时能同时满足method(Object o)和method(String s)两个方法，但String是Object的子类，
	     * 系统调用是处理更具体、更有针对性的method(String s)方法，所以最终输出String。
	     * 
	     * 如果同时有method(String s),method(Integer s) 两个方法，因为String,Integer都是Object的子类，
	     * 而String，Integer又没有集成关系，导致test.method(null)不知道选择哪个一个，而编译报错
	     */
}
