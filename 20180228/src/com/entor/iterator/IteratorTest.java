package com.entor.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 迭代
 * 
 * @author Administrator
 *
 */
public class IteratorTest {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(123);
		list.add(333);
		list.add(214);
		// 迭代
		Iterator it = list.iterator();
		while(it.hasNext()){ // 遍历集合的条件
			System.out.println(it.next());//  取得集合元素
		}
		
		for (Object object : list) {
			System.out.println(object);
		}
	}
}
