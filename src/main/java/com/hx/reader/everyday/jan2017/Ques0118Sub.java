package com.hx.reader.everyday.jan2017;

public class Ques0118Sub extends Ques0118Parent{
	@Override
	public Ques0118Sub method1(){
		return new Ques0118Sub();
	}
//	@Override
//	public void method2(Ques0118P s){
//	}
	
	@Override
	public void method2(Ques0118Parent p){
	}
	
	/**
	 * Sub中的两个方法都有 @Override注释，本意是想重写父类的方法。method2方法的参数类型不对，不能重写父类的方法，所以报错。
	 * 如果 method2没有使用 @Override注释，编译是可以通过的，但此时子类中的 method2和父类中的 method2就不是重写的关系。
	 */
}
