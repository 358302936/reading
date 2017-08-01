package com.hx.reader.study.reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClassDemo {

	private static final Logger log = LoggerFactory.getLogger(ClassDemo.class); 
	
	public static void main(String[] args) {
		try {
			//获取Employee所关联的Class对象
			Class<?> classType = Class.forName("com.hx.reader.study.reflection.Employee");
			//通过反射机制构造一个实例对象(默认调用的是无参构造方法)
			Employee employee = (Employee)classType.newInstance();
			
			//通过反射机制调用指定的构造方法实例对象
			Constructor<?> constructor = classType.getConstructor(new Class[]{String.class,int.class});
			Employee employee1 = (Employee)constructor.newInstance(new Object[]{"zhangsan",30});
			log.info(employee1.toString());
			
			//通过反射机制获得对象指定的方法（包括私有方法）
			Method method = classType.getDeclaredMethod("getName", new Class[]{});
			log.info(method.getName());
			
			//通过反射机制调用对象的方法
			String name = (String)method.invoke(employee1, new Object[]{});
			log.info(name);
			
			//获取Class对象指定的属性，包括私有的
			Field field = classType.getDeclaredField("name");
			field.setAccessible(true);
			field.set(employee, "李四");
			log.info(field.get(employee).toString());
			
			//通过反射机制创建数组
			ClassDemo cd = new ClassDemo();
			cd.reflectionArray();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void reflectionArray(){
		try {
			//创建一维数组
			Class<?> classType = Class.forName("java.lang.String");
			Object array = Array.newInstance(classType, 10);
			Array.set(array, 5, "王神仙");
			log.info(Array.get(array, 5).toString());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
