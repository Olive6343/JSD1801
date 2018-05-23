package com.entor.thread;

public class RunnableTest {
    public static void main(String[] args){
        // 1.创建线程对象
        Runnable runnable = new MyRunnable();
        Thread t1 = new Thread(runnable,"线程1");
        Thread t2 = new Thread(runnable,"线程2");
        // 2.启动线程，进入就绪状态
        t1.start();
        t2.start();
    }
}
