package com.ldq.stu;
/**
 * ѧ����
 * @author Administrator
 *
 */
public class Student {

	private int id;// ѧ��
	private String name;// ����
	private int score;// �ɼ�
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
		return "ѧ����Ϣ�� [id=" + id + ", name=" + name + ", score=" + score + "]";
	}
	
	public Student get80Score(){
		if(score>80){
			return null;
		}
		return null;
		
	}
}
