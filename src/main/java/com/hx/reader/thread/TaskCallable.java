package com.hx.reader.thread;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TaskCallable implements Callable<String>{

	private int id;
	public TaskCallable(int id){
	    this.id = id;
	}
	
	@Override
	public String call() throws Exception {
		return "result of taskWithResult " + id;
	}
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();//工头
		ArrayList<Future<String>> results = new ArrayList<Future<String>>();//
		for(int i = 0 ; i < 10 ;i++ ){
		results.add(exec.submit(new TaskCallable(i)));//submit返回一个Future，代表了即将要返回的结果
		System.out.println(results.get(i).isDone());
		}
		try {
			System.out.println(results.get(2).get());
			System.out.println(results.get(5).isDone());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		exec.shutdown();
	}

}
