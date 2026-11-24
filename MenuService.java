package menu;

public class MenuService {

    private Menu menu;

    public MenuService() {

        menu = new Menu();

        menu.addItem(new MenuItem(
                1, "Burger", 120,
                Category.STARTER, 20
        ));

        menu.addItem(new MenuItem(
                2, "Pizza", 250,
                Category.MAIN_COURSE, 15
        ));

        menu.addItem(new MenuItem(
                3, "Pasta", 180,
                Category.MAIN_COURSE, 12
        ));

        menu.addItem(new MenuItem(
                4, "Ice Cream", 80,
                Category.DESSERT, 10
        ));

        menu.addItem(new MenuItem(
                5, "Cold Coffee", 100,
                Category.BEVERAGE, 20
        ));
    }

    public void displayMenu() {
        menu.displayMenu();
    }

    public Menu getMenu() {
        return menu;
    }
}