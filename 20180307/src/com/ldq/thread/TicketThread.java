package com.ldq.thread;

public class TicketThread extends Thread{

	private Ticket ticket;// ��Ʊ����
	private int buyNum;// ��������
	private static int temp;
	
	public TicketThread(){
	}
	public TicketThread(String name,Ticket ticker, int buyNum) {
		super(name);
		this.ticket = ticker;
		this.buyNum = buyNum;
	}

//	Ticket ticket = new Ticket("����Ѳ������վ",100);
//    // 2.������Ʊ�߳�
//    TicketThread tt1 = new TicketThread("����1",ticket,60);
//    TicketThread tt2 = new TicketThread("����2",ticket,40);
//    TicketThread tt3 = new TicketThread("����3",ticket,20);
	@Override
	public void run() {
		temp = ticket.getCount();
		int count = 0;
		while(true){
            if(temp - buyNum > 0){                                     
                try {
                    Thread.sleep(10);
                }
                catch (Exception ex) {
                }
                temp--;
//                ticket.getCount()--;
                count++;
                if(temp - buyNum <0){
                	System.out.println(getName()+"����ʧ�ܣ�"+"�ܹ�ʣ�� "  +temp+ "��Ʊ");
                }else{
                	System.out.println (getName() + "����"+count+"Ʊ,"+"�ܹ�ʣ�� "  +temp + "��Ʊ"); 
                }
            }
            else{
            	System.out.println(getName()+"����ʧ�ܣ�"+"�ܹ�ʣ�� "  +temp+ "��Ʊ");
                break;
            }
    }
	
	}

}
