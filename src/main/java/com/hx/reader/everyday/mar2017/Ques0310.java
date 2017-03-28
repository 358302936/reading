package com.hx.reader.everyday.mar2017;

public class Ques0310 {

	static void test(){
		System.out.println("test method in parent class");
	}
	
	@SuppressWarnings("static-access")
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
	/**
	 * 在例子中，尽管引用变量parent引用的对象是子类实例，但在表达式sub=parent行处，在没有明确造型为子类的前提下，直接把一个父类变量赋予子类变量，会因违反造型规则，产生编译错误，
	 * 正确语句是sub = (Sub) parent;
	 */
}
