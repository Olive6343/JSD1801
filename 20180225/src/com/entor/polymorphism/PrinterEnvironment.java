package com.entor.polymorphism;

/**
 * ��ӡ������
 * @author Administrator
 *
 */
public class PrinterEnvironment {

	private String name;// ��ӡ������
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
	 * ��ӡ
	 */
	public void print(){
	}
}
