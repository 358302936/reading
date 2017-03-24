package com.hx.reader.everyday.jan2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ques0117 {
	
	public static void main(String[] args) {
		List list = Ques0117.asList(1,2,3.0);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		/**
		 * list���ͻ���������Integer��Float�ĸ���Number������������������ƶϣ����������ֶ��Ԫ�ص�ʵ�����Ͳ�һ��ʱ�ͻ�ֱ��ȷ�Ϸ�������ΪObject,
		 * ������ȥ׷��Ԫ����Ĺ���������ʲô���������list�ķ��Ͳ�����Number�Ļ������������޸�
		 */
		List<Number> listN = Ques0117.<Number>asList(1,2,3.0);
		//�������������ת��ΪNumber,��ô���صĽ������list<Number>������
	}
	
	public static<T> List<T> asList(T... t){
		List<T> list = new ArrayList<T>();
		Collections.addAll(list, t);
		return list;
	}
}
