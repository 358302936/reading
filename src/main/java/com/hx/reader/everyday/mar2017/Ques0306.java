package com.hx.reader.everyday.mar2017;

public class Ques0306 {

	static int i=1;
	
	static{
		++i;
	}
	
	public static void main(String[] args) {
		increment(i,3);
		display(i);
	}
	
	static void increment(int n,int m){
		n+=m;
	}
	
	static void display(int n){
		System.out.println(n);
	}
	
	static{
		++i;
	}
	/**
	 * 在static{后面跟着一段代码，这是用来进行显式的静态变量初始化，这段代码只会初始化一次，且在类被第一次装载时就先执行，无论静态代码块在什么位置。
	 * 
	 * java只支持值传递。
	 */
}
