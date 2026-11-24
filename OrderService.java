package order;

import java.util.ArrayList;

import menu.Menu;
import menu.MenuItem;
import users.Customer;
import utility.IdGenerator;
import exceptions.InvalidOrderException;
import exceptions.OutOfStockException;

public class OrderService {

    private ArrayList<Order> orders;

    public OrderService() {

        orders = new ArrayList<>();
    }

    public Order createOrder(Customer customer) {

        Order order = new Order(
            IdGenerator.getOrderId(),
            customer
        );

        orders.add(order);

        return order;
    }

    public void addItemToOrder(
        Order order,
        Menu menu,
        int itemId,
        int quantity
    ) throws InvalidOrderException, OutOfStockException {

        if (quantity <= 0) {

            throw new InvalidOrderException(
                "Quantity must be greater than zero!"
            );
        }

        MenuItem item = menu.findItem(itemId);

        if (item == null) {

            throw new InvalidOrderException(
                "Food item not found!"
            );
        }

        if (item.getQuantity() < quantity) {

            throw new OutOfStockException(
                "Not enough stock available!"
            );
        }

        item.setQuantity(item.getQuantity() - quantity);

        OrderItem orderItem = new OrderItem(item, quantity);

        order.addOrderItem(orderItem);

        System.out.println("Item added successfully!");
    }

    public void updateOrderStatus(
        Order order,
        OrderStatus status
    ) {

        order.setStatus(status);

        System.out.println(
            "Order status updated to: " + status
        );
    }

    public void displayAllOrders() {

        if (orders.isEmpty()) {

            System.out.println("No orders available.");

            return;
        }

        for (Order order : orders) {

            order.displayOrder();
        }
    }

    public Order findOrder(String orderId) {

        for (Order order : orders) {

            if (order.getOrderId().equals(orderId)) {

                return order;
            }
        }

        return null;
    }

    public ArrayList<Order> getOrders() {

        return orders;
    }
}