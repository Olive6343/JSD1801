package com.ldq.springdemo;

public class Juggler implements Performer{

	private int beanPake = 3;
	public Juggler() {
	}
	public Juggler(int beanPake) {
		this.beanPake = beanPake;
	} 

	@Override
	public void perform() {
		System.out.println("正在表演杂技，一次性抛出" + beanPake + "个豆袋");
	}
	@Override
	public void perform(String str) {
		
	}

	
}
