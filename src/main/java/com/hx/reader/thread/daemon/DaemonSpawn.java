package com.hx.reader.thread.daemon;

public class DaemonSpawn implements Runnable {

	@Override
	public void run() {
		while(true){
			Thread.yield();//让线程暂停一段时间
		}
	}

}
