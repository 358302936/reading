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
		list.add(4);// 原列表增加一个元素
		System.out.println("原列表长度："+list.size());
		System.out.println("子列表长度："+subList.size());
		
		/**
			 运行结果：
			原列表长度：4
			Exception in thread "main" java.util.ConcurrentModificationException
			    at java.util.ArrayList$SubList.checkForComodification(ArrayList.java:1169)
			    at java.util.ArrayList$SubList.size(ArrayList.java:998)
			    at Jan2017.Ques0106.main(Ques0106.java:17)
			报错提示并发修改异常，这是因为subList取出的列表是原列表的一个视图，原数据集即list修改了，但是subList取出的子列表并不会重新生成一个新列表，
			这点与数据库视图不一样（数据库视图中 若表数据变更了，视图当然会变了），后面对子列表继续操作时，就会检测到修改计数器与预期的不同，所以抛出并发修改异常。
			
			抛出该异常在于size方法的检查上，先来看看size方法的源码：
			public int size(){
			    checkForComodification();    
			    return size;
			}
			其中checkForComodification方法就是用来检测是否发生并发修改的，它的源码：
			private void checkForComodification(){    
			    // 判断当前修改计数器是否与子列表生成时一致
			    if(l.modCount != expectedModCount)        
			        throw new ConcurrentModificationException();
			}
			expectedModCount是在SubList子列表的构造方法中赋值的，其值等于生成子列表时的修改次数 即modCount变量，所以在生成子列表后又修改原始列表，
			l.modCount的值就比expectedModCount大1了，所以抛出ConcurrentModificationException异常。
		 */
	}
}
