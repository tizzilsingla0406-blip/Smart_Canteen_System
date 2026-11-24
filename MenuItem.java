package menu;

public class MenuItem {

    private int itemId;
    private String itemName;
    private double price;
    private Category category;
    private int quantity;

    public MenuItem(int itemId, String itemName,
                    double price, Category category,
                    int quantity) {

        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void displayItem() {
        System.out.println(
                itemId + " | " + itemName +
                " | Rs. " + price +
                " | " + category +
                " | Stock: " + quantity
        );
    }
}