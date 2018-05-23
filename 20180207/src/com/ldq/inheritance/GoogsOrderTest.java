package com.ldq.inheritance;

public class GoogsOrderTest {

	public static void main(String[] args) {
		
		Order d= new Order();
		
		d.setid(001);
		d.setName("Áù±¤²è");
		d.setWeight("500k");
		
		System.out.println(d);
		d.add();
		d.addOrder();
	}
}
