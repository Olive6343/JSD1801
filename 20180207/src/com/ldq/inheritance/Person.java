package com.ldq.inheritance;

/**
 * 父类：人
 * 
 * @author Administrator
 *
 */
public class Person {

	private  String name;//姓名
	private int age;// 年龄
	public Person(){
	}
//	static{
//		name ="lisi";
//	}
	public  String getName() {
//		System.out.println(name);
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * 人吃东西
	 * 
	 */
	public void eat(){
		System.out.println(name + "吃东西！！！");
	}
}
