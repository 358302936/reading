package com.hx.reader.everyday.feb2017;

public class Ques0216 {

	public static void main(String[] args) {
		char c1 = '\u005A';//字母Z
		/**
		 * 		 
		char c2 = '\u000a';//换行符
       * */
       /**
                          其实在Java任何字符都可以用 Unicode转义字符来表示，转义字符由 "\ u" + 4位16进制数组成。Unicode转义字符\u005A表示字母Z，Unicode转义字符\u000A表示换行符。
                          在这个例子中，编译器遇到\u000a时，识别出对应的是换行符，此时Java就把它转换成换行符，转换后这行代码就变成了两行：
         char c2 = '
         ';  // 换行符
                          出现上面的情况所以就出现编译错误了。
        */
	}
}
