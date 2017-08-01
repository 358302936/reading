package com.hx.reader.study.jvm;

public class ReferenceCountingGC {

	public Object instance = null;
	private static final int _1MB = 1024*1024;
	private static final int _512KB = 512*1024;
	
	//这个成员属性唯一的意义就是占点内存，在GC日志中看清楚是否被回收？
	private byte[] bigSize = new byte[2*_1MB];
	
	public static void testGC(){
		ReferenceCountingGC objA = new ReferenceCountingGC();
		ReferenceCountingGC objB = new ReferenceCountingGC();
		
		objA.instance = objB;
		objB.instance = objA;
		
		objA = null;
		objB = null;
		
		//假設在這行發生GC，那麼objA和objB是否能被回收？
		System.gc();
	}
	
	/**
	 * vm参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
	 */
	public static void testAllocation(){
		byte[] allocation1,allocation2,allocation3,allocation4,allocation5,allocation6,allocation7,allocation8,allocation9,allocation10,allocation11;
		allocation1 = new byte[1*_1MB];
		allocation2 = new byte[8*_1MB];
//		allocation3 = new byte[1*_1MB];
//		allocation4 = new byte[2*_1MB];
//		allocation5 = new byte[2*_1MB];
//		allocation6 = new byte[1*_1MB];
//		allocation7 = new byte[1*_512KB];
//		allocation8 = new byte[1*_512KB];
//		allocation9 = new byte[2*_1MB];
//		allocation10 = new byte[1*_512KB];
//		allocation11 = new byte[1*_512KB];
	}
	
	public static void main(String[] args) {
		ReferenceCountingGC.testAllocation();
	}
}
