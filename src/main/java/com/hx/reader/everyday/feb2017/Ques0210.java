package com.hx.reader.everyday.feb2017;

public class Ques0210 {
	
	public static void change(String str,char ch[]){
		str="Change";
		ch[0]='C';
	}
	
	public static void main(String[] args) {
		String str = new String("World");
		
		char ch[] = {'W','o','r','l','d'};
		
		change(str, ch);
		
		System.out.println(str+"and"+new String(ch));
	}
	
	/**
	 * Java中参数传递是采用值传递的方式，即传递的是参数的副本，如果 是引用型，引用不会被方法改变，但引用的对象内容可以被方法改变，
	 * 例子中str是字符串的引用，因此字符串的内容没有被改变，而在change方法中改变的是引用变量ch引用的数组对象的内容，即字符数组的元素，所以字符数组的内容变为Corld。
	 * 
	 */
	
}
