package com.hx.reader.everyday.jan2017;

public class Ques0116 {

	public static void main(String[] args) {
		System.out.println(new Ques0116_BigDog("大黑狗", "黑色"));
		/**
		 * 主程序编译不通过。如果一个类没有写构造函数时，系统会默认给该类添加一个没有参数的构造函数；如果一个类写了构造函数，那么系统就不会给该类在添加默认的构造函数。
		 * 当一个子类调用自己的构造函数时，会先去调用父类的构造函数；如果没有用super（参数…）进行明显的调用父类的构造函数，
		 * 那么它会默认调用super（）父类默认的构造函数，所以当父类中添加了带参数的构造函数时，最好要写一个不带参数的构造函数，以便有子类继承时调用。
		 */
	}
}
