package payment;

public class Payment {

    private String paymentId;
    private double amount;
    private PaymentMode paymentMode;
    private String paymentStatus;

    public Payment(
        String paymentId,
        double amount,
        PaymentMode paymentMode,
        String paymentStatus
    ) {

        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMode = paymentMode;
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void displayPayment() {

        System.out.println("\nPayment Details");

        System.out.println("Payment ID: " + paymentId);

        System.out.println("Amount: Rs. " + amount);

        System.out.println("Mode: " + paymentMode);

        System.out.println("Status: " + paymentStatus);
    }
}