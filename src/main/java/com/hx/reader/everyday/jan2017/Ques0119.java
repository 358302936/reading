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
	 * �����򱨴���Ҫ���������⣺
	 * 1������ֻ����ȷ������������Ԫ�������������������и��ӹ�ϵʱ����ת����Object���鲻��ȷ�������ľ���String�ĸ����ͻ������ͣ����б�����ת���쳣��
	 * 2������toArray�ŵ�"T[] t = (T[])new Object[list.size()]",��δ�����ڱ��뱻���Ͳ�����toArray������������£�
	 *  public static Object[] toArray(List list){
		Object[] t = (Object[])new Object[list.size()];
		for(int i=0,s=list.size();i<s;i++){
			t[i] = list.get(i);
		}
		return t;
	   }
	   �����濴��toArray�������غ�����һ������ת����Object����ת������String���飬���Ա���ClassCastException�쳣
	 */
}
