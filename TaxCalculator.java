package billing;

public class TaxCalculator {

    private double gstRate;

    public TaxCalculator() {
        gstRate = 5.0;
    }

    public double calculateGST(double amount) {

        return amount * gstRate / 100;
    }

    public double getGstRate() {
        return gstRate;
    }

    public void setGstRate(double gstRate) {

        if (gstRate >= 0) {
            this.gstRate = gstRate;
        }
    }
}