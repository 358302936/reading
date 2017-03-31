package com.hx.reader.everyday.mar2017;

public class Ques0324 extends Thread{
	public static void main(String[] args) {        
        Ques0324 test1 = new Ques0324();        
        Ques0324 test2 = new Ques0324();
        test1.start();
        test2.start();
    }

    public void run() {        
        System.out.println("1");        
//        yield(); 
//        interrupt();
        try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("2");
    }
    
    /**
     * 线程几个概念：
     * 1、sleep:指定的毫秒数内让当前正在执行的线程休眠（暂停执行），此操作受到系统计时器和调度程序精度和准确性的影响。该线程不丢失任何监视器的所属权。 
			          通过调用sleep使任务进入休眠状态，在这种情况下，任务在指定的时间内不会运行。
			          调用sleep的时候锁并没有被释放。
	   2、wait:调用wait使线程挂起，知道线程得到了notify或notifyAll消息，线程才会进入就绪状态。
			       使你可以等待某个条件发生变化，而改变这个条件超出了当前方法的控制能力。
			       线程的执行被挂起，对象上的锁被释放。意味着另一个任务可以获得这个锁。因此在改对象中的其他synchronized方法可以在wait期间被调用。
			      就意味着生命“我已经刚刚做完能做的所有事情，因此我要在这里等待，但是我希望其他synchronized操作在条件适合的情况下才能够执行”
	   3、yield:如果知道已经完成了在run()方法的循环的一次迭代过程中所需要的工作，就可以给线程调度一个机制暗示：我的工作已经做的差不多了，可以让给别的线程使用CPU了。通过调用yield()来实现。
				当调用yield时，你也是在建议具有相同优先级的其他线程可以运行。
				对于任何重要的控制或在调整应用时，都不恩那个依赖于yield。实际上，yield经常被误用。
				（yield并不意味着退出和暂停，只是，告诉线程调度如果有人需要，可以先拿去，我过会再执行，没人需要，我继续执行）
				调用yield的时候锁并没有被释放。
	   4、interrupt:中断线程。
					中断 
					Thread.interrupt()或者新类库里面通过Executor的submit()来获得Future<?>返回值，这个Future提供cancel()以停止这个线程。 
					Thread类包含interrupt()方法，因此你可以终于被阻塞的任务，这个方法将设置线程的中断状态。如果一个线程已经被阻塞，或者视图执行一个阻塞操作，那么设置这个线程的终端状态将抛出InterruptedException。
					当抛出该异常或者该任何调用Thread.interrupted()时，中断状态将复位。
					你在Executor上调用shutdownNow()，那么它将发送一个interrupt()调用给他启动的所有线程。
     */
}
