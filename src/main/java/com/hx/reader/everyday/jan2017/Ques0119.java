package com.hx.reader.everyday.jan2017;

import java.util.Arrays;
import java.util.List;

public class Ques0119 {

	//ԭ����
	public static <T> T[] toArray(List<T> list){
		T[] t = (T[])new Object[list.size()];
		for(int i=0,s=list.size();i<s;i++){
			t[i] = list.get(i);
		}
		return t;
	}
	
	//���͹̶���ķ���
	public static String[] toArray1(List<String> list){
		String[] t = (String[])new String[list.size()];
		for(int i=0,s=list.size();i<s;i++){
			t[i] = list.get(i);
		}
		return t;
	}
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("1","2");
		for(String str : toArray1(list)){
			System.out.println(str);
		}
	}
	
	/**
	 * 一是数组只有在确定容器的所有元素类型与期望的类型有父子关系时才能转换，Object数组不能确保里面存的就是String的父类型或子类型，
	 * 所以报类型转换异常；其次是在toArray方法的“T[] t = (T[]) new Object[list.size()]”这段代码会在编译其被类型擦除，toArray方法编译后如下：
		public static Object[] toArray(List list){
		    Object[] t = (Object[]) new Object[list.size()];    
		    for (int i = 0, s = list.size(); i < s; i++) {
		        t[i] = list.get(i);
		    }    return t;
		}
		
		public static void main(String[] args) {
		    List<String> list = Arrays.asList("1", "2");    
		    for (String str : (String[])toArray(list)) {
		        System.out.println(str);
		    }
		}
             从上面看出toArray方法返回后会进行一次类型转换，Object数组转换成了String数组，所以报了ClassCastException异常。
	 */
}
