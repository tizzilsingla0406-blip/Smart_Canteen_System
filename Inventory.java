package inventory;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<InventoryItem> items;

    public Inventory() {

        items = new ArrayList<>();

        items.add(new InventoryItem(1, "Burger Buns", 50, 10));
        items.add(new InventoryItem(2, "Cheese", 30, 5));
        items.add(new InventoryItem(3, "Tomatoes", 40, 8));
        items.add(new InventoryItem(4, "Pizza Base", 25, 5));
        items.add(new InventoryItem(5, "Milk", 20, 5));
    }

    public void addInventoryItem(InventoryItem item) {

        items.add(item);

        System.out.println("Inventory item added!");
    }

    public InventoryItem findItem(int itemId) {

        for (InventoryItem item : items) {

            if (item.getItemId() == itemId) {
                return item;
            }
        }

        return null;
    }

    public void restockItem(int itemId, int quantity) {

        InventoryItem item = findItem(itemId);

        if (item == null) {

            System.out.println("Inventory item not found!");

            return;
        }

        if (quantity <= 0) {

            System.out.println("Enter a valid quantity!");

            return;
        }

        item.setQuantity(item.getQuantity() + quantity);

        System.out.println("Stock updated successfully!");
    }

    public void displayInventory() {

        System.out.println("\n========== INVENTORY ==========");

        for (InventoryItem item : items) {

            item.displayItem();
        }
    }

    public void displayLowStockItems() {

        System.out.println("\n========== LOW STOCK ITEMS ==========");

        boolean found = false;

        for (InventoryItem item : items) {

            if (item.isLowStock()) {

                item.displayItem();

                found = true;
            }
        }

        if (!found) {
            System.out.println("All inventory levels are sufficient.");
        }
    }
}