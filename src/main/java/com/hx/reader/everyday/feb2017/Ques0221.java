package com.hx.reader.everyday.feb2017;

public class Ques0221 extends Ques0221Parent{

	public static void main(String[] args) {
		final Ques0221Parent p = new Ques0221Parent("aaa");
//		p = new Ques0221Parent("bbb");
		p.str="ccc";
		System.out.println(p.str);
	}
	
	/**
	 * final ������һ����������������Ͳ����ٸı䣬�����final������һ�������ͱ�����������������������
	 * �������У�������final����p��Ϊ�Ѿ���ʼ��ָ�����Ques0221Parent("aaa"),�Ͳ�����ָ���µĶ���Ques0221Parent("bbb")�����Ի�����������
	 */
}
