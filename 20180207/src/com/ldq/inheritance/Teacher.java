package com.ldq.inheritance;

/**
 * 子类：老师
 * 
 * @author Administrator
 *
 */
public class Teacher extends Person{

	private int tno; // 工号
	
	public Teacher(){
	}
	
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	
	/**
	 * 吃东西
	 * 
	 */
	public void teach(){
		System.out.println(this.getName() + "授课！！");
	}

	@Override
	public String toString() {
		return "Teacher [tno=" + tno + ", getName()=" + this.getName() + ", getAge()=" + this.getAge() + "]";
	}
	
	
}
