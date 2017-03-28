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
    
    //想在静态方法内部调用非静态方法，必须通过 类实例来引用。在例子中，静态方法main()中调用内部类InnerClass的innerMethod()方法，
    //就必须要获得内部类InnerClass的实例，而要想获得内部类InnerClass的实例，又要通过外部类OuterClass的实例来获得，
    //所以只有通过new OuterClass().new InnerClass()表达式可正确实现对innerMethod()方法的调用。
}
