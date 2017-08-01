package com.hx.reader.study.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Described 堆溢出测试
 * @VM args:-verbose:gc -Xms20M -Xmx20M -XX:+PrintGCDetails
 * @author chuhx
 * @version 2017年7月24日
 */
public class HeapOutOfMemory {

	 public static void main(String[] args) {
	       List<TestCase> cases = new ArrayList<TestCase>();
	       while(true){
	           cases.add(new TestCase());
	       }
	 
	    }
}
