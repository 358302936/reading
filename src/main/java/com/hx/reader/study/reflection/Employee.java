package com.hx.reader.study.reflection;

public class Employee {

	public Employee(){
		
	}
	
	private String name;
	
	private int age;

	public String getName() {
		return name;
	}

	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + "]";
	}
}
