package com.hx.reader.thread.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class Person implements Runnable{
	private CountDownLatch countDownLatch;
    private int index;

    public Person(CountDownLatch cdl,int index){
        this.countDownLatch = cdl;
        this.index = index;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("person " + index +"签到");

        //线程执行完毕，计数器减一
        countDownLatch.countDown();

    }
}
