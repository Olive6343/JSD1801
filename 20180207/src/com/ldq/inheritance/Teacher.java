package com.ldq.inheritance;

/**
 * ���ࣺ��ʦ
 * 
 * @author Administrator
 *
 */
public class Teacher extends Person{

	private int tno; // ����
	
	public Teacher(){
	}
	
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	
	/**
	 * �Զ���
	 * 
	 */
	public void teach(){
		System.out.println(this.getName() + "�ڿΣ���");
	}

	@Override
	public String toString() {
		return "Teacher [tno=" + tno + ", getName()=" + this.getName() + ", getAge()=" + this.getAge() + "]";
	}
	
	
}
