package com.hx.reader.everyday.feb2017;

public class Ques0210 {
	
	public static void change(String str,char ch[]){
		str="Change";
		ch[0]='C';
	}
	
	public static void main(String[] args) {
		String str = new String("World");
		
		char ch[] = {'W','o','r','l','d'};
		
		change(str, ch);
		
		System.out.println(str+"and"+new String(ch));
	}
	
	/**
	 * Java�в��������ǲ���ֵ���ݵķ�ʽ�������ݵ��ǲ����ĸ���������������ͣ����ò��ᱻ�����ı䣬�����õĶ������ݿ��Ա������ı䣬
	 * ������str���ַ��������ã�����ַ���������û�б��ı䣬����change�����иı�������ñ���ch���õ������������ݣ����ַ������Ԫ�أ������ַ���������ݱ�ΪCorld��
	 * 
	 * ֵ���������ô��ݲο���http://www.cnblogs.com/coderising/p/5697986.html
	 */
	
}
