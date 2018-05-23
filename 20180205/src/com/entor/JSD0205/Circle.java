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
		return "圆： [p=" + p + ", r=" + r + "]";
	}
	
	/**
	 * 圆的面积
	 * 
	 */
	public void getArea(){
		System.out.println("圆的面积是：" + r*r*Math.PI);
	}
	
	
	public boolean contain(Point point){
		double distance = Math.sqrt((p.getX()-point.getX())*(p.getX()-point.getX()) + (p.getY()-point.getY())*(p.getY()-point.getY()));
		if(distance > r){
//			System.out.println("不在圆内");
			return false;
		}else{
//			System.out.println("在圆内");
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
