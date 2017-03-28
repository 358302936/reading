package com.hx.reader.everyday.feb2017;

public class Ques0223 {

	public static void main(String[] args) {
		Ques0223Parent parent = new Ques0223Parent();
        parent.sum(1, 2);

        Ques0223Sub sub = new Ques0223Sub();
//        sub.sum(1, 2);出错
        int[] a = new int[2];
        sub.sum(1,a);
    }
	/**
	 * sub.sum(1, 2);这行代码报错，在例子代码中，parent对象把子类对象Sub做了向上转型，所以此时形参列表是由父类决定的，由于是变长参数，
	 * 在编译时，sum(1, 2)中的“2”这个实参会被编译器编译成“{2}”数组，再由子类Sub执行；但是在直接调用子类的例子中，这时编译器并不会把“2”做类型转化，
	 * 因为数组本身也是一个对象，两个完全没继承关系的类之间做转换编译器肯定是做不到的
	 */
}
