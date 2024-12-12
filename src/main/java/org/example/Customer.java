package org.example;

public class Customer implements Runnable {
    private TicketPool ticketPool;
    private int totalTickets;
    private int customerBuyRate;

    public Customer(TicketPool ticketPool, int totalTickets, int customerBuyRate) {
        this.ticketPool = ticketPool;
        this.totalTickets = totalTickets;
        this.customerBuyRate = customerBuyRate;
    }

    @Override
    public void run(){
       for (int i=0 ; i<totalTickets ; i++){
           Tickets ticket = ticketPool.retrieveTicket();
           ticketPool.retrieveTicket();
           try {
               Thread.sleep(customerBuyRate*1000);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }
    }

}
