package com.ldq.inheritance;

/**
 * ���ࣺѧ��
 * 
 * @author Administrator
 *
 */
public class Student extends Person{
	private int sno;// ѧ�� 
	
	public Student(){
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}
	
	public void study(){
		System.out.println(this.getName() + "ѧϰ����");
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", getName()=" + this.getName() + ", getAge()=" + getAge() + "]";
	}
	

}
