package com.ldq.collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashMapTest {

	public static void main(String[] args) {
		// Ĭ�Ϲ�������hashset�ײ�ά����һ��hashmap
		// hashmap ��Ϊ�������֣�K��V
		// hashmap��set��Ԫ����ΪK�� ��һ��������ĳ���Objectʵ����ΪV
		HashSet<String> set = new HashSet<>();
		System.out.println(set.add("a"));
		System.out.println(set.add("c"));
		System.out.println(set.add("b"));
		System.out.println(set.add("d"));
		System.out.println(set);
		
		// ����
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
