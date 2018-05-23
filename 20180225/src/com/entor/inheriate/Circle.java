package com.entor.inheriate;
/**
 * 圆形
 * @author Administrator
 *
 */
public class Circle extends Shape{

	private static final double PI = 3.14;
	private double r; // 半径
	
	public Circle(){
	}
	
	public Circle(double r){
		super();
		this.r = r;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	/**
	 * 计算圆的面积
	 */
	@Override
	public double calcArea() {
		return r * r * Math.PI;
	}



	
	
}
