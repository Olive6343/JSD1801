package com.entor.inheriate;

/**
 * ����
 * @author Administrator
 *
 */
public class Rectangle extends Shape{

	private double length; // ��
	private double width; // ��
	
	public Rectangle(){
	}
	public Rectangle(double length, double width){
		this.length = length;
		this.width = width;
	}
	public double getlength() {
		return length;
	}
	public void setlength(double length) {
		this.length = length;
	}
	public double getwidth() {
		return width;
	}
	public void setwidth(double width) {
		this.width = width;
	}
	@Override
	public String toString() {
		return "Rectangle [length=" + length + ", width=" + width + ", toString()=" + super.toString() + "]";
	}
	
}
