package com.hx.reader.everyday.mar2017;

public class Ques0322Super {
	int index = 1;    
    public void print() {
        System.out.println("Super");
    }
    
    /**
     * 打印输出1，Sub。
	         因为存在重载方法print()，执行sup.print()调用的是子类Ques0322Sub上定义的print()方法，而不是定义在父类Ques0322Super上的print()，尽管变量sup声明时是Ques0322Super类，
	         即在编译时变量sup引用 的是一个Ques0322Super对象，但由于Java在运行时赋予变量sup的是一个Ques0322Sub对象，所以运行时变量sup实际指向的是一个Ques0322Sub对象，
	         在运行sup.print()时，动态绑定子类的print()方法，打印出Sub对象，而sup.index是在编译期就决定了直接对属性的调用，因此输出的是父类中的值。
     */
}
