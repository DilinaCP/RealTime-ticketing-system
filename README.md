Real-Time Ticket Booking System
Introduction
This is a real-time ticket booking system where vendors can release tickets, and customers can retrieve them from a common pool. The system is designed to handle concurrent requests and ensure that tickets are managed efficiently. The application consists of three main components:
•	Frontend: Built with Angular, providing a user interface for configuring and monitoring the system.
•	Backend: Built with Spring Boot, handling the core logic, and providing a WebSocket API for real-time updates.
•	CLI: A command-line interface for configuring, starting, and stopping the system.
Setup Instructions
Prerequisites
•	Java 17 or later
•	Node.js 18 or later
•	npm 9 or later
•	Maven
•	Angular CLI
How to Build and Run the Application
•	Backend (Spring Boot)
1.Navigate to the web_socket directory.
2.Build the project using Maven:
mvn clean install
3.Run the application:
mvn spring-boot:run
The backend will start on http://localhost:8081.
•	Frontend (Angular)
1.	Navigate to the Angular project directory.
2.	Install dependencies:
npm install
3.	Start the application:
ng serve
The frontend will start on http://localhost:4200.
•	CLI
1.	Navigate to the CLI project directory.
2.	Compile the Java files:
javac *.java
3.	Run the main application:
java Main
Usage Instructions
How to Configure and Start the System
Using the CLI:
1.	Run the CLI application.
2.	Follow the menu prompts to configure the system:
o	Enter maximum ticket capacity.
o	Enter total ticket capacity.
o	Enter ticket release rate (ms).
o	Enter ticket retrieval rate (ms).
3.	Choose option 2 to start the system.
4.	The system will save the configuration to config.json.
Using the Frontend:
1.	Open the Angular application in your browser.
2.	Fill in the configuration form:
o	Total Number of Tickets
o	Ticket Release Rate
o	Customer Retrieval Rate
o	Maximum Ticket Capacity
3.	Click "Submit" to save the configuration.
4.	Click "Start" to start the system.
Explanation of UI Controls
1.	Total Number of Tickets: Sets the total number of tickets to be released.
2.	Ticket Release Rate: Sets the rate at which tickets are released by vendors (in milliseconds).
3.	Customer Retrieval Rate: Sets the rate at which tickets are retrieved by customers (in milliseconds).
4.	Maximum Ticket Capacity: Sets the maximum capacity of the ticket pool.
5.	Submit: Saves the current configuration.
6.	Start: Starts the ticket booking system.
7.	Stop: Stops the ticket booking system.
8.	Reset: Reset the system.
9.	Ticket Status: Displays real-time updates on ticket releases and retrievals.
10.	Ticket information
![image](https://github.com/user-attachments/assets/9deeba5e-d710-4bb1-8430-b55fbb28b833)
