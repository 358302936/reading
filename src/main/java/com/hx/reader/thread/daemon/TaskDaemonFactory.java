package com.hx.reader.thread.daemon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class TaskDaemonFactory implements ThreadFactory{

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
	    t.setDaemon(true);
	    return t;
	}

	public static void main(String[] args) throws InterruptedException {
		/*
		* Executors.newCachedThreadPool();方法用来接受一个ThreadFactory对象，而这个对象将被用来创建新的线程
		* 所以，你的Facotry重写了ThreadFacotry方法之后，要去实现他的创建线程方法，方法里默认将线程声明为后台线程
		*/
		ExecutorService exec = Executors.newCachedThreadPool(new TaskDaemonFactory());
		for(int i = 0 ;i < 10 ;i++ ){
		exec.execute(new TaskDaemonFromFactory());//这个是一个自定义任务
		}
		System.out.println("All daemons started");
		TimeUnit.MILLISECONDS.sleep(500);

	}

}
