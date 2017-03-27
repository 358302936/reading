package com.hx.reader.everyday.feb2017;

public class Ques0221 extends Ques0221Parent{

	public static void main(String[] args) {
		final Ques0221Parent p = new Ques0221Parent("aaa");
//		p = new Ques0221Parent("bbb");
		p.str="ccc";
		System.out.println(p.str);
	}
	
	/**
	 * final变量是一个常量，被创建后就不能再改变，如果该final变量是一个引用型变量，则不能再引用其他对象。
	 * 在例子中，引用型final变量p因为已经初始化指向对象Parent("aaa")，就不能再指向新的对象Parent("bbb")，所以会产生编译错误。
	 */
}
