public class Seat {

    String seatNumber;
    boolean booked;

    Seat(String seatNumber) {
        this.seatNumber = seatNumber;
        this.booked = false;
    }

    void bookSeat() {
        booked = true;
    }
}