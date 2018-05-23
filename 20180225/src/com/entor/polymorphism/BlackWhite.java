package com.entor.polymorphism;

/**
 * 黑白纸张
 * @author Administrator
 *
 */
public class BlackWhite extends PrinterEnvironment{

	public BlackWhite(){
	}
	
	public BlackWhite(String name){
		super(name);
	}
	
	/**
	 * 打印机印刷
	 */
	public void print(){
		System.out.println(getName()+ "中，打印黑白纸张！");
	}
	
}
