package com.hx.reader.everyday.mar2017;

public class Ques0316 {
	
	String str = "string";

    public static void main(String[] args) {        
    	Ques03162 clz2 = new Ques03162();
        clz2.display();
    }
    
    /**
     * 输出 str1
     * 由于子类Ques03162实例clz2中调用的display()方法是继承自父类Ques03161中的，因为display()方法只能对同类上的类成员变量str进行访问，所以最终输出的是str1。
     */
}
