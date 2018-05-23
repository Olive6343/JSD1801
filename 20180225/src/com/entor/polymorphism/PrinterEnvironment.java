package com.entor.polymorphism;

/**
 * 打印机环境
 * @author Administrator
 *
 */
public class PrinterEnvironment {

	private String name;// 打印机名称
	public PrinterEnvironment(){
	}

	public PrinterEnvironment(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 打印
	 */
	public void print(){
	}
}
