package inventory;

public class InventoryItem {

    private int itemId;
    private String itemName;
    private int quantity;
    private int minimumStock;

    public InventoryItem(
        int itemId,
        String itemName,
        int quantity,
        int minimumStock
    ) {

        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.minimumStock = minimumStock;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {

        if (quantity >= 0) {
            this.quantity = quantity;
        }
    }

    public boolean isLowStock() {

        return quantity <= minimumStock;
    }

    public void displayItem() {

        System.out.println(
            itemId + " | " +
            itemName + " | Stock: " +
            quantity
        );

        if (isLowStock()) {
            System.out.println("WARNING: Low stock!");
        }
    }
}