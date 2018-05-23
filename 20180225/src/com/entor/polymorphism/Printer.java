package com.entor.polymorphism;


/**
 * 打印机
 * @author Administrator
 *
 */
public class Printer {

	/**
	 * 打印机印刷
	 */
	public void print(PrinterEnvironment pe){
		pe.print();
	}
	
	public static void main(String[] args) {
		Printer p = new Printer();
		p.print(new BlackWhite("黑白打印机"));
		p.print(new Colorful("彩色打印机"));
	}
}
