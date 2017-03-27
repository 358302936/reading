package com.hx.reader.everyday.feb2017;

import java.util.Arrays;

public class Ques0222 {

	public static void main(String[] args) {
		Ques0222Dog[] dogs1 = new Ques0222Dog[2];
		dogs1[0] = new Ques0222Dog("01","黑色");
		dogs1[1] = new Ques0222Dog("02","白色");
		
		Ques0222Dog[] dogs2 = Arrays.copyOf(dogs1, dogs1.length); 
		
		// 修改dogs02中第二只狗颜色
        dogs2[1].setColor("棕色");        
        
        // 打印dogs01中狗的颜色
        for (int i = 0; i < dogs1.length; i++) {
            System.out.println(dogs1[i]);
        }
        
        /**
         *对dogs02中的第二只狗修改颜色后，dogs01中的第二只狗的颜色也改变了，这是浅拷贝引起的问题。
         *通过copyOf方法产生的数组是一个浅拷贝，基本类型直接拷贝值，其他都是拷贝引用地址。
		     解决方法就是遍历dogs01的每个元素，重新生成一dog，再加到dogs02数组中
		     
		     http://blog.csdn.net/lcg910978041/article/details/51992614
         */
	}
}
