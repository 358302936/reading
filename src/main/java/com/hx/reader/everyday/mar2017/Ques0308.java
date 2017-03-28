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
			
			System.out.println(str1+str2[i]+",进程："+Thread.currentThread().getName());
		}
	}
	
	/**
	 * 因为run()方法被synchronized修饰，因此被run()方法访问的str1和str2成为共享资源，在连续两次通过调用线程的start()方法启动线程，run()方法才能执行，
	 * str1和str2先是被第一个run()方法锁住，直到run()方法执行完，释放掉锁住的共享资源str1和str2，第二个run()方法才能继续执行，因此最终按次序打印输出两个数组的内容。
	 * 如果去掉run()方法前面的synchronized修饰符，则可能会无顺序地打印输出两个数组的内容。
	 */

}
