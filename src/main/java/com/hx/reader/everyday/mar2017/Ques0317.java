package com.hx.reader.everyday.mar2017;

public class Ques0317 {

	public static void main(String[] args) {
        Ques0317 test = new Ques0317();
         /**
          * 编译出现错误，因为method(StringBuffer sb)和method(String s)两个方法的参数类型StringBuffer类和String类之间不存在继承关系，
          * 其传入参数值null时均可传入这两个方法，在系统调用方法时，会产生无法调用哪一个方法的编译错误。
          */
        //test.method(null);  
        test.method("");
        test.intMethod(null);
     }    
    
    public void method(StringBuffer sb) {
        System.out.println("StringBuffer");
    }    
    
    public void method(String s) {
        System.out.println("String");
    }
    
    public void intMethod(Integer i){
    	System.out.println("输出Integer:"+i);
    }
    public void intMethod(int i){
    	System.out.println("输出int:"+i);
    }
}
