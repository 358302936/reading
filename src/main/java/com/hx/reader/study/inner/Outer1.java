package com.hx.reader.study.inner;

public class Outer1 {

	private String name = "张三";
	private int age1 = 19;
	
	public void outerShow(){
		System.out.println("姓名："+name);
		System.out.println("年龄："+age1);
//		System.out.println("内部年龄："+age2);//外部类不能直接访问内部类成员属性
		
		Inner1 inner = new Inner1();
		System.out.println("内部年龄："+inner.age2);
	}
	
	public class Inner1{
		
		private String name = "李四";
		private int age2 = 20;
		//private static int sex = 1;//The field sex cannot be declared static in a non-static inner type, unless initialized with a constant expression
		public void innerShow(){
			//成员内部类可以访问外部类的属性（包括私有的）
			System.out.println("姓名："+Outer1.this.name);
			System.out.println("姓名："+name);
			System.out.println("年龄："+age2);
			//成员内部类可以访问外部类的方法（包括私有的）
			outerShow();
		}
	}
	
}
