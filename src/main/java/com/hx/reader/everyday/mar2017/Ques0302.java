package com.hx.reader.everyday.mar2017;

public class Ques0302 {
	public static void main(String[] args) {
        String str1 = new String("123");
        String str2 = new String("123");
        str1 = str1 + 1;  // 1
        str1 = null;  // 2
        str2 = str2 + str1;  // 3
        // 4
    }
	
	/**
	 * Q:�����ںδ�������������������������
	 * A:��ע��4��֮ǰ��һ�����ǿ���ͨ����ֵһ�����ñ�����ֵΪnullʹ�����������������������
	 *   ����û�����ٸö��󣬲���Ҳ�������������������������������У�str1��Ȼ����ֵΪnull��
	 *   ����֮��str2 = str2 + str1;ʹ���˸ñ����������ע��3��֮ǰ��ʹ��������������Ҳ�ǲ������ٱ���str1��
	 */
}
