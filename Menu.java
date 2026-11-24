package menu;

import java.util.ArrayList;

public class Menu {

    private ArrayList<MenuItem> items;

    public Menu() {
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    public MenuItem findItem(int id) {

        for (MenuItem item : items) {
            if (item.getItemId() == id) {
                return item;
            }
        }

        return null;
    }

    public void displayMenu() {

        System.out.println("\n--------- FOOD MENU ---------");

        for (MenuItem item : items) {
            item.displayItem();
        }
    }
}