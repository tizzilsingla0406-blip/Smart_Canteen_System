package billing;

import order.Order;

public class BillCalculator {

    private TaxCalculator taxCalculator;
    private DiscountPolicy discountPolicy;

    public BillCalculator() {

        taxCalculator = new TaxCalculator();

        discountPolicy = new DiscountPolicy();
    }

    public Bill generateBill(Order order) {

        double subtotal = order.calculateTotal();

        double discount =
            discountPolicy.calculateDiscount(subtotal);

        double taxableAmount = subtotal - discount;

        double gst =
            taxCalculator.calculateGST(taxableAmount);

        double finalAmount = taxableAmount + gst;

        Bill bill = new Bill(
            order,
            subtotal,
            discount,
            gst,
            finalAmount
        );

        return bill;
    }
}