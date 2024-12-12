package org.example;
public class Tickets {
    private final int id;
    private final String event;
    private final String location;
    private final double price;

    public Tickets(int id, String event, String location, double price) {
        this.id = id;
        this.event = event;
        this.location = location;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getEvent() {
        return event;
    }

    public String getLocation() {
        return location;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Ticket ID " + id;
    }
}