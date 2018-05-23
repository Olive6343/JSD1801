package com.ldq.test;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListTest {

	private static int i = 1;
	public void a(){
		System.out.println("sf");
	}
	public static void f(){
		super();
		a();
		int j = i;
		System.out.println();
	}
	public static void main(String[] args) {
		ArrayList list = new ArrayList<>();
//		list.add(21);
//		list.add(231);
		list.add("21");
		list.add("4");
//		list.addFirt(3);
//		for (Object object : list) {
//			System.out.println(object);
//		}
		for (int i = 0; i < list.size(); i++) {  //第七行
			String str =  (String) list.get(i);               //第八行
			System.out.print(str);         
		}
		System.out.println(list);
		
		LinkedList ll = new LinkedList<>();
		ll.addLast("b");
		ll.add(2, "a");
		String s=(String)ll.get(1);  //null
		System.out.println(s);
		
	}
}
