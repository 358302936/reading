package com.hx.reader.everyday.feb2017;

public class Ques0209 {

	public static void add(Integer i){
		int value = i.intValue();
		value += 1;
		i = new Integer(value);
	}
	
	public static void main(String[] args) {
		Integer i = new Integer(0);
		add(i);
		System.out.println(i.intValue());
	}
	
	/**
	 * 在Java中，所有的参数传递都是值传递，也就是说当传递一个参数到方法中时，方法获得的是传递参数的副本，当一个方法使用引用变量的副本来访问一个对象的内容时，
	 * 该方法不能改变参数变量的原有引用，例子中变量i被方法add()增值为1，只是其副本增值1，而打印输出的还是变量i的初始值0。
	 */
}
