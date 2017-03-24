package com.hx.reader.everyday.feb2017;

public class Ques0208 {

	public static void main(String[] args) {
		Ques0208Person person = new Ques0208Person("1", "chx");
		Ques0208Person person1 = new Ques0208Person("2", "chx");
		System.out.println(person.equals(null));
	}
	/**
	 * ���⣺����Ques0208Person���е�equals������if�����ж��У�������������Ƿ�Ϊ�գ�ȥ��o != null��ֻдo instanceof Ques0208Person����
	 *     ���������Ķ�����nullʱ���Ƿ�ᱨ��ָ���쳣��
	 * �𰸣����ᱨ��ָ���쳣����Ϊnull instanceof Ques0208Person�������false��������ʵ����������жϿ��Բ���дo != null && o instanceof Ques0208Person��
	 *     ֱ��дo instanceof Ques0208Person�����ˡ�
	 */
}
