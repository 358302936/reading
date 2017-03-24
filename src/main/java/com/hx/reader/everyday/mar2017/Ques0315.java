package com.hx.reader.everyday.mar2017;

public class Ques0315 {
	int x = 0;    
    
    public Ques0315(int val) throws Exception {        
        if (val != this.x) {            
            throw new Exception("�쳣");
        }
    }    
            
    public static void main(String[] args) {
        try {
			Ques0315 test = new Ques0315(4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
