package com.hx.reader.io;

import java.io.IOException;
import java.io.PipedReader;

public class Receiver  extends Thread {

	   private PipedReader in;  
	     
       public Receiver(Sender sender) throws IOException {  
           in = new PipedReader(sender.getPipedWriter());  
       }  
     
       public void run() {  
           try {  
               while ((char)in.read() != 'z') {  
                   // Blocks until characters are there:  
                   System.out.println("Read: " + (char) in.read());  
               }  
           } catch (IOException e) {  
               throw new RuntimeException(e);  
           }  
       }

}
