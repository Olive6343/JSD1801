package com.ldq.inheritance;

public class Goods {

	private String name;// ��Ʒ��
	private String weight;//����

	public Goods() {
	}

	public void add() {
		System.out.println(name + "����ˣ�");
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
