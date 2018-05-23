package com.entor.thread;

public class TicketThread extends Thread {
    private int ticket;// ÓàÆ±
    private int number;// ¹ºÂòÕÅÊı

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
            System.out.println(Thread.currentThread().getName() + "¹ºÂò³É¹¦£¬Ê£Óà£º" + (ticket -= number));
        } else {
            System.out.println("ÓàÆ±£º" + ticket + "ÕÅ, ²»×ã" + number + "£¬" + Thread.currentThread().getName() + "¹ºÂòÊ§°Ü£¡");
        }
    }
}
