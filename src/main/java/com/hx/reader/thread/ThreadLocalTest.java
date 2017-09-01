package com.hx.reader.thread;

public class ThreadLocalTest {

	public static class MyRunnable implements Runnable{

		private ThreadLocal<Integer> tl = new ThreadLocal<Integer>();
		
		@Override
		public void run() {
			tl.set((int)(Math.random()*100D));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(tl.get());
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		MyRunnable sharedRunnableInstance = new MyRunnable();
		
		Thread thread1 = new Thread(sharedRunnableInstance);
		Thread thread2 = new Thread(sharedRunnableInstance);
		
		thread1.start();
		thread2.start();
		
		thread1.join(); //wait for thread 1 to terminate
		thread2.join(); //wait for thread 2 to terminate
	}
}
