package com.hx.reader.everyday.mar2017;

public class Ques0310 {

	static void test(){
		System.out.println("test method in parent class");
	}
	
	public static void main(String[] args) {
		Ques0310 parent = new Ques0310();
		//Ques0310 parent1 = null;
		parent.test();
		
		Ques0310Sub sub = new Ques0310Sub();
		sub.test();
		
		parent = sub;
		parent.test();
		
		
		sub = (Ques0310Sub)parent;
		sub.test();
	}
}
