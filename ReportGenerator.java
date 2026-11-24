package report;

import java.util.ArrayList;
import order.Order;
import order.OrderStatus;

public class ReportGenerator {

    public SalesReport generateReport(ArrayList<Order> orders) {

        int totalOrders = 0;

        double totalRevenue = 0;

        for (Order order : orders) {

            if (order.getStatus() != OrderStatus.CANCELLED) {

                totalOrders++;

                totalRevenue += order.calculateTotal();
            }
        }

        double averageOrderValue = 0;

        if (totalOrders > 0) {

            averageOrderValue = totalRevenue / totalOrders;
        }

        return new SalesReport(
            totalOrders,
            totalRevenue,
            averageOrderValue
        );
    }
}