package com.entor.inheriate;

public class Student extends Person{

	private int sno;
	private String major;
	public Student(){
	}
	public Student(int sno,String name,String major){
		super(name);
		System.out.println("创建Student对象");
		this.sno = sno;
		this.major = major;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
}
