package com.entor.inheriate;

public class Person {

	private String name;
	public Person(){
	}
	public Person(String name){
		System.out.println("����Person����");
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
