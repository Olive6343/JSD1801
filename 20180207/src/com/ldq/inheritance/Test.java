package com.ldq.inheritance;


/**
 * ������
 * 
 * @author Administrator
 *
 */
public class Test {

	public static void main(String[] args) {
		// 1.��������
		Student s = new Student();
		// 2. ���÷���
		s.setSno(20180207);
		s.setName("����");
		s.setAge(20);
		//3. �������
		System.out.println(s);
		// 4. ���÷���
		s.eat();
		s.study();
		
		
		// 1.��������
		Teacher t = new Teacher();
		// 2.���÷���
		t.setTno(20180001);
		t.setName("����");
		t.setAge(26);
		// 3.�������
		System.out.println(t);
		t.eat();
		t.teach();

	}
}
