package com.hx.reader.thread.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadException implements Runnable{

	@Override
	public void run() {
		 throw new RuntimeException();
	}

	//现象：控制台打印出异常信息，并运行一段时间后才停止
	public static void main(String[] args){
	    //就算把线程的执行语句放到try-catch块中也无济于事
	    try{
	        ExecutorService exec = Executors.newCachedThreadPool();
	        exec.execute(new ThreadException());
	    }catch(RuntimeException e){
	        System.out.println("Exception has been handled!");
	    }
	}
}
