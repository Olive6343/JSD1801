package com.ldq.inheritance;


/**
 * 
 * @author Administrator
 *
 */
public class Order extends Goods{

	private int id;// ��ˮ��
	public Order(){
	}
	
	/**
	 * ���
	 */
	public void addOrder(){
		System.out.println(id + "��ˮ������ˣ���");
	}
	
	

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}
	
	public void shout(){
		
	}

	@Override
	public String toString() {
		return "������Ϣ�� [id=" + id + ", getName()=" + getName() + ", getWeight()=" + getWeight() + "]";
	}
	
	
	
}
