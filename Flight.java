class Flight {
    int flightId;
    String destination;
    int totalSeats;
    int bookedSeats;

    Flight(int flightId, String destination, int totalSeats) {
        this.flightId = flightId;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.bookedSeats = 0;
    }

    boolean bookSeat() {
        if (bookedSeats < totalSeats) {
            bookedSeats++;
            return true;
        }
        return false;
    }

    void display() {
        System.out.println("Flight ID: " + flightId +
                " | Destination: " + destination +
                " | Available Seats: " + (totalSeats - bookedSeats));
    }
}