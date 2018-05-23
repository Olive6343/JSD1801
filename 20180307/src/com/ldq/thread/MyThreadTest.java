package com.ldq.thread;

public class MyThreadTest extends Thread{

	public MyThreadTest(){
	}
	
	public MyThreadTest(String name){
		super(name);
	}

	@Override
	public void run() {
		for(int i=1;i<=50;i++ ){
			try {
				MyThreadTest.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
	
	
}
