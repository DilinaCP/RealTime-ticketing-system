package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final String LOG_FILE = "application.log";

    public static void log(String message, boolean append) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, append))) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.write(timestamp + " - " + message);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Failed to write log: " + e.getMessage());
        }
    }

    // Overloaded method for convenience
    public static void log(String message) {
        log(message, true); // Default to appending
    }
}