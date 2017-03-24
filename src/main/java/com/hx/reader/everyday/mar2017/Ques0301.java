package com.hx.reader.everyday.mar2017;

public class Ques0301 {

	private int a = getB();
	private int b = 1;

	public int getB() {
		return b;
	}
	
	public static void main(String[] args) {
		System.out.println(new Ques0301().a);
	}
	
	/**
	 * ��ϵͳװ����ʱ�����ȳ�ʼ������Ա���������ݱ������͸�Ĭ��ֵ���ڱ������У���ִ���������֮ǰ����Ա����a,b�Ѿ�������ֵ0��
	 * ��Ϊ��ִ��a=getB()ʱ����δִ��b=1��䣬����getB()���ص���BĬ��ֵ������������Ϊ0
	 */
}
