package utility;

import java.util.Scanner;

public class InputHelper {

    private Scanner sc;

    public InputHelper(Scanner sc) {
        this.sc = sc;
    }

    public int readInteger(String message) {

        System.out.print(message);

        while (!sc.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            sc.next();
            System.out.print(message);
        }

        return sc.nextInt();
    }

    public String readString(String message) {

        System.out.print(message);
        return sc.next();
    }
}