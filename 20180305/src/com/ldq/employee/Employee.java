package com.ldq.employee;

public class Employee {
	private String name; // ����
	private String sex; // �Ա�
	private int workAge; // ����
	private int salary; // нˮ
	private int award; // ����
	public Employee() {
		super();
	}
	public Employee(String name, String sex, int workAge, int salary, int award) {
		this.name = name;
		this.sex = sex;
		this.workAge = workAge;
		this.salary = salary;
		this.award = award;
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
	public int getWorkAge() {
		return workAge;
	}
	public void setWorkAge(int workAge) {
		this.workAge = workAge;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getAward() {
		return award;
	}
	public void setAward(int award) {
		this.award = award;
	}
}