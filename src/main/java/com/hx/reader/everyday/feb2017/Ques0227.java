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
	  * Q:�����getMax������ȡ��������ֵ��ΪʲôҪ��ʹ��data.clone���������������Ҫ�Ҵ������ֵ���������ֵ���ܶ����Ҫ��ô�����
	  * A:��Ϊ����Ҳ��һ����������������Ļ����͸ı���ԭ����������˳��Ҫ�ҵڶ�������ݣ�Ҫ���޳��ظ����������򡣿���ʹ��Set���ϣ�Set������TreeSet�������Զ�����
	  */
	 
	 public static int getSecondMax(Integer[] data) {    
		    List<Integer> list = Arrays.asList(data);    
		    // ת��ΪTreeSet���ɾ���ظ����ݺ�����
		    TreeSet<Integer> set = new TreeSet<Integer>(list);    
		    return set.lower(set.last());
		}
}
