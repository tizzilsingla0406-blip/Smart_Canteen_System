package report;

public class SalesReport {

    private int totalOrders;
    private double totalRevenue;
    private double averageOrderValue;

    public SalesReport(
        int totalOrders,
        double totalRevenue,
        double averageOrderValue
    ) {

        this.totalOrders = totalOrders;
        this.totalRevenue = totalRevenue;
        this.averageOrderValue = averageOrderValue;
    }

    public void displayReport() {

        System.out.println("\n========== SALES REPORT ==========");

        System.out.println("Total Orders: " + totalOrders);

        System.out.println(
            "Total Revenue: Rs. " + totalRevenue
        );

        System.out.println(
            "Average Order Value: Rs. " + averageOrderValue
        );

        System.out.println("==================================");
    }

    public int getTotalOrders() {
        return totalOrders;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public double getAverageOrderValue() {
        return averageOrderValue;
    }
}