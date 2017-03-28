package com.hx.reader.everyday.feb2017;


public class Ques0228 {
	
//	    List<T> 
//	    List<?>    
//	    List<Object>
	/**
	 * Q:请问以上三者有什么区别？
	 * A:List<T>表示的是List集合中的元素都是T类型，具体类型在运行期决定；
	 *   List<?>表示的是任意类型，与List<T>类似；
	 *   而List<Object>表示List集合中的所有元素为Object类型，可以容纳所有的类类型。
		 List<T>可以进行读写操作，例如add、remove等操作，因为它的类型是固定的T类型，在编码期不需要进行任何的转型操作；
		 List<?>是只读类型，不能进行读写操作，因为编译器不知道List中容纳的是什么类型的元素，List<?>读取出的元素都是Object类型的，需要主动转型，所以经常被用于泛型方法的返回值；
		 List<Object>也可以读写操作，但是它执行写入操作时要向上转型，在读取数据后需要向下转型，不过这样其实也没起到泛型的作用了。
	 */
}
