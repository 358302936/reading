package com.hx.reader.everyday.mar2017;

public class Ques0306 {

	static int i=1;
	
	static{
		++i;
	}
	
	public static void main(String[] args) {
		increment(i,3);
		display(i);
	}
	
	static void increment(int n,int m){
		n+=m;
	}
	
	static void display(int n){
		System.out.println(n);
	}
	
	static{
		++i;
	}
	/**
	 * static�����Ҳ�о�̬����飬�������ж��������Ա��static���飬�����ж����λ�ÿ������ţ��������κεķ������ڣ�
	 * JVM������ʱ��ִ����Щ��̬�Ĵ���飬���static������ж����JVM���������������г��ֵ��Ⱥ�˳������ִ�����ǣ�ÿ�������ֻ�ᱻִ��һ�Ρ�
	 * 
	 * java��ֵ���ݣ�increment��������ı�i��ֵ
	 */
}
