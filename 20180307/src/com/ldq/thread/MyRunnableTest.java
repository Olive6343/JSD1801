package com.ldq.thread;

public class MyRunnableTest {

	public static void main(String[] args) {
		// 1.�����߳�
		MyRunnable myRunnable = new MyRunnable();
		Thread m1 = new Thread(myRunnable,"�߳�1");
		Thread m2 = new Thread(myRunnable,"�߳�2");
		// 2.�����̣߳��������״̬
		m1.start();
		m2.start();
	}
}
