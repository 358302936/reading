package com.hx.reader.everyday.feb2017;

public class Ques0220Student {
	
	private String stuId;
	
	public Ques0220Student(String stuId){
		super();
		this.stuId=stuId;
	}

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Ques0220Student){
			Ques0220Student stu = (Ques0220Student)obj;
			if(stu.getStuId() == null || stuId == null){
				return false;
			}else{
				return stuId.equalsIgnoreCase(stu.getStuId());
			}
		}
		return false;
	}
}
