package com.hx.reader.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 几种创建线程池方法，
 * 详细解释：http://note.youdao.com/noteshare?id=5b0b71e4aa8d7f7b10ab9b7a5ab8ed51&sub=90D62D6DF472427B85D39980E7841A72
 * @author chuhx
 * @version 2017年3月28日
 */
public class ThreadPool {

   private static void run(ExecutorService threadPool){  
       for(int i = 1; i < 5; i++) {    
           final int taskID = i;    
           threadPool.execute(new Runnable() {    
	           @Override  
	           public void run() {    
	                       for(int i = 1; i < 5; i++) {    
	                          try {    
	                               Thread.sleep(20);// 为了测试出效果，让每次任务执行都需要一定时间    
	                           } catch (InterruptedException e) {    
	                               e.printStackTrace();    
	                           }    
	                           System.out.println("第" + taskID + "次任务的第" + i + "次执行");    
	                      }    
	                   }    
          });    
        }    
       threadPool.shutdown();// 任务执行完毕，关闭线程池    
	}  
	  
	@SuppressWarnings("unused")
	public static void main(String[] args) {  
            // 创建可以容纳3个线程的线程池  
            ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);  
              
            // 线程池的大小会根据执行的任务数动态分配  
            ExecutorService cachedThreadPool = Executors.newCachedThreadPool();  
              
            // 创建单个线程的线程池，如果当前线程在执行任务时突然中断，则会创建一个新的线程替代它继续执行任务    
            ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();  
              
            // 效果类似于Timer定时器  
            ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);  
              
            run(fixedThreadPool);  
    //      run(cachedThreadPool);  
    //      run(singleThreadPool);  
    //      run(scheduledThreadPool);  
	}  
}
