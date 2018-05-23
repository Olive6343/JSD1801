package com.entor.JSD0205;

public class Rectangle {

	private Point p;
	private int width;
	private int height;
	
	public Rectangle(){
		
	}

	public Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "¾ØÐÎ£º [p=" + p + ", width=" + width + ", height=" + height + "]";
	}
	
	
	
}
