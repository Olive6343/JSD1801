package com.ldq.stu;

import java.util.ArrayList;
import java.util.List;
/*
 * 学生测试类
 */
public class StudentTest {

	private Student student;
	public static void main(String[] args) {
		Student stu = new Student();
		Student s1 = new Student(1001,"张三",87);
		Student s2 = new Student(1002,"李四",70);
		Student s3 = new Student(1003,"王五",93);
		Student s4 = new Student(1004,"赵六",80);
		Student s5 = new Student(1005,"田七",75);
		List<Student> stuList = new ArrayList<>();
		stuList.add(s1);
		stuList.add(s2);
		stuList.add(s3);
		stuList.add(s4);
		stuList.add(s5);
		System.out.println(stuList);
		System.out.println("学生所有信息:");
		//列出学生所有信息
		for (Student student : stuList) {
			System.out.println(student);
		}
		
		System.out.println("成绩大于80分学生信息:");
		//查询成绩大于80分学生信息
		if(s1.getScore()>80){
			System.out.println(stuList.get(0));
		}
		if(s2.getScore()>80){
			System.out.println(stuList.get(1));
		}
		if(s3.getScore()>80){
			System.out.println(stuList.get(2));
		}
		if(s4.getScore()>80){
			System.out.println(stuList.get(3));
		}
		if(s5.getScore()>80){
			System.out.println(stuList.get(4));
		}
		//打印平均分
		int average = (s1.getScore()+s2.getScore()+s3.getScore()+s4.getScore()+s5.getScore())/5;
		System.out.println("5个学生的平局分："+average);
		
		for(int i = 1;i<=5;i++){
			 
		}
		// 打印最高分学生的信息
		
	}
	
//	public 
	
	
}
