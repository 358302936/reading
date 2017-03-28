package com.hx.reader.everyday.jan2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ques0117 {
	
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public static void main(String[] args) {
		List list = Ques0117.asList(1,2,3.0);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		/**
		 * list泛型化参数不是Integer和Float的父类Number，编译器并不会如此推断，当它发现多个元素的实际类型不一致时就会直接确认泛型类型为Object，
		 * 并不会去追索元素类的公共父类是什么，如果想让list的泛型参数是Number的话可以做如下修改：List<Number> list = Ques0117.<Number>asList(1, 2, 3.0);
		 * 将输入参数向上转型为Number，那么返回的结果就是List<Number>类型了。
		 */
		List<Number> listN = Ques0117.<Number>asList(1,2,3.0);
	}
	
	@SuppressWarnings("unchecked")
	public static<T> List<T> asList(T... t){
		List<T> list = new ArrayList<T>();
		Collections.addAll(list, t);
		return list;
	}
}
