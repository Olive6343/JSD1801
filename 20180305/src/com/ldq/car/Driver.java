package com.ldq.car;

/**
 * 司机类
 * @author Administrator
 *
 */
public class Driver {
	private String name;
	private String sex;
	private int age;
	private int driverAge;
	public Driver() {
		super();
	}
	public Driver(String name, String sex, int age, int driverAge) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.driverAge = driverAge;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getDriverAge() {
		return driverAge;
	}
	public void setDriverAge(int driverAge) {
		this.driverAge = driverAge;
	}
	/**
	 * 司机驾驶车
	 * @param car
	 */
	public void drive(Car car){
		 System.out.println(getName()+"开"+car.getBrand()+"车");
	}
	/**
	 * 司机修理车
	 * @param car
	 */
	public void repairCar(Car car){
		System.out.println(getName()+"修理"+car.getBrand()+"车");
	}
}
