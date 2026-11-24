package reservation;

public class Table {

    private int tableNumber;
    private int capacity;
    private boolean available;

    public Table(int tableNumber, int capacity) {

        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.available = true;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {

        this.available = available;
    }

    public void displayTable() {

        System.out.println(
            "Table: " + tableNumber +
            " | Capacity: " + capacity +
            " | Status: " +
            (available ? "Available" : "Reserved")
        );
    }
}