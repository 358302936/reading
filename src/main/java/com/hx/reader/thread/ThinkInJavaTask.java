package com.hx.reader.thread;

public class ThinkInJavaTask implements Runnable{

	
	protected int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount ;
	public ThinkInJavaTask(){}
	public ThinkInJavaTask(int countDown){
	    this.countDown = countDown;
	}
	public String status(){
	    return "#"+Thread.currentThread().getPriority()+ "("+(countDown>0?countDown:"Task!")+ ").    ";
	}
	@Override
	public void run() {
		while(countDown-->0){
	        System.out.println(status());
	        Thread.yield();
	    }		
	}
	
	public static void main(String[] args) {
		for(int i=0;i<5;i++){
			ThinkInJavaTask task = new ThinkInJavaTask(5);		
			Thread t = new Thread(task);
			t.setPriority(i+1);
			t.start();
		}
		System.out.println("Waiting for Task");
	}

}
