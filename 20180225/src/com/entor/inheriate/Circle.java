package com.entor.inheriate;
/**
 * Բ��
 * @author Administrator
 *
 */
public class Circle extends Shape{

	private static final double PI = 3.14;
	private double r; // �뾶
	
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
	 * ����Բ�����
	 */
	@Override
	public double calcArea() {
		return r * r * Math.PI;
	}



	
	
}
