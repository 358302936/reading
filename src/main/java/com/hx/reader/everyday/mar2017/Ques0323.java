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
    
    public static void main(String[] args) {
		Ques0323 q = new Ques0323();
		q.Method();
	}
    /**
     * 一个定义在方法体中的内部类只能访问方法中定义的被声明为final的局部变量，原因在于定义在方法体的变量会随着方法的退出而消亡，
     * 通过定义其为final变量，可以扩展其生命周期，可与访问其类实例的生命周期相配合，例子中只要将变量s1改为final变量才能使代码编译成功。
     */
}
