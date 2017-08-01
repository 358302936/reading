package com.hx.reader.study.inner;

import java.util.Arrays;


public class MyContainer {

	//初始化数组大小，默认长度为5
	private Entry[] entries = new Entry[5];
	private int count=0;//数据下标
	
	//对外提供一个接口向容器中存放封装好的数据（Entry对象）
	public void put(String key,String value){
		Entry entry = new Entry();
		entry.setKey(key);
		entry.setValue(value);
		//存放entry对象到数组中
		entries[count++] = entry;
		//数组扩容
		if(count >= entries.length){
			//扩容后数据的长度
			int newCapacity = entries.length*2;
			//把老数组中的数据复制到长度为newCapacity的新数组中
			entries = Arrays.copyOf(entries, newCapacity);
		}
	}
	
	//把容器中有数据的内容返回
	public Entry[] get(){
		return Arrays.copyOfRange(entries, 0, count);
	}
	
	//数据实体
	public static class Entry{
		private String key;
		private String value;
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
	}
}
