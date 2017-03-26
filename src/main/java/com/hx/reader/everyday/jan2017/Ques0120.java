package com.hx.reader.everyday.jan2017;

import java.util.Arrays;
import java.util.List;

public class Ques0120 {

	public static void main(String[] args) {
		Ques0120 q = new Ques0120();
		q.listsize();
		q.listsize1();
	}
	
	public void listadd(){
		List<String> list = Arrays.asList("张三","李四");
		list.add("王五");
		System.out.println("列表的元素数量是："+list.size());
		/**
		 * 注意这里用add会出错，因为是arrays.aslist中，看代码可以看到这里返回的ArrayList不是原来的传统意义上的java.util.arraylist了，
		 * 而是自己工具类的一个静态私有内部类，并没有提供add方法，要自己实现，所以这里是出错了，
		 * 因此，除非确信array.aslist后长度不会增加，否则谨慎使用：List abc=Arrays.asList("a","b","c"),因为这样的长度是无法再add的了
		 */
	}
	
	public void listsize(){
		int[] data = {1,2,3,4,5};
		List list = Arrays.asList(data);
		System.out.println("列表的元素数量是" + list.size());
	/**
	 * 注意这里输出的数量是1，原因是，在Arrays.asList中，该方法接受一个变长参数，一般可看做数组参数，
	 * 但是因为int[] 本身就是一个类型，所以data变量作为参数传递时，编译器认为只传了一个变量，这个变量的类型是int数组，
	 * 所以size为1。基本类型是不能作为泛型的参数，按道理应该使用包装类型，但这里缺没有报错，因为数组是可以泛型化的，所以转换后在list中就有一个类型为int的数组
	 */
	}
	
	public void listsize1(){
		Integer[] data = {1,2,3,4,5};
		List list = Arrays.asList(data);
		System.out.println("列表的元素数量是" + list.size());
		/**
		 * 5，说明编译器对Integer[] 处理不一样。Integer是可变长参数。传入过程中asList()方法实际是将Integer数组里的元素进行存储。
		 */
	}
}
