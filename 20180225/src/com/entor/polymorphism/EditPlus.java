package com.entor.polymorphism;

public class EditPlus extends Environment{

	public EditPlus(){
	}
	
	public EditPlus(String name){
		super(name);
	}
	
	/**
	 * ���F1������
	 */
	public void afterClickF1(){
		System.out.println(getName() + "�У����F1����API");
	}
}
