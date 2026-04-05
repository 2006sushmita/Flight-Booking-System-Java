import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Flight> flights = new ArrayList<>();
        flights.add(new Flight(101, "Delhi", 5));
        flights.add(new Flight(102, "Mumbai", 3));
        flights.add(new Flight(103, "Bangalore", 4));

        Scanner sc = new Scanner(System.in);
        Payment payment = new Payment();

        int choice=0;

        do {
            System.out.println("\n=== Flight Booking Menu ===");
            System.out.println("1. View Flights");
            System.out.println("2. Book Seat");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                System.out.println("Invalid input! Please enter a number.");
                sc.next();
                continue;
            }

            switch (choice) {

                case 1:
                    for (Flight f : flights) {
                        f.display();
                    }
                    break;

                case 2:
                    System.out.print("Enter Flight ID: ");
                    int id = sc.nextInt();

                    boolean found = false;

                    for (Flight f : flights) {
                        if (f.flightId == id) {
                            found = true;

                            if (f.bookSeat()) {

                                double ticketPrice = 5000;
                                payment.processPayment(ticketPrice, sc);

                                System.out.println("Seat booked successfully!");
                            } else {
                                System.out.println("Flight is full!");
                            }
                        }
                    }

                    if (!found) {
                        System.out.println("Flight not found!");
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);

        sc.close();
    }
}