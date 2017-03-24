package com.hx.reader.everyday.feb2017;

public class Ques0209 {

	public static void add(Integer i){
		int value = i.intValue();
		value += 1;
		i = new Integer(value);
	}
	
	public static void main(String[] args) {
		Integer i = new Integer(0);
		add(i);
		System.out.println(i.intValue());
	}
	
	/**
	 * ��Java�У����еĲ������ݶ���ֵ���ݣ�Ҳ����˵������һ��������������ʱ��������õ��Ǵ��ݲ����ĸ�������һ������ʹ�����ñ����ĸ���������һ�����������ʱ���÷������ܸı����������ԭ�����ã�
	 * �����б���i������add()��ֵΪ1��ֻ���丱����ֵ1������ӡ����Ļ��Ǳ���i�ĳ�ʼֵ0��
	 */
}
