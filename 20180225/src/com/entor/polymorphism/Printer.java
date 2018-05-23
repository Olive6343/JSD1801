package com.entor.polymorphism;


/**
 * ��ӡ��
 * @author Administrator
 *
 */
public class Printer {

	/**
	 * ��ӡ��ӡˢ
	 */
	public void print(PrinterEnvironment pe){
		pe.print();
	}
	
	public static void main(String[] args) {
		Printer p = new Printer();
		p.print(new BlackWhite("�ڰ״�ӡ��"));
		p.print(new Colorful("��ɫ��ӡ��"));
	}
}
