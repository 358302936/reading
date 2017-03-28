package com.hx.reader.everyday.mar2017;

public class Ques0302 {
	public static void main(String[] args) {
        String str1 = new String("123");
        String str2 = new String("123");
        str1 = str1 + 1;  // 1
        str1 = null;  // 2
        str2 = str2 + str1;  // 3
        // 4
    }
	
	/**
	 * Q:请问在何处垃圾回收器可能最先启动？
	 * A:在注释4处之前。
		  一般我们可以通过赋值一个引用变量的值为null使其符合垃圾回收器的条件，但并没有销毁该对象，并且也不能立即启动垃圾回收器，
		  在例子中，str1虽然被赋值为null，但在之后str2 = str2 + str1;使用了该变量，因此在注释3处之前即使垃圾回收器启动也是不会销毁变量str1。
	 */
}
