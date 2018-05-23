package com.entor.thread;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int j = 1; j <= 50; j++) {
            System.out.println(Thread.currentThread().getName() + ":" + j);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
