package com.hx.reader.everyday.jan2017;

import java.util.ArrayList;
import java.util.List;

public class Ques0112 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Number[] numbers = new Integer[10];
		numbers[0]=1;
//		List<Number> list = new ArrayList<Integer>();
		List<? extends Number> list = new ArrayList<Integer>();
		/**
		 * 代码2处不能编译通过，在Java中泛型是不支付协变的，协变就是指使用窄类型替代宽类型。虽然Integer是Number的子类型，
		 * 但是Java为了保证运行期的安全性，必须保证泛型参数类型是固定的，所以它不允许一个泛型参数可以同时包含两种类型，即使是父子类关系也不行。虽然泛型不支持协变，但可以使用通配符模拟协变，
		 * 代码如下:List<? extends Number> list = new ArrayList<Integer>();
		 * “? extends Number”表示允许Number所有的子类作为泛型参数类型，但在运行期只能是一个具体类型（比如Integer、Double类型），通配符只是在编码期有效，运行期必须是一个确定类型。
		 */
		
	}
}
