package com.hx.reader.io;

import java.io.PipedWriter;
import java.util.Random;

public class Sender extends Thread{

	   private Random rand = new Random();  
       private PipedWriter out = new PipedWriter();  
     
       public PipedWriter getPipedWriter() {  
           return out;  
       }  
     
       public void run() { 
    	   char c = 'A';
           while (c != 'z') {  
               for (; c <= 'z'; c++) {  
                   try {  
                       out.write(c);  
                       sleep(rand.nextInt(500));  
                   } catch (Exception e) {  
                       throw new RuntimeException(e);  
                   }  
               }  
           }
       }  
}
