package com.entor.collection;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList al = new ArrayList();

		al.add(1);
		al.add('d');
		al.add("123");
		al.add(new Exception("hsh"));
		al.add(new int[] { 1, 3, 4, 4 });
		System.out.println(al);

		Object obj = al.get(1);
		System.out.println(obj);

		al.ensureCapacity(20);// 将集合的容量修改成20， 原有元素按顺序放在新数组中，剩余的空间用缺省值赋值
		al.ensureCapacity(1);// 当前容量大于1 ， 修改失败
		System.out.println(al);

		al.add(1, 2.2);// 根据索引插入
		System.out.println(al.get(1));
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
		
		al.remove(new Integer(1)); // 根据元素本身删除
		System.out.println(al);

		int index = al.indexOf("123");// 根据元素找出其索引
		System.out.println(index);
		
		Object[] objs = al.toArray();// 将底层数组的有效元素复制到新的数组
		for (Object object : objs) {
			System.out.println(object);
		}
		
		System.out.println(al.isEmpty());
		al.clear();// 移除此列表中的所有元素: 将元素用缺省值替换掉，再把size置0
		System.out.println(al);
		
		int[] a = {1,4,5,7,0};
		for (int i : a) {
			System.out.println(i);
		}
		
		
	}
}
