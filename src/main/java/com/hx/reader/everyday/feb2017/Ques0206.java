package com.hx.reader.everyday.feb2017;

public class Ques0206 {

	//protected修饰的方法，只要在同一个包中的类，都可以访问，当然也包括子类
	public static void main(String[] args) {
		Ques0206SubOther subOther = new Ques0206SubOther();
		subOther.method();
		
		Ques0206Other other = new Ques0206Other();
		other.method();
	}
}
