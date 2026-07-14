public abstract class Seat implements Bookable, Displayable{
    private String seatNumber;
    private SeatClass seatClass;
    private double price;
    private String flightId;
    private boolean isBooked;
    private boolean isAvailable;



    public Seat(String seatNumber, SeatClass seatClass, double price, String flightId) {
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.price = price;
        this.flightId = flightId;
        this.isBooked = false;
        this.isAvailable = true;
    }

    public void setSeat(String seatNumber, SeatClass seatClass, double price, String flightId) {
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.price = price;
        this.flightId = flightId;
        this.isBooked = false;
        this.isAvailable = true;
    }

    public String getSeatNumber() {
        return seatNumber;
    }
    public SeatClass getSeatClass() {
        return seatClass;
    }
    public double getPrice() {
        return price;
    }
    public void releaseSeat() {
        isBooked = false;
    }
    public String getFlightId() {
        return flightId;
    }
    public boolean isBooked() {
        return isBooked;
    }
    public boolean isAvailable() {
        return this.isAvailable;
    }

    public boolean bookSeat() throws SeatNotAvailableException{
        if (this.isBooked){
            throw new SeatNotAvailableException("Seat " + this.seatNumber + " is already booked.");
        } else {
            this.isBooked = true;
            this.isAvailable = false;
            return true;

        }
    }
    public void cancelBooking() {
        this.isBooked = false;
        this.isAvailable = true;
    }
    @Override
    public String display() {
        return "Seat Number: " + seatNumber + ", Class: " + seatClass + ", Price: $" + price + ", Flight ID: " + flightId +
               ", Booked: " + isBooked + ", Available: " + isAvailable;
    }
    @Override
    public void displayInfo() {
        System.out.println("Seat: " + seatNumber + " (" + seatClass + ") - $" + price +
                " - " + (isBooked ? "BOOKED" : "AVAILABLE"));
    }
    @Override
    public String toString() {
        return "Seat{" +
                "seatNumber='" + seatNumber + '\'' +
                ", seatClass=" + seatClass +
                ", price=" + price +
                ", flightId='" + flightId + '\'' +
                ", isBooked=" + isBooked +
                ", isAvailable=" + isAvailable +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Seat)) return false;
        Seat seat = (Seat) o;
        return Double.compare(seat.price, price) == 0 &&
                isBooked == seat.isBooked &&
                isAvailable == seat.isAvailable &&
                seatNumber.equals(seat.seatNumber) &&
                seatClass == seat.seatClass &&
                flightId.equals(seat.flightId);
    }
}
