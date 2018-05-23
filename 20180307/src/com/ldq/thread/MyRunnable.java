package com.ldq.thread;

public class MyRunnable implements Runnable{

	@Override
	public void run() {
		for(int i = 1;i<= 50 ;i++){
			System.out.println(Thread.currentThread().getName() + ":" + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
