package com.hx.reader.thread.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	private static final int ThreadNum = 50;

    public static void main(String[] args)  {

        //创建一个CountDownLatch实例，管理计数为ThreadNum
        CountDownLatch countDownLatch = new CountDownLatch(ThreadNum);

        //创建一个固定大小的线程池
        ExecutorService executor = Executors.newFixedThreadPool(ThreadNum);

        //添加线程到线程池
        for(int i =0;i<ThreadNum;++i){
            executor.execute(new Person(countDownLatch, i+1));
        }

        System.out.println("开始等待全员签到...");

        try {
            //等待所有线程执行完毕
            countDownLatch.await();
            System.out.println("签到完毕，开始吃饭");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }
    }
}
