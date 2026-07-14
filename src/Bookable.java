public interface Bookable {
    void book() throws BookingException;

    void cancel() throws BookingException;

    boolean isAvailable();
    boolean bookSeat() throws SeatNotAvailableException;
    double getPrice();

    String getDescription();
    String getName();
    String getId();
    String getType();
    String getLocation();
    String display();
}

