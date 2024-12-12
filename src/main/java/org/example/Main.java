package org.example;

public class Main {
    public static void main(String[] args) {
        Logger.log("Application started");

        CLI cli = new CLI();
        Configuration config = cli.getConfiguration();
        cli.closeScanner();

        TicketPool ticketPool = new TicketPool(config.getMaxTicketCapacity());
        Logger.log("Ticket pool created with capacity: " + config.getMaxTicketCapacity());

        for (int i = 1; i <= 10; i++) {
            Vendor vendor = new Vendor(ticketPool, config.getTotalTickets(), config.getTicketReleaseRate());
            Thread vendorThread = new Thread(vendor, "Vendor " + i);
            vendorThread.start();
            Logger.log("Vendor " + i + " released tickets");
        }

        for (int i = 1; i <= 10; i++) {
            Customer customer = new Customer(ticketPool, config.getTotalTickets(), config.getCustomerRetrievalRate());
            Thread customerThread = new Thread(customer, "Customer " + i);
            customerThread.start();
            Logger.log("Customer " + i + " purchased tickets");
        }

        SaveConfiguration.saveAsJson(config); // Save the new configuration as JSON
        SaveConfiguration.saveAsText(config); // Save the new configuration as text
        Logger.log("Configuration saved.");
        Logger.log("Application finished");
    }
}