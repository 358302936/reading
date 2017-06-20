package com.hx.reader.io.pipeSample;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedIO {
    public static void main(String[] args) {  
       try {  
           // 构造读写的管道流对象  
           PipedInputStream pis = new PipedInputStream();  
           PipedOutputStream pos = new PipedOutputStream();  
             
           // 实现关联  
           pos.connect(pis);  
             
           // 构造两个线程，并且启动。  
           new Sender(pos, "F:\\dir.txt").start();  
           new Receiver(pis, "F:\\dir1.txt").start();  
       } catch (IOException e) {  
           System.out.println("Pipe Error" + e);  
       }  
	}  
}
