package com.ldq.thread;

public class TicketTest {
    public static void main(String[] args){
        //1.创建门票对象
        Ticket ticket = new Ticket("老吴巡回南宁站",100);
        // 2.创建售票线程
        TicketThread tt1 = new TicketThread("窗口1",ticket,60);
        TicketThread tt2 = new TicketThread("窗口2",ticket,40);
        TicketThread tt3 = new TicketThread("窗口3",ticket,20);
        // 3.启动售票线程
        tt1.start();
        tt2.start();
        tt3.start();
    }
}
