package com.ldq.thread;

public class MyRunnableTest {

	public static void main(String[] args) {
		// 1.创建线程
		MyRunnable myRunnable = new MyRunnable();
		Thread m1 = new Thread(myRunnable,"线程1");
		Thread m2 = new Thread(myRunnable,"线程2");
		// 2.启动线程，进入就绪状态
		m1.start();
		m2.start();
	}
}
