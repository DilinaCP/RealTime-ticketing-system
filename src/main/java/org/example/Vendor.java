package org.example;

public class Vendor implements Runnable {
    private TicketPool ticketPool;
    private int totalTickets;
    private int releaseRate;
    private static int ticketIdCounter = 1;

    public Vendor(TicketPool ticketPool, int totalTickets, int releaseRate) {
        this.ticketPool = ticketPool;
        this.totalTickets = totalTickets;
        this.releaseRate = releaseRate;
    }


    @Override
    public void run() {
        for (int i=0 ; i<totalTickets;i++){
            int ticketId = ticketIdCounter++;
            Tickets ticket = new Tickets(ticketId, "Event", "Location", 1000.0);
            ticketPool.addTicket(ticket);

            try {
                Thread.sleep(releaseRate*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
