package com.entor.inheriate;

public class Person {

	private String name;
	public Person(){
	}
	public Person(String name){
		System.out.println("创建Person对象");
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
