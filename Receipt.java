package billing;

import payment.Payment;

public class Receipt {

    public void printReceipt(Bill bill, Payment payment) {

        System.out.println("\n");
        System.out.println("==================================");
        System.out.println("       SMART RESTAURANT");
        System.out.println("          PAYMENT RECEIPT");
        System.out.println("==================================");

        System.out.println("Order ID: " +
            bill.getOrder().getOrderId());

        System.out.println("Customer: " +
            bill.getOrder().getCustomer().getName());

        System.out.println("----------------------------------");

        System.out.println("Subtotal: Rs. " +
            bill.getSubtotal());

        System.out.println("Discount: Rs. " +
            bill.getDiscount());

        System.out.println("GST: Rs. " +
            bill.getGST());

        System.out.println("Final Amount: Rs. " +
            bill.getFinalAmount());

        System.out.println("----------------------------------");

        System.out.println("Payment Mode: " +
            payment.getPaymentMode());

        System.out.println("Payment Status: " +
            payment.getPaymentStatus());

        System.out.println("==================================");
        System.out.println("       THANK YOU VISIT AGAIN!");
        System.out.println("==================================");
    }
}