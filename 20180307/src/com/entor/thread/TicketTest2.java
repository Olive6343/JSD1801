package com.entor.thread;

public class TicketTest2 {
    public static void main(String[] args) {
        //1.������Ʊ����
        // Ticket ticket = new Ticket("����Ѳ������վ", 100);
        TicketRunnable runnable = new TicketRunnable(100, 80);
        // 2.������Ʊ�߳�
        Thread tt1 = new Thread(runnable, "����1");
        Thread tt2 = new Thread(runnable, "����2");
        Thread tt3 = new Thread(runnable, "����3");
        // 3.������Ʊ�߳�
        tt1.start();
        tt2.start();
        tt3.start();
    }
}
