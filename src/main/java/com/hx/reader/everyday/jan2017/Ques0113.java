package com.hx.reader.everyday.jan2017;

public class Ques0113 {
	
	//无法正常编译通过，id被final修饰，不能在一般的方法中赋值，要么一开始直接初始化，要么就在构造函数中初始化，且赋值后就不能被修改。
	@SuppressWarnings("unused")
	private final String id ;
//	public void setId(String id){
//		this.id=id;
//	}
	
	
	public Ques0113(){
		this.id="1";
		System.out.println("构造函数");
	}
	
}
