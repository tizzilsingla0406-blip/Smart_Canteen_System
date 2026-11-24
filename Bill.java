package billing;

import order.Order;

public class Bill {

    private Order order;
    private double subtotal;
    private double discount;
    private double gst;
    private double finalAmount;

    public Bill(
        Order order,
        double subtotal,
        double discount,
        double gst,
        double finalAmount
    ) {

        this.order = order;
        this.subtotal = subtotal;
        this.discount = discount;
        this.gst = gst;
        this.finalAmount = finalAmount;
    }

    public Order getOrder() {
        return order;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getDiscount() {
        return discount;
    }

    public double getGST() {
        return gst;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void displayBill() {

        System.out.println("\n========== BILL DETAILS ==========");

        System.out.println("Order ID: " + order.getOrderId());

        System.out.println("Customer: " +
            order.getCustomer().getName());

        System.out.println("Subtotal: Rs. " + subtotal);

        System.out.println("Discount: Rs. " + discount);

        System.out.println("GST: Rs. " + gst);

        System.out.println("----------------------------------");

        System.out.println("Final Amount: Rs. " + finalAmount);

        System.out.println("==================================");
    }
}