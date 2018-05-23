package com.ldq.inheritance;

public class Goods {

	private String name;// 商品名
	private String weight;//重量

	public Goods() {
	}

	public void add() {
		System.out.println(name + "添加了！");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

}
