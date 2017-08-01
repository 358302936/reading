package com.hx.reader.study.inner;

public class Son extends Parent{

	@Override
	public void show() {
		System.out.println("抽象类中的打印方法");
	}

	private class Inner implements Ishow{

		@Override
		public void show() {
			System.out.println("接口中的打印方法");
		}
		
	}
	
	public void show2(){
		Inner inner = new Inner();
		inner.show();
	}
}
