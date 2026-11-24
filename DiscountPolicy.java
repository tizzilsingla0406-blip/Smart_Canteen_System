package billing;

public class DiscountPolicy {

    public double calculateDiscount(double amount) {

        if (amount >= 2000) {
            return amount * 0.15;
        }

        else if (amount >= 1000) {
            return amount * 0.10;
        }

        else if (amount >= 500) {
            return amount * 0.05;
        }

        return 0;
    }
}