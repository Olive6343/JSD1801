package com.ldq.stu;

import java.util.ArrayList;
import java.util.List;
/*
 * ѧ��������
 */
public class StudentTest {

	private Student student;
	public static void main(String[] args) {
		Student stu = new Student();
		Student s1 = new Student(1001,"����",87);
		Student s2 = new Student(1002,"����",70);
		Student s3 = new Student(1003,"����",93);
		Student s4 = new Student(1004,"����",80);
		Student s5 = new Student(1005,"����",75);
		List<Student> stuList = new ArrayList<>();
		stuList.add(s1);
		stuList.add(s2);
		stuList.add(s3);
		stuList.add(s4);
		stuList.add(s5);
		System.out.println(stuList);
		System.out.println("ѧ��������Ϣ:");
		//�г�ѧ��������Ϣ
		for (Student student : stuList) {
			System.out.println(student);
		}
		
		System.out.println("�ɼ�����80��ѧ����Ϣ:");
		//��ѯ�ɼ�����80��ѧ����Ϣ
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
		//��ӡƽ����
		int average = (s1.getScore()+s2.getScore()+s3.getScore()+s4.getScore()+s5.getScore())/5;
		System.out.println("5��ѧ����ƽ�ַ֣�"+average);
		
		for(int i = 1;i<=5;i++){
			 
		}
		// ��ӡ��߷�ѧ������Ϣ
		
	}
	
//	public 
	
	
}
