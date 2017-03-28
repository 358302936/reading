package com.hx.reader.everyday.feb2017;

public class Ques0213 {
	
	final int num = 1;
	/**
	 * 因为num变量被final修饰，即是一个常量，在使用前必须先初始化，否则会引起编译错误。
	 */
	
	public Ques0213(){
		System.out.println(num+10);
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Ques0213 q = new Ques0213(); 
		
	}
}
