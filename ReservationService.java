package reservation;

import java.util.ArrayList;

import users.Customer;

public class ReservationService {

    private ArrayList<Table> tables;
    private ArrayList<Reservation> reservations;

    private static int reservationCounter = 100;

    public ReservationService() {

        tables = new ArrayList<>();

        reservations = new ArrayList<>();

        tables.add(new Table(1, 2));
        tables.add(new Table(2, 2));
        tables.add(new Table(3, 4));
        tables.add(new Table(4, 4));
        tables.add(new Table(5, 6));
        tables.add(new Table(6, 8));
    }

    public void displayTables() {

        System.out.println("\n========== RESTAURANT TABLES ==========");

        for (Table table : tables) {

            table.displayTable();
        }
    }

    public Reservation reserveTable(
        Customer customer,
        int numberOfPeople,
        String time
    ) {

        for (Table table : tables) {

            if (table.isAvailable()
                && table.getCapacity() >= numberOfPeople) {

                table.setAvailable(false);

                reservationCounter++;

                String reservationId = "RES" + reservationCounter;

                Reservation reservation = new Reservation(
                    reservationId,
                    customer,
                    table,
                    time,
                    numberOfPeople
                );

                reservations.add(reservation);

                System.out.println("Table reserved successfully!");

                reservation.displayReservation();

                return reservation;
            }
        }

        System.out.println("No suitable table is available!");

        return null;
    }

    public void cancelReservation(String reservationId) {

        for (Reservation reservation : reservations) {

            if (reservation.getReservationId().equals(reservationId)
                && reservation.isActive()) {

                reservation.cancel();

                System.out.println("Reservation cancelled successfully!");

                return;
            }
        }

        System.out.println("Active reservation not found!");
    }

    public void displayReservations() {

        System.out.println("\n========== ALL RESERVATIONS ==========");

        if (reservations.isEmpty()) {

            System.out.println("No reservations available.");

            return;
        }

        for (Reservation reservation : reservations) {

            reservation.displayReservation();
        }
    }
}