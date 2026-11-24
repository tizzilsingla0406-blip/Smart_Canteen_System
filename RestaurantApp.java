import order.*;
import billing.*;
import payment.*;
import storage.*;
import exceptions.*;
import java.util.Scanner;
import users.*;
import menu.*;

import utility.IdGenerator;
import utility.DateTimeUtil;
import storage.OrderStorage;
import report.ReportGenerator;
import report.SalesReport;
public class RestaurantApp {

    private Scanner sc;
    private MenuService menuService;
    private OrderService orderService = new OrderService();
    private BillCalculator billCalculator = new BillCalculator();
    private PaymentService paymentService;
    private OrderStorage orderStorage = new OrderStorage();

    public RestaurantApp(Scanner sc) {
        this.sc = sc;
        this.menuService = new MenuService();
        this.paymentService = new PaymentService(sc);
}

    public void start() {

        int choice;

        do {
            System.out.println("\n================================");
            System.out.println(" SMART RESTAURANT MANAGEMENT");
            System.out.println("================================");
            System.out.println("1. Customer Login");
            System.out.println("2. Admin Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    customerLogin();
                    break;

                case 2:
                    adminLogin();
                    break;

                case 3:
                    System.out.println("Thank you for visiting!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);
    }

    private void customerLogin() {

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        Customer customer = new Customer(
            IdGenerator.getCustomerId(),
            name,
            phone
        );

        System.out.println("\nWelcome, " + customer.getName());

        Cart cart = new Cart();

        int choice;

        do {

            System.out.println("\n========== CUSTOMER MENU ==========");
            System.out.println("1. View Food Menu");
            System.out.println("2. Add Food to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Place Order");
            System.out.println("5. Track Order");
            System.out.println("6. Logout");

            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    menuService.displayMenu();
                    break;

                case 2:

                    menuService.displayMenu();

                    System.out.print("Enter Food ID: ");
                    int foodId = sc.nextInt();

                    System.out.print("Enter Quantity: ");
                    int quantity = sc.nextInt();

                    MenuItem item =
                        menuService.getMenu().findItem(foodId);

                    cart.addItem(item, quantity);

                    break;

                case 3:

                    cart.displayCart();
                    break;

                case 4:

                    if (cart.isEmpty()) {

                        System.out.println("Your cart is empty!");

                        break;
                    }

                    Order order = orderService.createOrder(customer);

                    try {

                        for (OrderItem cartItem : cart.getCartItems()) {

                            orderService.addItemToOrder(
                                order,
                                menuService.getMenu(),
                                cartItem.getMenuItem().getItemId(),
                                cartItem.getQuantity()
                            );
                        }

                        Bill bill = billCalculator.generateBill(order);

                        bill.displayBill();

                        Payment payment = paymentService.processPayment(
                            bill.getFinalAmount()
                        );

                        if (payment.getPaymentStatus().equals("SUCCESS")) {

                            Receipt receipt = new Receipt();

                            receipt.printReceipt(bill, payment);

                            orderStorage.saveOrder(order);

                            cart.clearCart();

                        } else {

                            order.setStatus(OrderStatus.CANCELLED);

                            System.out.println("Payment failed!");
                        }

                    } catch (InvalidOrderException |
                            OutOfStockException e) {

                        System.out.println(e.getMessage());

                        order.setStatus(OrderStatus.CANCELLED);
                    }

                    break;

                case 5:

                    System.out.print("Enter Order ID: ");

                    sc.nextLine();

                    String orderId = sc.nextLine();

                    Order foundOrder =
                        orderService.findOrder(orderId);

                    if (foundOrder != null) {

                        foundOrder.displayOrder();

                    } else {

                        System.out.println("Order not found!");
                    }

                    break;

                case 6:

                    System.out.println("Customer logged out!");
                    break;

                default:

                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }

    private void adminLogin() {

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        Admin admin = new Admin("A101", username, password);

        if (admin.login(username, password)) {
            System.out.println("Admin login successful!");
        } else {
            System.out.println("Invalid credentials!");
        }
    }
}