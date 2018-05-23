package com.entor.thread;

public class TicketRunnable implements Runnable {
    private int ticket;
    private int number;

    public TicketRunnable() {
    }

    public TicketRunnable(int ticket, int number) {
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
