package com.hx.reader.everyday.feb2017;

public class Ques0207 {
  
	/**
	 * 编译无法通过，变量在使用前必须初始化，例子中在执行private int a = b;时，变量b不仅未初始化，还未声明，因此产生向后引用编译错误。
	 */
	
	//修改之前
//	private int a=b;
//	private int b=1;
	
	//修改之后	
	private int b=1;
	private int a=b;
	public static void main(String[] args) {
		System.out.println((new Ques0207()).a);
	}
}
