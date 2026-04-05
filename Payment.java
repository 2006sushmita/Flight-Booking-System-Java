import java.util.Random;
import java.util.Scanner;

class Payment {

    public void processPayment(double amount, Scanner sc) {

        System.out.println("\nSelect Payment Method:");
        System.out.println("1. UPI");
        System.out.println("2. Credit/Debit Card");
        System.out.println("3. Net Banking");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();
        String method;

        switch (choice) {
            case 1: method = "UPI"; break;
            case 2: method = "Card"; break;
            case 3: method = "Net Banking"; break;
            default:
                System.out.println("Invalid choice! Defaulting to UPI.");
                method = "UPI";
        }

        System.out.println("\nProcessing payment of ₹" + amount + " via " + method + "...");

        String transactionId = generateTransactionId();

        System.out.println("Payment Successful!");
        System.out.println("Transaction ID: " + transactionId);
    }

    private String generateTransactionId() {
        Random rand = new Random();
        return "TXN" + rand.nextInt(999999);
    }
}