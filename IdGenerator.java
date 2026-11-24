package utility;

public class IdGenerator {

    private static int customerCounter = 100;

    public static String getCustomerId() {
        customerCounter++;
        return "C" + customerCounter;
    }

    private static int orderCounter = 500;

    public static String getOrderId() {
        orderCounter++;
        return "O" + orderCounter;
    }
}