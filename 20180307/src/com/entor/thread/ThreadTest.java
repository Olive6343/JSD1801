package com.entor.thread;

import com.ldq.thread.MyThreadTest;

public class ThreadTest {

	// 假设输入是由一个线程执行
    // 输入联想就是另一个线程在执行
    // 感觉两个线程是同时在执行任务的
    // 这就是多线程的并行效果
	public static void main(String[] args) {
		// 创建线程
		MyThreadTest t1= new MyThreadTest("线程1");
		MyThreadTest t2= new MyThreadTest("线程2");
		// 启动线程，进入就绪状态
		t1.start();;
		t2.start();;
	}
}
