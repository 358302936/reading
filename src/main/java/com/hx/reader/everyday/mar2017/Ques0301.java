package com.hx.reader.everyday.mar2017;

public class Ques0301 {

	private int a = getB();
	private int b = 1;

	public int getB() {
		return b;
	}
	
	public static void main(String[] args) {
		System.out.println(new Ques0301().a);
	}
	
	/**
	 * 在系统装载类时，会先初始化各成员变量，根据变量类型赋默认值，例子中，在执行类体语句前，成员变量a、b已被赋值为0，
	 * 在执行a = getB()时，因为还未执行b = 1语句，所以getB()返回的是变量b的默认值，所以输出结果是0。
	 */
}
