package com.entor.polymorphism;

/**
 * �ڰ�ֽ��
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
	 * ��ӡ��ӡˢ
	 */
	public void print(){
		System.out.println(getName()+ "�У���ӡ�ڰ�ֽ�ţ�");
	}
	
}
