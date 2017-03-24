package com.hx.reader.everyday.feb2017;

public class Ques0222Dog {

	private String id;
	
	private String color;
	
	public Ques0222Dog(String id,String color){
		super();
		this.id=id;
		this.color=color;
	}

	@Override
	public String toString(){
		return "��ţ�"+id+",��ɫ��"+color;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
