package com.ldq.test;

import java.util.LinkedList;

public class LinkedListTest {
	// 创建LinkedList对象
	LinkedList ll = new LinkedList<>();
	/**
	 * 入队
	 * @param object
	 */
	public void in(Object object){
		ll.addFirst(object);
	}
	/**
	 * 出队
	 * @return
	 */
	public Object out(){
		ll.removeLast();
		return ll;
	}
	/**
	 * 判断队列是否为空
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
		//入队
		llt.in("a");
		//入队
		llt.in("c");
		//入队
		llt.in("b");
		System.out.println("出队前的队列："+llt.ll);
		//出队
		llt.out();
		System.out.println("出队后的队列："+llt.ll);
		System.out.println("队列是否为空："+llt.isEmpty());
		
	}
}
