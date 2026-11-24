package storage;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import order.Order;
import order.OrderItem;

import java.util.ArrayList;

public class OrderStorage {

    private String filePath;

    public OrderStorage() {

        filePath = "data/orders.txt";
    }

    public void saveOrder(Order order) {

        try {

            File file = new File(filePath);

            File parent = file.getParentFile();

            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }

            FileWriter writer = new FileWriter(file, true);

            writer.write("================================\n");

            writer.write("Order ID: " + order.getOrderId() + "\n");

            writer.write(
                "Customer: " +
                order.getCustomer().getName() + "\n"
            );

            writer.write(
                "Status: " + order.getStatus() + "\n"
            );

            for (OrderItem item : order.getOrderItems()) {

                writer.write(
                    item.getMenuItem().getItemName() +
                    " | Quantity: " +
                    item.getQuantity() +
                    " | Subtotal: Rs. " +
                    item.getSubtotal() + "\n"
                );
            }

            writer.write(
                "Total: Rs. " + order.calculateTotal() + "\n"
            );

            writer.write("================================\n\n");

            writer.close();

            System.out.println("Order saved successfully!");

        } catch (IOException e) {

            System.out.println(
                "Error saving order: " + e.getMessage()
            );
        }
    }

    public void displaySavedOrders() {

        File file = new File(filePath);

        if (!file.exists()) {

            System.out.println("No saved orders found.");

            return;
        }

        try {

            BufferedReader reader = new BufferedReader(
                new FileReader(file)
            );

            String line;

            System.out.println("\n========== SAVED ORDERS ==========");

            while ((line = reader.readLine()) != null) {

                System.out.println(line);
            }

            reader.close();

        } catch (IOException e) {

            System.out.println(
                "Error reading orders: " + e.getMessage()
            );
        }
    }
}