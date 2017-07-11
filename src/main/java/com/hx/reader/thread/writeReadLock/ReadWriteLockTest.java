package com.hx.reader.thread.writeReadLock;

import java.util.Random;

public class ReadWriteLockTest {
	public static void main(String[] args) {
      final Queue3 q3 = new Queue3();
      for(int i=0;i<3;i++){
         new Thread(){
             public void run(){
                 while(true){
                     q3.get();                        
                 }
             }
             
         }.start();
     }
     for(int i=0;i<3;i++){        
         new Thread(){
             public void run(){
                 while(true){
                     q3.put(new Random().nextInt(10000));
                 }
             }            
             
         }.start();    
     }

 }
}
