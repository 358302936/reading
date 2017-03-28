package com.hx.reader.everyday.mar2017;

public class Ques0303 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
        boolean flag = false;        
        if (flag = true) {
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
	/**
	 * 请问能否正常编译输出？编译通过的话输出结果是什么？
	 * 这里是因为if表达式里不是一个比较表达式而是一个赋值表达式，if表达式只要其最终运算结果是一确定的布尔型数值即可，不一定就要是逻辑表达式，
	 * 例子中因为flag被赋值为true，所以最后输出的是true。
	 */
}
