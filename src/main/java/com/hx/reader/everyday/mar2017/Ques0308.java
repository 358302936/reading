package com.hx.reader.everyday.mar2017;


public class Ques0308 implements Runnable{

	private String str1="this";
	
	private int[] str2 = {1,2,3,4,5};
	
	public static void main(String[] args) {
		Ques0308 test = new Ques0308();
		(new Thread(test)).start();
		(new Thread(test)).start();
	}
	
	@Override
	public synchronized void run() {
		for(int i=0;i<5;i++){
			
			System.out.println(str1+str2[i]+",�����̣߳�"+Thread.currentThread().getName());
		}
	}
	
	/**
	 * ��Ϊrun������synchronized���Σ���˱�run�������ʵ�str1,str2��Ϊ������Դ������������ͨ�������̵߳�start�������������̣߳�run��������ִ�С�
	 * str1��str2���ȱ���һ��run������ס��ֱ��run����ִ���꣬�ͷŵ���ס�Ĺ�����Դstr1��str2���ڶ���run()�������ܼ���ִ�У�������հ������ӡ���������������ݡ�
	 * ���ȥ��run����ǰ���synchronized���η�������ܻ������ӡ��������������ݡ�
	 */

}
