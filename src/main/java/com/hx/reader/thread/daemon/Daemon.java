package com.hx.reader.thread.daemon;

import java.util.concurrent.TimeUnit;

public class Daemon implements Runnable {

	//该任务下创建很多子线程
	private Thread[] t = new Thread[10];
	
	@Override
	public void run() {
		 //为线程池填充线程，并将所有线程启动
	    for(int i = 0 ; i < t.length ; i++ ){
	        t[i] = new Thread(new DaemonSpawn());
	        t[i].start();
	        System.out.println("DaemonSpawn " + i +  "started, ");
	    }
	    for(int i = 0 ; i < t.length ; i++ ){
	        System.out.println("t[" + i+  "].isDaemon()=" + t[i].isDaemon() + ", ");
	    }
	    /*
	     * Daemon进入了无线循环，并在循环里调用yield方法把控制权交给其他进程
	     */
	    while(true){
	    	Thread.yield();
	    }
	}
	
	public static void main(String[] args) throws InterruptedException{
	    /*
	     * Daemon被设置为了后台线程，它的所有子线程也自然就是后台线程了
	     */
	    Thread d = new Thread(new Daemon());
	    d.setDaemon(true);
	    d.start();
	    System.out.println("d.isDaemon()=" +d.isDaemon() +",");
	    TimeUnit.SECONDS.sleep(1);
	}

}
