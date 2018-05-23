package com.ldq.inheritance;


/**
 * 
 * @author Administrator
 *
 */
public class Order extends Goods{

	private int id;// 流水号
	public Order(){
	}
	
	/**
	 * 添加
	 */
	public void addOrder(){
		System.out.println(id + "流水号添加了！！");
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
		return "订单信息： [id=" + id + ", getName()=" + getName() + ", getWeight()=" + getWeight() + "]";
	}
	
	
	
}
