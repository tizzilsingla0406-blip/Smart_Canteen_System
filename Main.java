import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        RestaurantApp app = new RestaurantApp(sc);

        app.start();

        sc.close();
    }
}