package com.hx.reader.everyday.feb2017;

public class Ques0208 {

	public static void main(String[] args) {
		Ques0208Person person = new Ques0208Person("1", "chx");
		Ques0208Person person1 = new Ques0208Person("2", "chx");
		System.out.println(person.equals(person1));
	}
	/**
	 * 问题：Person类中的equals方法的if条件判断中，如果不检查对象是否为空（去掉o != null，只写o instanceof Person），当传进来的对象是null时，是否会报空指针异常？
	 * 答案：不会报空指针异常，因为null instanceof Person输出的是false，所以其实这里的条件判断可以不用写o != null && o instanceof Person，直接写o instanceof Person就行了。
	 */
}
