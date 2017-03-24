package com.hx.reader.everyday.mar2017;

public class Ques0307 {

	private String s1 = "Ques0307 string";
	
    class InnerClass{
    	private String s2="inner string";
    	
    	public void innerMethod(){
    		System.out.println(s1);
    		System.out.println(s2);
    	}
    }
    
    public static void outerMethod(){
    	Ques0307.InnerClass inner = new Ques0307().new InnerClass();
    	inner.innerMethod();
    }
    
    public static void main(String[] args) {
		outerMethod();
	}
    
    //���ھ�̬�����ڲ����÷Ǿ�̬����������ͨ����ʵ�������á�
}
