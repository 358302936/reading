package com.hx.reader.everyday.jan2017;

import java.util.Arrays;
import java.util.List;

public class Ques0120 {

	public static void main(String[] args) {
		Ques0120 q = new Ques0120();
		q.listsize();
		q.listsize1();
	}
	
	public void listadd(){
		List<String> list = Arrays.asList("����","����");
		list.add("����");
		System.out.println("�б��Ԫ�������ǣ�"+list.size());
		/**
		 * ��Ϊ��arrays.aslist�У���������Կ������ﷵ�ص�ArrayList����ԭ���Ĵ�ͳ�����ϵ�java.util.arraylist�ˣ�
		 * �����Լ��������һ����̬˽���ڲ��࣬��û���ṩadd������Ҫ�Լ�ʵ�֣����������ǳ����ˣ�
		 * ��ˣ�����ȷ��array.aslist�󳤶Ȳ������ӣ��������ʹ�ã�List abc=Arrays.asList("a","b","c"),��Ϊ�����ĳ������޷���add����.
		 */
	}
	
	public void listsize(){
		int[] data = {1,2,3,4,5};
		List list = Arrays.asList(data);
		System.out.println("�б��е�Ԫ�������ǣ�" + list.size());
	/**
	 * ע�����������������1��ԭ���ǣ���Arrays.asList�У��÷�������һ���䳤������һ��ɿ������������������Ϊint[] �������һ�����ͣ�����data������Ϊ��������ʱ��
	 * ��������Ϊֻ����һ�����������������������int���飬����sizeΪ1�����������ǲ�����Ϊ���͵Ĳ�����������Ӧ��ʹ�ð�װ���ͣ�������ȱû�б�����Ϊ�����ǿ��Է��ͻ��ģ�
	 * ����ת������list�о���һ������Ϊint������
	 */
	}
	
	public void listsize1(){
		Integer[] data = {1,2,3,4,5};
		List list = Arrays.asList(data);
		System.out.println("�б��е�Ԫ�������ǣ�" + list.size());
		/**
		 * ˵����������Integer[] ����һ����Integer�ǿɱ䳤���������������asList()����ʵ���ǽ�Integer�������Ԫ�ؽ��д洢��
		 */
	}
}
