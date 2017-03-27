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
	 * ||，只要其中一个满足即可执行。如果第一个条件满足，第二个条件就不会判断（或者执行了）
	 */
}
