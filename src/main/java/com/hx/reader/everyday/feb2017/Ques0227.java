package com.hx.reader.everyday.feb2017;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Ques0227 {
	 public static int getMax(int[] data) {
	        Arrays.sort(data.clone());        
	        return data[data.length - 1];
	    }
	 
	 /**
	  * Q:上面的getMax方法是取数组的最大值，为什么要先使用data.clone拷贝后再排序？如果要找次于最大值的数（最大值可能多个）要怎么解决？
	  * A:使用data.clone拷贝后再排序，是因为数组也是一个对象，不拷贝的话就改变了原有数组元素的顺序了。
	  *   要找第二大的数，首先要先剔除重复数据，然后再排序。可以自己手写算法也可以使用jdk自带的类实现，这里介绍一下后者，数组自身不能剔除重复数据，可以使用Set集合，Set的子类TreeSet还可以自动排序
	  */
	 
	 
	 public static int getSecondMax(Integer[] data) {    
		    List<Integer> list = Arrays.asList(data);    
		    // 转换为TreeSet后会删除重复数据和排序
		    TreeSet<Integer> set = new TreeSet<Integer>(list);    
		    return set.lower(set.last());
		}
}
