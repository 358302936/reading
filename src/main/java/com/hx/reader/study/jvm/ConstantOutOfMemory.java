package com.hx.reader.study.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 内存常量溢出
 * @vm args:-XX:PermSize=10M -XX:MaxPermSize=10M
 * @author chuhx
 * @version 2017年7月24日
 */
public class ConstantOutOfMemory {

    public static void main(String[] args) throws Exception {
       try {
           List<String> strings = new ArrayList<String>();
           int i = 0;
           while(true){
              strings.add(String.valueOf(i++).intern());
           }
       } catch (Exception e) {
           e.printStackTrace();
           throw e;
       }
 
    }
}
