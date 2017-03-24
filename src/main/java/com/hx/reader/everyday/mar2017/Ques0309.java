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
}
