package com.ldq.inheritance;


/**
 * 测试类
 * 
 * @author Administrator
 *
 */
public class Test {

	public static void main(String[] args) {
		// 1.创建对象
		Student s = new Student();
		// 2. 调用方法
		s.setSno(20180207);
		s.setName("张三");
		s.setAge(20);
		//3. 输出对象
		System.out.println(s);
		// 4. 调用方法
		s.eat();
		s.study();
		
		
		// 1.创建对象
		Teacher t = new Teacher();
		// 2.调用方法
		t.setTno(20180001);
		t.setName("李四");
		t.setAge(26);
		// 3.输出对象
		System.out.println(t);
		t.eat();
		t.teach();

	}
}
