package com.ldq.thread;

public class SellWindow extends Thread {
	 private static int ticket = 8;
	    private static Object o = new Object();
	                                                                                                                                                                                          
	    public void run(){
	        while(true){
	                if(ticket > 0){                                     
	                    try {
	                        Thread.sleep(10);
	                    }
	                    catch (Exception ex) {
	                    }
	                                                                                                                                                                                                          
	                    ticket--;
	                    System.out.println (getName() + " sell " + "Tickets_" + (8-ticket));                   
	                }
	                                                                                                                                                                                                      
	                else{
	                    break;
	                }
	        }
	    }
}
