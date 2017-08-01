package com.hx.reader.study.inner;

public class C {

	private class A1 extends A{
		public void showA(){
			super.showA();
		}
	}
	
	private class B1 extends B{
		public void showB(){
			super.showB();
		}
	}
	
	public void showA(){
		new A1().showA();
	}
	
	public void showB(){
		new B1().showB();;
	}
}
