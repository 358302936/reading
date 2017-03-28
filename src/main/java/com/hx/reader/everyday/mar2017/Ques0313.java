package com.hx.reader.everyday.mar2017;

public class Ques0313 {

	public static void main(String[] args) {
		System.out.println("before try");
//		try {
//			
//		} catch (IOException e) {
//			System.out.println("IOException catch");
//		}
		System.out.println("End");
		//代码编译错误，因为无异常输出。在示例中，因为try语句块中无任何代码可产生IO异常，也就是说不会因为异常而抛出IO异常，所以catch语句块永远得不到执行，因此产生编译错误。
	}
}
