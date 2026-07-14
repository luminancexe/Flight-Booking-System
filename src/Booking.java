
public class Booking implements Displayable, Exportable {
    private final String bookingId;
    private final Passenger passenger;
    private final Flight flight;
    private final Seat seat;
    private BookingStatus status;
    private final String bookingDate;
    private Payment payment;

    public Booking(String bookingId, Passenger passenger, Flight flight, Seat seat) {
        this.bookingId = bookingId;
        this.passenger = passenger;
        this.flight = flight;
        this.seat = seat;
        this.status = BookingStatus.PENDING;
        this.bookingDate = java.time.LocalDateTime.now().toString();
    }

    public String getBookingId() { return bookingId; }
    public Passenger getPassenger() { return passenger; }
    public Flight getFlight() { return flight; }
    public Seat getSeat() { return seat; }
    public BookingStatus getStatus() { return status; }
    public String getBookingDate() { return bookingDate; }
    public Payment getPayment() { return payment; }

    public void setStatus(BookingStatus status) { this.status = status; }
    public void setPayment(Payment payment) { this.payment = payment; }

    public void confirmBooking() throws SeatNotAvailableException {
        if (seat.bookSeat()) {
            status = BookingStatus.CONFIRMED;
            passenger.addBooking(this);
        }
    }

    public void cancelBooking() {
        status = BookingStatus.CANCELLED;
        seat.releaseSeat();
    }

    @Override
    public String display() {
        return "";
    }

    @Override
    public void displayInfo() {
        System.out.println("Booking " + bookingId + ": " + passenger.getName() +
                " - " + flight.getFlightNumber() + " - Seat " + seat.getSeatNumber() +
                " - " + status);
    }

    @Override
    public String getId() {
        return "";
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getEmail() {
        return "";
    }

    @Override
    public String getPhone() {
        return "";
    }

    @Override
    public UserRole getRole() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void setEmail(String email) {

    }

    @Override
    public void setPhone(String phone) {

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
    public void export(ExportFormat format) {

    }

    @Override
    public String exportData(ExportFormat format) {
        return "";
    }

    @Override
    public String generateReport() {
        return "";
    }

    @Override
    public String generateReport(ExportFormat format) {
        return "";
    }

    @Override
    public String generateReport(String criteria) {
        return "";
    }

    @Override
    public String generateReport(String criteria, ExportFormat format) {
        return "";
    }

    @Override
    public String generateReport(String criteria, ExportFormat format, boolean includeDetails) {
        return "";
    }

    @Override
    public String generateReport(String criteria, ExportFormat format, boolean includeDetails, String sortBy) {
        return "";
    }

    @Override
    public String generateReport(String criteria, ExportFormat format, boolean includeDetails, String sortBy, String filter) {
        return "";
    }

    @Override
    public String generateReport(String criteria, ExportFormat format, boolean includeDetails, String sortBy, String filter, boolean showSummary) {
        return "";
    }

    @Override
    public String generateReport(String criteria, ExportFormat format, boolean includeDetails, String sortBy, String filter, boolean showSummary, String additionalInfo) {
        return "";
    }

    @Override
    public String generateReport(String criteria, ExportFormat format, boolean includeDetails, String sortBy, boolean showSummary, String additionalInfo) {
        return "";
    }

    @Override
    public String generateReport(String criteria, ExportFormat format, boolean includeDetails, String sortBy, String filter, boolean showSummary, String additionalInfo, boolean includeMetadata) {
        return "";
    }

    @Override
    public String generateReport(String criteria, ExportFormat format, boolean includeDetails, String sortBy, String filter, boolean showSummary, String additionalInfo, boolean includeMetadata, String language) {
        return "";
    }
}
