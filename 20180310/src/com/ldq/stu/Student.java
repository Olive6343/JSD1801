package com.ldq.stu;
/**
 * 学生类
 * @author Administrator
 *
 */
public class Student {

	private int id;// 学号
	private String name;// 姓名
	private int score;// 成绩
	public Student() {
		super();
	}
	public Student(int id, String name, int score) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "学生信息： [id=" + id + ", name=" + name + ", score=" + score + "]";
	}
	
	public Student get80Score(){
		if(score>80){
			return null;
		}
		return null;
		
	}
}
