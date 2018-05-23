package com.entor.polymorphism;

/**
 * 彩色纸张
 * @author Administrator
 *
 */
public class Colorful extends PrinterEnvironment{

	public Colorful(){
	}
	
	public Colorful(String name){
		super(name);
	}
	
	/**
	 * 打印机印刷
	 */
	public void print(){
		System.out.println(getName()+ "中，打印彩色纸张！");
	}
}
