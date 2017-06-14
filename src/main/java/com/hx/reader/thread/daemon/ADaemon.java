package com.hx.reader.thread.daemon;

import java.util.concurrent.TimeUnit;

public class ADaemon implements Runnable{

	@Override
	public void run() {
		try{
	        System.out.println("Starting ADaemon");
	        TimeUnit.SECONDS.sleep(1);
	    }catch(InterruptedException e){
	        System.out.println("Exiting via InterruptedException");
	    }finally{
	        System.out.println("Thie should always run?");
	    }
	}
	
	public static void main(String[] args) throws InterruptedException{
	    //当最后一个非后台线程终止时，后台线程会“突然”终止
	    //故一旦main退出，jvm就会立即关闭所有的后台进程，而不会有任何你希望出现的确认形式
	    Thread t = new Thread(new ADaemon());
	    //如果注释掉下面这句话，finally将会执行
	    t.setDaemon(true);
	    t.start();
	    TimeUnit.MILLISECONDS.sleep(1200);
	}

}
