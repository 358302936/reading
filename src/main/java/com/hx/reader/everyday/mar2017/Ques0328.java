package com.hx.reader.everyday.mar2017;

public class Ques0328{

	 public static void main(String[] args) {        
	        new Ques0328();
	    }

	    Ques0328() {
	        Ques0328 t1 = this;
	        Ques0328 t2 = this;

	        synchronized (t1) {            
	            try {
	                t2.wait();  // 11	               
	                System.out.println("wait");
	            } catch (InterruptedException e) {
	                System.out.println("Interrupted");
	            } catch (Exception e) {
	                System.out.println("Exception");
	            } finally {
	                System.out.println("Finally");	                
	            }
	        }
	        System.out.println("OK");
	    }
	   /**
	    * 编译成功，但运行结果无内容输出。
		      在Java中，每一个对象都有锁，任何时候，该锁都至多由一个线程控制。在例子中由于t1和t2都指向同一对象Test，在执行第11行代码前，线程拥有对象Test的锁，
		      在执行完第11行后，该线程释放了对象Test的锁，进入等待池。此后没有线程调用对象Test的notify()和notifyAll()方法唤醒等待线程，所以该进程一直在等待状态，没有输出。 
	    */
	    
}
