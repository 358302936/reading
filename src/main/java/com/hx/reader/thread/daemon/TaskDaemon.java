package com.hx.reader.thread.daemon;

import java.util.concurrent.TimeUnit;

public class TaskDaemon implements Runnable{

	@Override
	public void run() {
		 try{
		        while(true){
		            TimeUnit.MILLISECONDS.sleep(100);
		            System.out.println(Thread.currentThread() +"  " +this);
		        }
		    }catch(InterruptedException e){
		        System.out.println("sleep() interrupted");
		    }
	}
	
	public static void main(String[] args) throws InterruptedException{
	    /*
	     * 可以通过查看该程序的结果理解后台线程
	     * 创建了9个线程，都声明为后台线程，然后启动他们，在非后台线程结束之前，后台线程会被线程调用器调用
	     * main就是一个非后台线程，for循环结束之后输出了"All daemons started"证明main快要结束了，但是你让它睡眠了一会保证main不退出
	     * 这样后台线程就会跑着，于是有了后面的打印结果
	     */
	    for(int i = 0 ; i < 10 ; i++){
	        //后台线程本质上也是一个线程，通过任务来创建该线程
	        Thread daemon = new Thread(new TaskDaemon());
	        //想将创建的线程声明为后台线程 ，必须在启动前将其设置为true
	        daemon.setDaemon(true);
	        daemon.start();
	    }
	    System.out.println("All daemons started");
	    TimeUnit.MILLISECONDS.sleep(175);
	}

}
