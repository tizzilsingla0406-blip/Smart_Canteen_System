package menu;

public class CategoryManager {

    public void displayCategories() {

        System.out.println("\nFood Categories:");

        for (Category category : Category.values()) {
            System.out.println(category);
        }
    }
}