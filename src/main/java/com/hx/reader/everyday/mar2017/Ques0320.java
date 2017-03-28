package com.hx.reader.everyday.mar2017;

public class Ques0320 {

	int num;    
    void Test() {
        num = 1;
        System.out.println(num);
    }

    Ques0320(int i) {
        num = i;
        System.out.println(num);
    }    
    
    //后来新增，原题没有
    public Ques0320() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
        Ques0320 test1 = new Ques0320();
        Ques0320 test2 = new Ques0320(111);
    }
	
	/**
	 * 首先要知道构造方法是没有返回值的，即使返回类型声明为void也会产生编译错误，因为将其视为普通 方法，而不是构造方法。
	 * 本例中，定义了有参的构造方法，而没有定义无参的构造方法，调用无参构造方法时会报notFoundMethodException
	 */
}
