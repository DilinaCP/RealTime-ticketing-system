package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Logger;
import java.util.logging.Level;

public class TicketPool {
    private static final Logger logger = Logger.getLogger(TicketPool.class.getName());
    private final int maxCapacity;
    private final Queue<Tickets> ticketsQueue;

    public TicketPool(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.ticketsQueue = new LinkedList<>();
    }

    public synchronized void addTicket(Tickets ticket) {
        while (ticketsQueue.size() >= maxCapacity) {
            try {
                logger.log(Level.INFO, "Ticket pool is full. Waiting for customers to retrieve tickets.");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.log(Level.SEVERE, "Thread interrupted", e);
            }
        }
        ticketsQueue.add(ticket);
        logger.log(Level.INFO, "Vendor added {0}", ticket);
        notifyAll();
    }

    public synchronized Tickets retrieveTicket() {
        while (ticketsQueue.isEmpty()) {
            try {
                logger.log(Level.INFO, "No tickets available. Waiting for tickets to be added to the pool.");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.log(Level.SEVERE, "Thread interrupted", e);
            }
        }
        Tickets ticket = ticketsQueue.poll();
        logger.log(Level.INFO, "Customer bought {0}", ticket);
        notifyAll();
        return ticket;
    }
}