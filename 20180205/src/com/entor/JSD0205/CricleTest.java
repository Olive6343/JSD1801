package com.entor.JSD0205;

public class CricleTest {

	public static void main(String[] args) {
		Point p = new Point(2,4);//圆心坐标
		Circle c = new Circle(p,3);
		c.getArea();
		
		Point p2 = new Point(2,3);
		if(c.contain(p2)){
			System.out.println("在圆内");
		}else{
			System.out.println("不在圆内");
		}
		
		boolean flag = c.contain(8, 7);
		if(flag){
			System.out.println("在圆内");
		}else{
			System.out.println("不在圆内");

		}
	}
}
