package com.entor.thread;

public class RunnableTest {
    public static void main(String[] args){
        // 1.�����̶߳���
        Runnable runnable = new MyRunnable();
        Thread t1 = new Thread(runnable,"�߳�1");
        Thread t2 = new Thread(runnable,"�߳�2");
        // 2.�����̣߳��������״̬
        t1.start();
        t2.start();
    }
}
