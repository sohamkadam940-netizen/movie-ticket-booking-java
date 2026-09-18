public class Booking {

    String bookingId;
    Movie movie;
    int numberOfTickets;
    String[] selectedSeats;
    double totalAmount;

    Booking(String bookingId, Movie movie, int numberOfTickets,
            String[] selectedSeats, double totalAmount) {

        this.bookingId = bookingId;
        this.movie = movie;
        this.numberOfTickets = numberOfTickets;
        this.selectedSeats = selectedSeats;
        this.totalAmount = totalAmount;
    }
}