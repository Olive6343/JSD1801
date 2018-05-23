package com.ldq.thread;

public class Ticket {

	private String name;// 门票名称
	private int count;// 门票数量
	public Ticket() {
	}
	public Ticket(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	
}
