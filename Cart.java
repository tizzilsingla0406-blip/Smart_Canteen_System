package order;

import java.util.ArrayList;
import menu.MenuItem;

public class Cart {

    private ArrayList<OrderItem> cartItems;

    public Cart() {
        cartItems = new ArrayList<>();
    }

    public void addItem(MenuItem item, int quantity) {

        if (item == null || quantity <= 0) {
            System.out.println("Invalid item or quantity!");
            return;
        }

        if (item.getQuantity() < quantity) {
            System.out.println("Not enough stock available!");
            return;
        }

        // Check whether item already exists in cart
        for (OrderItem cartItem : cartItems) {

            if (cartItem.getMenuItem().getItemId()
                    == item.getItemId()) {

                int newQuantity =
                        cartItem.getQuantity() + quantity;

                if (newQuantity > item.getQuantity()) {
                    System.out.println("Not enough stock!");
                    return;
                }

                cartItems.remove(cartItem);
                cartItems.add(new OrderItem(item, newQuantity));

                System.out.println("Cart quantity updated!");
                return;
            }
        }

        cartItems.add(new OrderItem(item, quantity));

        System.out.println("Food added to cart successfully!");
    }

    public void displayCart() {

        if (cartItems.isEmpty()) {
            System.out.println("Your cart is empty!");
            return;
        }

        System.out.println("\n========== YOUR CART ==========");

        for (OrderItem item : cartItems) {
            item.displayOrderItem();
        }

        System.out.println("Total: Rs. " + calculateTotal());
    }

    public double calculateTotal() {

        double total = 0;

        for (OrderItem item : cartItems) {
            total += item.getSubtotal();
        }

        return total;
    }

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    public ArrayList<OrderItem> getCartItems() {
        return cartItems;
    }

    public void clearCart() {
        cartItems.clear();
    }
}