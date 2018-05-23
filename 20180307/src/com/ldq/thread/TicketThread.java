package com.ldq.thread;

public class TicketThread extends Thread{

	private Ticket ticket;// 门票对象
	private int buyNum;// 购买数量
	private static int temp;
	
	public TicketThread(){
	}
	public TicketThread(String name,Ticket ticker, int buyNum) {
		super(name);
		this.ticket = ticker;
		this.buyNum = buyNum;
	}

//	Ticket ticket = new Ticket("老吴巡回南宁站",100);
//    // 2.创建售票线程
//    TicketThread tt1 = new TicketThread("窗口1",ticket,60);
//    TicketThread tt2 = new TicketThread("窗口2",ticket,40);
//    TicketThread tt3 = new TicketThread("窗口3",ticket,20);
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
                	System.out.println(getName()+"购买失败！"+"总共剩余 "  +temp+ "张票");
                }else{
                	System.out.println (getName() + "卖了"+count+"票,"+"总共剩余 "  +temp + "张票"); 
                }
            }
            else{
            	System.out.println(getName()+"购买失败！"+"总共剩余 "  +temp+ "张票");
                break;
            }
    }
	
	}

}
