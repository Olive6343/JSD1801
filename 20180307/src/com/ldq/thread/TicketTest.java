package com.ldq.thread;

public class TicketTest {
    public static void main(String[] args){
        //1.������Ʊ����
        Ticket ticket = new Ticket("����Ѳ������վ",100);
        // 2.������Ʊ�߳�
        TicketThread tt1 = new TicketThread("����1",ticket,60);
        TicketThread tt2 = new TicketThread("����2",ticket,40);
        TicketThread tt3 = new TicketThread("����3",ticket,20);
        // 3.������Ʊ�߳�
        tt1.start();
        tt2.start();
        tt3.start();
    }
}
