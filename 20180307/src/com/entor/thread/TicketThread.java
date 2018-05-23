package com.entor.thread;

public class TicketThread extends Thread {
    private int ticket;// ��Ʊ
    private int number;// ��������

    public TicketThread() {
    }

    public TicketThread(String name, int ticket, int number) {
        super(name);
        this.ticket = ticket;
        this.number = number;
    }

    @Override
    public void run() {
        if (ticket - number >= 0) {
            System.out.println(Thread.currentThread().getName() + "����ɹ���ʣ�ࣺ" + (ticket -= number));
        } else {
            System.out.println("��Ʊ��" + ticket + "��, ����" + number + "��" + Thread.currentThread().getName() + "����ʧ�ܣ�");
        }
    }
}
