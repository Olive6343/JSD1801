package com.entor.inheriate;

public class Shape {

	private Point p; // 中心位置
	private String color;// 颜色
	
	public Shape(){
	}
	
	public Shape(Point p,String color){
		this.p = p;
		this.color = color;
	}
	public Point getP() {
		return p;
	}
	public void setP(Point p) {
		this.p = p;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	/**
	 * 计算图形面积
	 */
	public double calcArea(){
		return 0;
	}
	
	
}
