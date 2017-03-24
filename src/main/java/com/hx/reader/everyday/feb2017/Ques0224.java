package com.hx.reader.everyday.feb2017;

import java.util.ArrayList;
import java.util.List;

public class Ques0224 {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		List<Integer> subList = list.subList(0, 2);
		list.add(4);
		System.out.println("ԭ�б��ȣ�"+list.size());
		System.out.println("���б��ȣ�"+subList.size());
		
		/**
		 * ������ʾ�����޸��쳣��������ΪsubListȡ�����б���ԭ�б��һ����ͼ��ԭ���ݼ���list�޸��ˣ�����subListȡ�������б�������������һ�����б���������ݿ���ͼ��һ�������ݿ���ͼ�� �������ݱ���ˣ���ͼ��Ȼ����ˣ���
		 * ��������б��������ʱ���ͻ��⵽�޸ļ�������Ԥ�ڵĲ�ͬ�������׳������޸��쳣��

			�׳����쳣����size�����ļ���ϣ���������size������Դ�룺
			public int size(){
			    checkForComodification();    
			    return size;
			}
			����checkForComodification����������������Ƿ��������޸ĵģ�����Դ�룺
			private void checkForComodification(){    
			    // �жϵ�ǰ�޸ļ������Ƿ������б�����ʱһ��
			    if(l.modCount != expectedModCount)        
			        throw new ConcurrentModificationException();
			}
			expectedModCount����SubList���б�Ĺ��췽���и�ֵ�ģ���ֵ�����������б�ʱ���޸Ĵ��� ��modCount�������������������б�����޸�ԭʼ�б�
			l.modCount��ֵ�ͱ�expectedModCount��1�ˣ������׳�ConcurrentModificationException�쳣��
		 */
	}
}
