package com.ldq.test;

import java.util.LinkedList;

public class LinkedListTest {
	// ����LinkedList����
	LinkedList ll = new LinkedList<>();
	/**
	 * ���
	 * @param object
	 */
	public void in(Object object){
		ll.addFirst(object);
	}
	/**
	 * ����
	 * @return
	 */
	public Object out(){
		ll.removeLast();
		return ll;
	}
	/**
	 * �ж϶����Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		if(ll.size() == 0){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		LinkedListTest llt = new LinkedListTest();
		//���
		llt.in("a");
		//���
		llt.in("c");
		//���
		llt.in("b");
		System.out.println("����ǰ�Ķ��У�"+llt.ll);
		//����
		llt.out();
		System.out.println("���Ӻ�Ķ��У�"+llt.ll);
		System.out.println("�����Ƿ�Ϊ�գ�"+llt.isEmpty());
		
	}
}
