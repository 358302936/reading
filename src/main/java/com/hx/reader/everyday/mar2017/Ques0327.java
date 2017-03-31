package com.hx.reader.everyday.mar2017;

public class Ques0327 {
	public static void main(String[] args) {
		Ques0327MyThread t1 = new Ques0327MyThread("t1");
		Ques0327MyThread t2 = new Ques0327MyThread("t2");
		t1.start();
		t2.start();
	}
 }

