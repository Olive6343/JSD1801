package com.entor.iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ����
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
		// ����
		Iterator it = list.iterator();
		while(it.hasNext()){ // �������ϵ�����
			System.out.println(it.next());//  ȡ�ü���Ԫ��
		}
		
		for (Object object : list) {
			System.out.println(object);
		}
	}
}
