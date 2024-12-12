package org.example;

import java.util.Scanner;

public class CLI {
    private Scanner scanner;

    public CLI() {
        scanner = new Scanner(System.in);
    }

    public Configuration getConfiguration() {
        int totalTickets = getPositiveIntInput("Enter total tickets: ");
        int ticketReleaseRate = getPositiveIntInput("Enter ticket release rate (tickets/second): ");
        int customerRetrievalRate = getPositiveIntInput("Enter customer retrieval rate (customers/second): ");
        int maxTicketCapacity = getPositiveIntInput("Enter max ticket capacity: ");
        return new Configuration(totalTickets, ticketReleaseRate, customerRetrievalRate, maxTicketCapacity);
    }

    private int getPositiveIntInput(String message) {
        int value;
        do {
            System.out.print(message);
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a positive integer.");
                System.out.print(message);
                scanner.next(); // Consume the non-integer input
            }
            value = scanner.nextInt();
            if (value <= 0) {
                System.out.println("Invalid input. Value must be greater than zero.");
            }
        } while (value <= 0);
        return value;
    }

    public void closeScanner() {
        scanner.close();
    }
}