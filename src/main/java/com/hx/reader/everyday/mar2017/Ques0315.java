package com.hx.reader.everyday.mar2017;

public class Ques0315 {
	int x = 0;    
    
    public Ques0315(int val) throws Exception {        
        if (val != this.x) {            
            throw new Exception("异常");
        }
    }    
            
	public static void main(String[] args) {
        try {
			Ques0315 test = new Ques0315(4);
			System.out.println(test.x);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	/**
	 * 编译错误。
	        因为在构造方法Test(int val)声明中有异常抛出，所以在调用该构造器时，应将调用代码放在try-catch结构中，以对构造方法抛出的异常进行捕获处理。
	 */
}
