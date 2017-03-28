package com.hx.reader.everyday.mar2017;

public class Ques0309 {

	public void Test(int i){
		System.out.println("Int:"+i);
	}
	
	public void Test(String str){
		System.out.println("String:"+str);
	}
	
	public static void main(String[] args) {
		Ques0309 test = new Ques0309();
		char c='c';
		test.Test(c);
	}
	/**
	 * 字符型在Java实质是16位无符号整数，在例子中，将一个字符传入Test(int i)不会产生编译错误，系统会自动将字符值转为32位的整数值。
	 */
}
