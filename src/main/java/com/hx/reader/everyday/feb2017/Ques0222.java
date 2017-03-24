package com.hx.reader.everyday.feb2017;

import java.util.Arrays;

public class Ques0222 {

	public static void main(String[] args) {
		Ques0222Dog[] dogs1 = new Ques0222Dog[2];
		dogs1[0] = new Ques0222Dog("01","��ɫ");
		dogs1[1] = new Ques0222Dog("02","��ɫ");
		
		Ques0222Dog[] dogs2 = Arrays.copyOf(dogs1, dogs1.length); 
		
		// �޸�dogs02�еڶ�ֻ����ɫ
        dogs2[1].setColor("��ɫ");        
        
        // ��ӡdogs01�й�����ɫ
        for (int i = 0; i < dogs1.length; i++) {
            System.out.println(dogs1[i]);
        }
        
        /**
         * ��dogs2�еĵڶ�ֻ���޸���ɫ��dogs1�еĵڶ�ֻ������ɫҲ�ı��ˣ�����ǳ������������⡣ͨ��copyOf����������������һ��ǳ��������������ֱ�ӿ���ֵ���������ǿ������õ�ַ��
         * ����������Ǳ���dogs1��ÿ��Ԫ�أ���������һdog���ټӵ�dogs2�����У�
         */
	}
}
