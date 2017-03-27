package com.hx.reader.everyday.feb2017;

public class Ques0208Person {

	private String id;
	private String name;
	
	public Ques0208Person(String id,String name){
		super();
		this.id=id;
		this.name=name;
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Ques0208Person){
			Ques0208Person person = (Ques0208Person)o;
			return (id.equals(person.id)&&name.equals(person.name));
		}
		return false;
	}
}
