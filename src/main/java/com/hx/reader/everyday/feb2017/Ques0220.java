package com.hx.reader.everyday.feb2017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ques0220 {

	public static void main(String[] args) {
		List<Ques0220Student> list = new ArrayList<Ques0220Student>();
		list.add(new Ques0220Student("001"));
		
		Map<Ques0220Student,Object> map = new HashMap<Ques0220Student,Object>();
		
		map.put(new Ques0220Student("001"), new Object());
		
		System.out.println("list�Ƿ����001��"+list.contains(new Ques0220Student("001")));
		System.out.println("map�Ƿ����001��"+map.containsKey(new Ques0220Student("001")));
	}
	/**
	 * list����true,��ΪQues0220Student����д��equals�������Ǹ���ѧ���Ƿ�һ�����жϣ������ж�������ַ�Ƿ���ȣ�ֻҪstuId��ͬ�ͷ���true.
	 * map����false,��HashMap�ĵײ���ʹ�����鷽ʽ�洢Map Entry�ģ������Ǹ��ݴ���Ԫ�ص�hashCode��������ֵ�����洢�����±�λ�ã������λ������MapEntry���Ҵ���ļ�ֵ����򲻴�����������򸲸ǣ�
	 * �����λ��û��Map Entry,����뵽Map Entry�������С�
	 * �����hashCode�������ص��ǹ�ϣ������Object��ı��ط������ɵģ���֤ÿ��������һ����ϣ�𣬹�ϣ�㷨��Ҫ�����������������x1��x2����x1=x2�������f(x1)=f(x2),
	 * ����Ҳ����x1!=x2��f(x1)=f(x2)��������ڡ�
	 * ����������У���Ϊû����дhashCode����������ѧ��Ϊ001�Ķ����hashCode��������ֵ�϶��ǲ���ȵģ���HashMap��������Ҳ�Ҳ�����Ӧ��Map Entry,���Է���false.
	 * �޸ĵĻ���дhashCode�����Ϳ����ˣ���򵥵Ŀ��Է���һ��������Ҳ����ʹ��һЩ��ϣ�����ɹ��ߣ���HashCodeBuilder.
	 */
}
