package com.ldq.car;

public class Car {
	private String brand;//品牌
	private String color;//颜色
	private String weigth;//重量
	private String speet;//最高时速
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
 * 汽车行驶最高时速
 */
	public void run(){
		System.out.println(getBrand()+"车以最高时速"+getSpeet()+"在行驶...");
	}
/**
 * 汽车维修
 */
	public void repaire(){
		System.out.println(getBrand()+"车正在修理...");
	}
}