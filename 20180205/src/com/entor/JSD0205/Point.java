package com.entor.JSD0205;

/**
 * 平面上的点
 * 
 * @author Administrator
 *
 */
public class Point {
	private int x;// 横坐标
	private int y;// 纵坐标

	public Point() {
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

}
