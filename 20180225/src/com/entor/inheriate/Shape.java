package com.entor.inheriate;

public class Shape {

	private Point p; // ����λ��
	private String color;// ��ɫ
	
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
	 * ����ͼ�����
	 */
	public double calcArea(){
		return 0;
	}
	
	
}
