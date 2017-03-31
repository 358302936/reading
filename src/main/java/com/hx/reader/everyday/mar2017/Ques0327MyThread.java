package com.hx.reader.everyday.mar2017;

public class Ques0327MyThread extends Thread {

	public void output(String s) {
        System.out.println(s);
    }    
    
    public void run() {        
        for (int i = 0; i < 10; ++i) {            
            try {
                sleep((long)(3000*Math.random()));
                System.out.println("休息一会");
            } catch (Exception e) {                
                // TODO: handle exception
            }
            output(getName());
        }
    }    
    
    public Ques0327MyThread(String s) {        
        super(s);
    }
    
    /**
     * sleep()方法用于使线程暂时停止当前运行一段指定的时间，当指定时间结束后，线程并不能马上获得执行，而必须先进入就绪状态等待获得CPU使用权，才能再次获得执行。
     * 例子中，由于传入sleep()方法的时间长度不定，由随机数决定，因此两个线程打印输出语句的顺序也无法确定。
     */
}
