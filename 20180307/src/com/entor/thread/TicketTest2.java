package com.entor.thread;

public class TicketTest2 {
    public static void main(String[] args) {
        //1.创建门票对象
        // Ticket ticket = new Ticket("老吴巡回南宁站", 100);
        TicketRunnable runnable = new TicketRunnable(100, 80);
        // 2.创建售票线程
        Thread tt1 = new Thread(runnable, "窗口1");
        Thread tt2 = new Thread(runnable, "窗口2");
        Thread tt3 = new Thread(runnable, "窗口3");
        // 3.启动售票线程
        tt1.start();
        tt2.start();
        tt3.start();
    }
}
