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
		
		System.out.println("list是否包含001："+list.contains(new Ques0220Student("001")));
		System.out.println("map是否包含001："+map.containsKey(new Ques0220Student("001")));
	}
	/**
	 * list时返回true应该比较好理解，因为Student类重写了equals方法，是根据学号是否一样来判断，不再判断两个地址是否相等，只要stuId相同就返回true。
                   而map情况返回false，在HashMap的底层是使用数组方式存储Map Entry的，具体是根据传入元素的hashCode方法返回值决定存储数组下标位置，
                   如果该位置已有Map Entry，且传入的键值相等则不处理，若不相等则覆盖；如果该位置没有Map Entry，则插入，加入到Map Entry的链表中。
		对象的hashCode方法返回的是哈希码，是由Object类的本地方法生成的，保证每个对象有一个哈希码，哈希算法的要求对于任意两个输入x1和x2，若x1=x2，
		则必须f(x1)=f(x2)，不过也允许x1!=x2，f(x1)=f(x2)的情况存在。
		在这个例子中，因为没有重写hashCode方法，两个学号为001的对象的hashCode方法返回值肯定是不相等的，在HashMap的数组中也找不到对应的Map Entry，所以返回false。
		修改的话重写hashCode方法就可以了，最简单的可以返回一个常量，也可以使用一些哈希码生成工具，如HashCodeBuilder。
	 */
}
