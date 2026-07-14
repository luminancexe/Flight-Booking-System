import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Flight implements Bookable, Searchable, Displayable {
    private final String flightId;
    private final String flightNumber;
    private final Airport origin;
    private final Airport destination;
    private final String departureTime;
    private final String arrivalTime;
    private final LocalDate departureDate;
    private final Aircraft aircraft;
    private FlightStatus status;
    private final List<Seat> seats;

    public Flight(String flightId, String flightNumber, Airport origin, Airport destination,
                  String departureTime, String arrivalTime, LocalDate departureDate, Aircraft aircraft) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.departureDate = departureDate;
        this.aircraft = aircraft;
        this.status = FlightStatus.SCHEDULED;
        this.seats = new ArrayList<>();
        initializeSeats();
    }

    private void initializeSeats() {
        int totalSeats = aircraft.getTotalSeats();
        int firstClassSeats = (int) (totalSeats * 0.1);    // 10% First Class
        int businessSeats = (int) (totalSeats * 0.2);       // 20% Business
        int economySeats = totalSeats - firstClassSeats - businessSeats; // 70% Economy

        int seatCount = 0;
        int row = 1;

        // First Class: 4 seats per row (A-D)
        char[] firstClassCols = {'A', 'B', 'C', 'D'};
        for (int i = 0; i < firstClassSeats; i++) {
            String seatNumber = row + "" + firstClassCols[i % 4];
            seats.add(new Seat(seatNumber, SeatClass.FIRSTCLASS, 1000.0, flightId) {
                @Override
                public void book() throws BookingException {

                }

                @Override
                public void cancel() throws BookingException {

                }

                @Override
                public String getDescription() {
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
                public String getId() {
                    return "";
                }

                @Override
                public String getType() {
                    return "";
                }

                @Override
                public String getLocation() {
                    return "";
                }
            });
            if ((i + 1) % 4 == 0) row++;
        }

        // Business Class: 4 seats per row (A-D)
        char[] businessCols = {'A', 'B', 'C', 'D'};
        for (int i = 0; i < businessSeats; i++) {
            String seatNumber = row + "" + businessCols[i % 4];
            seats.add(new Seat(seatNumber, SeatClass.BUSINESS, 500.0, flightId) {
                @Override
                public void book() throws BookingException {

                }

                @Override
                public void cancel() throws BookingException {

                }

                @Override
                public String getDescription() {
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
                public String getId() {
                    return "";
                }

                @Override
                public String getType() {
                    return "";
                }

                @Override
                public String getLocation() {
                    return "";
                }
            });
            if ((i + 1) % 4 == 0) row++;
        }

        // Economy Class: 6 seats per row (A-F)
        char[] economyCols = {'A', 'B', 'C', 'D', 'E', 'F'};
        for (int i = 0; i < economySeats; i++) {
            String seatNumber = row + "" + economyCols[i % 6];
            seats.add(new Seat(seatNumber, SeatClass.ECONOMY, 200.0, flightId) {
                @Override
                public void book() throws BookingException {

                }

                @Override
                public void cancel() throws BookingException {

                }

                @Override
                public String getDescription() {
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
                public String getId() {
                    return "";
                }

                @Override
                public String getType() {
                    return "";
                }

                @Override
                public String getLocation() {
                    return "";
                }
            });
            if ((i + 1) % 6 == 0) row++;
        }
    }

    public List<Seat> getAvailableSeats() {
        return seats.stream().filter(Seat::isAvailable).collect(Collectors.toList());
    }

    public List<Seat> getAvailableSeatsByClass(SeatClass seatClass) {
        return seats.stream()
                .filter(seat -> seat.isAvailable() && seat.getSeatClass() == seatClass)
                .collect(Collectors.toList());
    }

    public Seat getSeat(String seatNumber) {
        return seats.stream()
                .filter(seat -> seat.getSeatNumber().equals(seatNumber))
                .findFirst()
                .orElse(null);
    }

    public String getFlightDetails() {
        return String.format("Flight ID: %s, Flight Number: %s, From: %s to %s, Departure: %s, Arrival: %s, Date: %s, Status: %s",
                flightId, flightNumber, origin.getName(), destination.getName(),
                departureTime, arrivalTime, departureDate.toString(), status);
    }

    public String getFlightId() { return flightId; }
    public String getFlightNumber() { return flightNumber; }
    public Airport getOrigin() { return origin; }
    public Airport getDestination() { return destination; }
    public String getDepartureTime() { return departureTime; }
    public String getArrivalTime() { return arrivalTime; }
    public LocalDate getDepartureDate() { return departureDate; }
    public Aircraft getAircraft() { return aircraft; }
    public FlightStatus getStatus() { return status; }
    public List<Seat> getSeats() { return seats; }
    public void setStatus(FlightStatus status) { this.status = status; }

    // Implement interface methods as needed...
    @Override public void book() throws BookingException {}
    @Override public void cancel() throws BookingException {}
    @Override public boolean isAvailable() { return false; }
    @Override public boolean bookSeat() throws SeatNotAvailableException { return false; }
    @Override public double getPrice() { return 0; }
    @Override public String getDescription() { return ""; }
    @Override public String getName() { return ""; }
    @Override public String getEmail() { return ""; }
    @Override public String getPhone() { return ""; }
    @Override public UserRole getRole() { return null; }
    @Override public void setName(String name) {}
    @Override public void setEmail(String email) {}
    @Override public void setPhone(String phone) {}
    @Override public String getDisplayName() { return ""; }
    @Override public String getDisplayEmail() { return ""; }
    @Override public String getDisplayPhone() { return ""; }
    @Override public String getDisplayRole() { return ""; }
    @Override public String getDisplayId() { return ""; }
    @Override public String getDisplayInfo() { return ""; }
    @Override public String getDisplayInfoWithId() { return ""; }
    @Override public String getDisplayInfoWithName() { return ""; }
    @Override public String getDisplayInfoWithEmail() { return ""; }
    @Override public String getDisplayInfoWithPhone() { return ""; }
    @Override public String getDisplayInfoWithRole() { return ""; }
    @Override public String getDisplayInfoWithIdAndName() { return ""; }
    @Override public String getDisplayInfoWithIdAndEmail() { return ""; }
    @Override public String getDisplayInfoWithIdAndPhone() { return ""; }
    @Override public String getDisplayInfoWithIdAndRole() { return ""; }
    @Override public String getId() { return ""; }
    @Override public String getType() { return ""; }
    @Override public String getLocation() { return ""; }
    @Override public String display() { return ""; }
    @Override public void displayInfo() {}
    @Override public void search(String query) {}
    @Override public List<Flight> searchFlights(String criteria) { return List.of(); }
    @Override public List<Flight> filterResults(List<Flight> flights, String filter) { return List.of(); }
    @Override public List<Flight> sortResults(List<Flight> flights, String sortBy) { return List.of(); }
    @Override public List<Flight> getSearchResults() { return List.of(); }
    @Override public void displayResults(List<Flight> flights) {}
    @Override public void clearSearchResults() {}
    @Override public boolean hasSearchResults() { return false; }
    @Override public void setSearchCriteria(String criteria) {}
    @Override public String getSearchCriteria() { return ""; }
    @Override public void setSearchResults(List<Flight> results) {}
    @Override public List<Flight> getSearchResultsList() { return List.of(); }
    @Override public void displaySearchCriteria() {}
    @Override public void displaySearchResults(Flight flight) {}
    @Override public void displaySearchResults(List<Flight> flights) {}
    @Override public void displaySearchResults(String criteria) {}
    @Override public void displaySearchResults(String criteria, List<Flight> flights) {}
    @Override public void displaySearchResults(String criteria, List<Flight> flights, String sortBy) {}
    @Override public void displaySearchResults(String criteria, List<Flight> flights, String sortBy, String filter) {}
    @Override public void displaySearchResults(String criteria, List<Flight> flights, String sortBy, String filter, boolean showDetails) {}
}