package com.hx.reader.everyday.jan2017;

import java.util.ArrayList;
import java.util.List;

public class Ques0112 {

	public static void main(String[] args) {
		Number[] numbers = new Integer[10];
		numbers[0]=1;
//		List<Number> list = new ArrayList<Integer>();
		//��java�з����ǲ�֧��Э��ģ�Э����ָʹ��խ������������ͣ�����javaΪ�˱�֤�����ڼ�İ�ȫ�ԣ����뱣֤���Ͳ��������ǹ̶��ģ�������������һ�����Ͳ�������ͬʱ�����������ͣ�
		//��ʹ�Ǹ������ϵҲ����
		//��Ȼ���Ͳ�֧��Э�䣬������ʹ��ͨ���ģ��Э�䣬�������£�
		List<? extends Number> list = new ArrayList<Integer>();
		//? extends Number ��ʾ����number���Ե�������Ϊ���Ͳ������ͣ����������ڼ�ֻ����һ���������ͣ�Integer,Double��,ͨ���ֻ���ڱ�������Ч�������ڱ�����һ��ȷ������
	}
}
