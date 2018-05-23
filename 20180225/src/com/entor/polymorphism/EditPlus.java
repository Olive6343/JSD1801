package com.entor.polymorphism;

public class EditPlus extends Environment{

	public EditPlus(){
	}
	
	public EditPlus(String name){
		super(name);
	}
	
	/**
	 * 点击F1按键后
	 */
	public void afterClickF1(){
		System.out.println(getName() + "中，点击F1弹出API");
	}
}
