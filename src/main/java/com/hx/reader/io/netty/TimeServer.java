package com.hx.reader.io.netty;

/**
 * @Author yanuun
 * @Date 19:55 2018/3/12
 **/
public class TimeServer {

    public static void main(String[] args){
        int port=8080;
        if(args != null && args.length>0){
            try {
                port=Integer.valueOf(args[0]);
            }catch (NumberFormatException nfe){
                nfe.printStackTrace();
            }
        }
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer,"NIO-MultiplexerTimeServer-001").start();
    }
}
