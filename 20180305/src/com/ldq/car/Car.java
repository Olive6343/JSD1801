package com.ldq.car;

public class Car {
	private String brand;//Ʒ��
	private String color;//��ɫ
	private String weigth;//����
	private String speet;//���ʱ��
	public Car() {
		super();
	}
	public Car(String brand, String color, String weigth, String speet) {
		this.brand = brand;
		this.color = color;
		this.weigth = weigth;
		this.speet = speet;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getWeigth() {
		return weigth;
	}
	public void setWeigth(String weigth) {
		this.weigth = weigth;
	}
	public String getSpeet() {
		return speet;
	}
	public void setSpeet(String speet) {
		this.speet = speet;
	}
/**
 * ������ʻ���ʱ��
 */
	public void run(){
		System.out.println(getBrand()+"�������ʱ��"+getSpeet()+"����ʻ...");
	}
/**
 * ����ά��
 */
	public void repaire(){
		System.out.println(getBrand()+"����������...");
	}
}