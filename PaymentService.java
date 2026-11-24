package payment;

import java.util.Scanner;

public class PaymentService {

    private Scanner sc;

    private static int paymentCounter = 100;

    public PaymentService(Scanner sc) {

        this.sc = sc;
    }

    public Payment processPayment(double amount) {

        System.out.println("\n========== PAYMENT ==========");

        System.out.println("Amount to Pay: Rs. " + amount);

        System.out.println("1. Cash Payment");

        System.out.println("2. UPI Payment");

        System.out.print("Choose payment mode: ");

        int choice = sc.nextInt();

        Payment payment;

        if (choice == 1) {

            System.out.println("Cash payment received!");

            payment = new Payment(
                generatePaymentId(),
                amount,
                PaymentMode.CASH,
                "SUCCESS"
            );
        }

        else if (choice == 2) {

            System.out.println("\nUPI Payment");

            System.out.println("Simulating UPI payment...");

            System.out.println("Payment successful!");

            payment = new Payment(
                generatePaymentId(),
                amount,
                PaymentMode.UPI,
                "SUCCESS"
            );
        }

        else {

            System.out.println("Invalid payment option!");

            payment = new Payment(
                generatePaymentId(),
                amount,
                PaymentMode.CASH,
                "FAILED"
            );
        }

        return payment;
    }

    private String generatePaymentId() {

        paymentCounter++;

        return "PAY" + paymentCounter;
    }
}