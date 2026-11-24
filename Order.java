package order;

import java.util.ArrayList;
import users.Customer;

public class Order {

    private String orderId;
    private Customer customer;
    private ArrayList<OrderItem> orderItems;
    private OrderStatus status;
    private Token token;

    public Order(String orderId, Customer customer) {

        this.orderId = orderId;
        this.customer = customer;

        orderItems = new ArrayList<>();

        status = OrderStatus.PLACED;

        token = TokenGenerator.generateToken();
    }

    public void addOrderItem(OrderItem item) {

        orderItems.add(item);
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Token getToken() {
        return token;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public double calculateTotal() {

        double total = 0;

        for (OrderItem item : orderItems) {

            total += item.getSubtotal();
        }

        return total;
    }

    public void displayOrder() {

        System.out.println("\n========== ORDER DETAILS ==========");

        System.out.println("Order ID: " + orderId);

        System.out.println("Customer: " + customer.getName());

        System.out.println("Order Status: " + status);

        System.out.println("\nOrdered Items:");

        for (OrderItem item : orderItems) {

            item.displayOrderItem();
        }

        System.out.println("-----------------------------------");

        System.out.println("Total: Rs. " + calculateTotal());

        token.displayToken();
    }
}