package com.hx.reader.thread.daemon;

public class TaskDaemonFromFactory implements Runnable{

	@Override
	public void run() {
		System.out.println("线程工厂");
	}

}
