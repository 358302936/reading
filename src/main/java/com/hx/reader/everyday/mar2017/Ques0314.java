package com.hx.reader.everyday.mar2017;

public class Ques0314 {

	public static void main(String[] args) {
		try {
			return;
		} finally{
			System.out.println("finally");
		}
	}
	
	//finally,
	//finally语句块中的语句不管try块是否正常结束，都会在控制从try块中跳出获得执行
}
