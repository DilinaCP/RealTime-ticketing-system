package org.example;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;

public class SaveConfiguration {
    public static void saveAsJson(Configuration config) {
        Gson gson = new Gson();
        String json = gson.toJson(config);
        try (FileWriter writer = new FileWriter("config.json")) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveAsText(Configuration config) {
        try (FileWriter writer = new FileWriter("config.txt")) {
            writer.write("Max Ticket Capacity: " + config.getMaxTicketCapacity() + "\n");
            writer.write("Total Tickets: " + config.getTotalTickets() + "\n");
            writer.write("Ticket Release Rate: " + config.getTicketReleaseRate() + "\n");
            writer.write("Customer Retrieval Rate: " + config.getCustomerRetrievalRate() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}