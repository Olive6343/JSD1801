package com.entor.polymorphism;

/**
 * ��ɫֽ��
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
	 * ��ӡ��ӡˢ
	 */
	public void print(){
		System.out.println(getName()+ "�У���ӡ��ɫֽ�ţ�");
	}
}
