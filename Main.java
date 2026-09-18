import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Movie movie1 = new Movie("Avengers: Endgame", "Action", "3 hours", 250);
        Movie movie2 = new Movie("Interstellar", "Sci-Fi", "2 hours 49 minutes", 200);
        Movie movie3 = new Movie("Inception", "Sci-Fi", "2 hours 28 minutes", 220);

        Seat[] seats = new Seat[15];

for (int i = 0; i < seats.length; i++) {
    char row = (char) ('A' + (i / 5));
    int number = (i % 5) + 1;

    seats[i] = new Seat(row + "" + number);
}
Booking booking = null;
int bookingCounter = 1001;

        int choice;

        do {

            System.out.println("\n================================");
            System.out.println("     MOVIE TICKET BOOKING");
            System.out.println("================================");

            System.out.println("1. View Movies");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

case 1:
    System.out.println("\n========== AVAILABLE MOVIES ==========");

    System.out.println("\n1. " + movie1.name);
    System.out.println("   Genre: " + movie1.genre);
    System.out.println("   Duration: " + movie1.duration);
    System.out.println("   Price: " + movie1.price);

    System.out.println("\n2. " + movie2.name);
    System.out.println("   Genre: " + movie2.genre);
    System.out.println("   Duration: " + movie2.duration);
    System.out.println("   Price: " + movie2.price);

    System.out.println("\n3. " + movie3.name);
    System.out.println("   Genre: " + movie3.genre);
    System.out.println("   Duration: " + movie3.duration);
    System.out.println("   Price: " + movie3.price);

    break;

          case 2:

    System.out.println("\n========== BOOK TICKET ==========");

    System.out.println("1. " + movie1.name + " - ₹" + movie1.price);
    System.out.println("2. " + movie2.name + " - ₹" + movie2.price);
    System.out.println("3. " + movie3.name + " - ₹" + movie3.price);

    System.out.print("\nSelect a movie: ");
    int movieChoice = scanner.nextInt();

    Movie selectedMovie = null;

    switch (movieChoice) {

        case 1:
            selectedMovie = movie1;
            break;

        case 2:
            selectedMovie = movie2;
            break;

        case 3:
            selectedMovie = movie3;
            break;

        default:
            System.out.println("Invalid movie choice!");
    }

    if (selectedMovie != null) {

        System.out.println("\nYou selected: " + selectedMovie.name);
        System.out.println("Ticket Price: ₹" + selectedMovie.price);

        System.out.print("Enter number of tickets: ");
        int numberOfTickets = scanner.nextInt();

        if (numberOfTickets <= 0 || numberOfTickets > seats.length) {
            System.out.println("Invalid number of tickets!");
            break;
        }

        System.out.println("\n========== AVAILABLE SEATS ==========");

        for (Seat seat : seats) {

            if (seat.booked) {
                System.out.print("[X] " + seat.seatNumber + "  ");
            } else {
                System.out.print("[ ] " + seat.seatNumber + "  ");
            }

            if (seat.seatNumber.endsWith("5")) {
                System.out.println();
            }
        }

        String[] selectedSeats = new String[numberOfTickets];

        for (int i = 0; i < numberOfTickets; i++) {

            boolean validSeat = false;

            while (!validSeat) {

                System.out.print("\nEnter seat for ticket " + (i + 1) + ": ");
                String seatChoice = scanner.next();

                for (Seat seat : seats) {

                    if (seat.seatNumber.equalsIgnoreCase(seatChoice)) {

                        if (seat.booked) {
                            System.out.println("Seat already booked! Please choose another seat.");
                        } else {

                            seat.bookSeat();
                            selectedSeats[i] = seat.seatNumber;
                            validSeat = true;

                            System.out.println("Seat " + seat.seatNumber + " selected.");
                        }

                        break;
                    }
                }

                if (!validSeat) {
                    boolean seatExists = false;

                    for (Seat seat : seats) {
                        if (seat.seatNumber.equalsIgnoreCase(seatChoice)) {
                            seatExists = true;
                            break;
                        }
                    }

                    if (!seatExists) {
                        System.out.println("Invalid seat! Please enter a seat like A1, B3, or C5.");
                    }
                }
            }
        }

        double totalAmount = selectedMovie.price * numberOfTickets;
        String bookingId = "BK" + bookingCounter;
        bookingCounter++;

        booking = new Booking(
        bookingId,
        selectedMovie,
        numberOfTickets,
        selectedSeats,
        totalAmount
);
    System.out.println("\n========== BOOKING SUMMARY ==========");

    System.out.println("Booking ID: " + booking.bookingId);
    System.out.println("Movie: " + selectedMovie.name);
    System.out.println("Tickets: " + numberOfTickets);

        System.out.print("Seats: ");

        for (int i = 0; i < selectedSeats.length; i++) {
            System.out.print(selectedSeats[i]);

            if (i < selectedSeats.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("\nTotal amount: ₹" + totalAmount);
        System.out.println("Booking successful!");
    }

    break;      

                case 3:
                    System.out.println("Cancelling ticket...");
                    break;

                case 4:
                    System.out.println("Thank you for using Movie Ticket Booking!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 4);

        scanner.close();
    }
}
