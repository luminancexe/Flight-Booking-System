import java.util.ArrayList;
import java.util.List;

public class Passenger extends Person {
    private String passportNumber;
    private final List<Booking> bookings;

    public Passenger(String id, String name, String email, String phone, String passportNumber) {
        super(id, name, email, phone, UserRole.PASSENGER);
        this.passportNumber = passportNumber;
        this.bookings = new ArrayList<>();
    }

    @Override
    public String display() {

        return null;
    }

    @Override
    public String getDisplayName() {
        return "";
    }

    @Override
    public String getDisplayEmail() {
        return "";
    }

    @Override
    public String getDisplayPhone() {
        return "";
    }

    @Override
    public String getDisplayRole() {
        return "";
    }

    @Override
    public String getDisplayId() {
        return "";
    }

    @Override
    public String getDisplayInfo() {
        return "";
    }

    @Override
    public String getDisplayInfoWithId() {
        return "";
    }

    @Override
    public String getDisplayInfoWithName() {
        return "";
    }

    @Override
    public String getDisplayInfoWithEmail() {
        return "";
    }

    @Override
    public String getDisplayInfoWithPhone() {
        return "";
    }

    @Override
    public String getDisplayInfoWithRole() {
        return "";
    }

    @Override
    public String getDisplayInfoWithIdAndName() {
        return "";
    }

    @Override
    public String getDisplayInfoWithIdAndEmail() {
        return "";
    }

    @Override
    public String getDisplayInfoWithIdAndPhone() {
        return "";
    }

    @Override
    public String getDisplayInfoWithIdAndRole() {
        return "";
    }

    @Override
    public String toString() {
        return "Passenger{id='" + id + "', name='" + name + "', passport='" + passportNumber + "'}";
    }

    @Override
    public String getDisplayInfoWithNameAndEmail() {
        return "";
    }

    @Override
    public String getDisplayInfoWithNameAndPhone() {
        return "";
    }

    public String getPassportNumber() {
        return passportNumber;
    }
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
    public List<Booking> getBookings() {
        return bookings;
    }
    public void addBooking(Booking booking) {
        this.bookings.add(booking);
    }
    public void removeBooking(Booking booking) {
        this.bookings.remove(booking);
    }
}
