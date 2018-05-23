package com.entor.JSD0205;


public class Circle {

	private Point p;
	private int r;
	
	public Circle(Point p,int r){
		this.r = r;
		this.p = p;
	}
	public Point getP() {
		return p;
	}
	public void setP(Point p) {
		this.p = p;
	}
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	
	@Override
	public String toString() {
		return "Բ�� [p=" + p + ", r=" + r + "]";
	}
	
	/**
	 * Բ�����
	 * 
	 */
	public void getArea(){
		System.out.println("Բ������ǣ�" + r*r*Math.PI);
	}
	
	
	public boolean contain(Point point){
		double distance = Math.sqrt((p.getX()-point.getX())*(p.getX()-point.getX()) + (p.getY()-point.getY())*(p.getY()-point.getY()));
		if(distance > r){
//			System.out.println("����Բ��");
			return false;
		}else{
//			System.out.println("��Բ��");
			return true;
		}
	}
	
	public boolean contain(int x, int y){
		double distance = Math.sqrt((p.getX()-x)*(p.getX()-x) + (p.getY()-y)*(p.getY()-y));
		if(distance > r){
			return false;
		}else{
			return true;
		}
	}
	
	
	
}
