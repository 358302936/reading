package com.hx.reader.everyday.feb2017;

public class Ques0214 {

	public static boolean method(boolean location){
		if(location){
			System.out.println("location02");
		}
		System.out.println("location03");
		return true;
	}
	
	public static void main(String[] args) {
		boolean b1 = true;
		
		if(b1 || method(true)){
			System.out.println("location1");
		}
	}
	/**
	 * ���location1,��Ϊ�ǻ����㣬ֻҪ��һ���������㣬�ڶ��������Ͳ����жϡ�
	 */
}
