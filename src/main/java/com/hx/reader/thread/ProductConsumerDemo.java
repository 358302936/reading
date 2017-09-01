package com.hx.reader.thread;

import java.util.LinkedList;

public class ProductConsumerDemo {

	public static void main(String[] args) {
		Basket basket = new Basket();
		Productor p = new Productor(basket);
		Consumer c = new Consumer(basket);
		
		p.start();
		c.start();
	}
}

//生产者
class Productor extends Thread{
	private Basket basket = null;

	public Productor(Basket basket) {
		super();
		this.basket = basket;
	}
	
	@Override
	public void run() {
		basket.pushApple();
	}
}
//消费者
class Consumer extends Thread{
	private Basket basket = null;

	public Consumer(Basket basket) {
		super();
		this.basket = basket;
	}
	
	@Override
	public void run() {
		basket.popApple();
	}
}

/**
 * 苹果类
 * @author chuhx
 * @version 2017年8月29日
 */
class Apple{
	private int id;
	
	public Apple(int id) {
		this.id=id;
	}
	@Override
	public String toString() {
		return "苹果id："+(id+1);
	}
}

//存放苹果容器
class Basket{
	private LinkedList<Apple> basket= new LinkedList<Apple>();
	
	//生产者生产苹果
	public synchronized void pushApple(){		
		for(int i=0;i<20;i++){
			Apple apple = new Apple(i);
			push(apple);
		}
	}
	
	//生产者生产苹果
	public synchronized void popApple(){		
		for(int i=0;i<20;i++){
			pop();
		}
	}
	
	//向篮子里存放苹果
	private void push(Apple apple){
		//当篮子里的苹果满5个后就通知消费之来消费
		if(basket.size()==5){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//等待并释放当前对象
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		basket.addFirst(apple);
	    System.out.println("生产者生产"+apple.toString());
		notify();//通知消费者来消费
	}
	
	//从篮子里取苹果
	private void pop(){
		//当篮子的苹果数量为零时就通知生产者来生产
		if(basket.size()==0){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//等待并释放当前对象
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Apple apple = basket.pollFirst();
		System.out.println("消费者消费"+apple.toString());
		notify();//通知生产者来生产
	}
}

