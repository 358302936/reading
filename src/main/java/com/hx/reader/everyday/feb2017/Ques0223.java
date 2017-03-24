package com.hx.reader.everyday.feb2017;

public class Ques0223 {

	public static void main(String[] args) {
		Ques0223Parent parent = new Ques0223Parent();
        parent.sum(1, 2);

        Ques0223Sub sub = new Ques0223Sub();
//        sub.sum(1, 2);���Ͳ�ƥ��
        int[] a = new int[2];
        sub.sum(1,a);
    }
}
