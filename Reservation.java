package reservation;

import users.Customer;

public class Reservation {

    private String reservationId;
    private Customer customer;
    private Table table;
    private String reservationTime;
    private int numberOfPeople;
    private boolean active;

    public Reservation(
        String reservationId,
        Customer customer,
        Table table,
        String reservationTime,
        int numberOfPeople
    ) {

        this.reservationId = reservationId;
        this.customer = customer;
        this.table = table;
        this.reservationTime = reservationTime;
        this.numberOfPeople = numberOfPeople;
        this.active = true;
    }

    public String getReservationId() {
        return reservationId;
    }

    public Table getTable() {
        return table;
    }

    public boolean isActive() {
        return active;
    }

    public void cancel() {

        active = false;

        table.setAvailable(true);
    }

    public void displayReservation() {

        System.out.println("\n========== RESERVATION ==========");

        System.out.println("Reservation ID: " + reservationId);

        System.out.println("Customer: " + customer.getName());

        System.out.println("Table Number: " + table.getTableNumber());

        System.out.println("People: " + numberOfPeople);

        System.out.println("Time: " + reservationTime);

        System.out.println("Status: " +
            (active ? "Confirmed" : "Cancelled"));
    }
}