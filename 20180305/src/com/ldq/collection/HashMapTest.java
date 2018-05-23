package com.ldq.collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashMapTest {

	public static void main(String[] args) {
		// 默认构造器，hashset底层维护了一个hashmap
		// hashmap 分为两个部分：K和V
		// hashmap将set的元素作为K， 用一个无意义的常量Object实例作为V
		HashSet<String> set = new HashSet<>();
		System.out.println(set.add("a"));
		System.out.println(set.add("c"));
		System.out.println(set.add("b"));
		System.out.println(set.add("d"));
		System.out.println(set);
		
		// 迭代
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
