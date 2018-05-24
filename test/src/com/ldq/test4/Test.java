package com.ldq.test4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test{
	public Test() {
	}

//	private int = 123;
	private String name;
//	public  boolean isStupidName(String name){return false;};
	
	public String doSomething() {
		return "Do something ...";
		}
	public static void main(String args[]) {
		Test t = new Test();
		
		t.doSomething();
//		
//		doSomething();
		class Foo {
			public int i = 3;
		}
		Object o = (Object) new Foo(); // 第6行
		Foo foo = (Foo) o; // 第7行
		System.out.println(foo.i);
		
		
		ArrayList list = new ArrayList<>();
		list.contains(o);
//		list.removeAll(o);
		LinkedList l = new LinkedList<>();
		l.indexOf(l);
		l.remove(l);
		int[] a = new int[8];
		int s = a.length;
		String ss = "123";
		ss.length();
	}


//	 short s1 = 1; s1 = s1 + 1; short s11 = 1; s11 += 1;
}
