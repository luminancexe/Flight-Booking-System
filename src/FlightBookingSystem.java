import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightBookingSystem {
    private final List<Flight> flights;
    private final List<Passenger> passengers;
    private final List<Airport> airports;
    private final List<Aircraft> aircraft;
    private final List<Booking> bookings;

    public FlightBookingSystem() {
        this.flights = new ArrayList<>();
        this.passengers = new ArrayList<>();
        this.airports = new ArrayList<>();
        this.aircraft = new ArrayList<>();
        this.bookings = new ArrayList<>();
        initializeSampleData();
    }

    private void initializeSampleData() {
        // Add sample airports
        airports.add(new Airport("JFK", "John F. Kennedy International", "New York", "USA"));
        airports.add(new Airport("LAX", "Los Angeles International", "Los Angeles", "USA"));
        airports.add(new Airport("LHR", "London Heathrow", "London", "UK"));
        airports.add(new Airport("SYD", "Sydney Kingsford Smith", "Sydney", "Australia"));
        airports.add(new Airport("HND", "Tokyo Haneda", "Tokyo", "Japan"));
        airports.add(new Airport("DXB", "Dubai International", "Dubai", "UAE"));
        airports.add(new Airport("DOH", "Hamad International", "Doha", "Qatar"));
        airports.add(new Airport("RUH", "King Khalid International", "Riyadh", "Saudi Arabia"));
        airports.add(new Airport("BEY", "Beirut Rafic Hariri", "Beirut", "Lebanon"));
        airports.add(new Airport("AMM", "Queen Alia International", "Amman", "Jordan"));
        airports.add(new Airport("IST", "Istanbul Airport", "Istanbul", "Turkey"));
        airports.add(new Airport("BKK", "Suvarnabhumi", "Bangkok", "Thailand"));
        airports.add(new Airport("CPT", "Cape Town International", "Cape Town", "South Africa"));
        airports.add(new Airport("DAC", "Shahjalal International Airport", "Dhaka", "Bangladesh"));
        airports.add(new Airport("KWI", "Kuwait International Airport", "Kuwait City", "Kuwait"));
        airports.add(new Airport("BAH", "Bahrain International Airport", "Manama", "Bahrain"));
        airports.add(new Airport("DMM", "King Fahd International Airport", "Dammam", "Saudi Arabia"));
        airports.add(new Airport("AUH", "Abu Dhabi International Airport", "Abu Dhabi", "UAE"));

        // Add sample aircraft
        aircraft.add(new Aircraft("AC001", "Boeing 737", 150, "SkyLine Airways"));
        aircraft.add(new Aircraft("AC002", "Airbus A320", 180, "AirMax"));
        aircraft.add(new Aircraft("AC003", "Boeing 787", 200, "Global Air"));
        aircraft.add(new Aircraft("AC004", "Airbus A380", 300, "Mega Airlines"));
        aircraft.add(new Aircraft("AC005", "Embraer E190", 100, "Regional Wings"));
        aircraft.add(new Aircraft("AC006", "Bombardier CRJ900", 90, "Regional Express"));
        aircraft.add(new Aircraft("AC007", "Airbus A350", 300, "Star Airways"));
        aircraft.add(new Aircraft("AC008", "Airbus A380", 215, "Emirates"));
        aircraft.add(new Aircraft("AC009", "Boeing 777", 112, "Etihad Airways"));
        aircraft.add(new Aircraft("AC010", "Airbus A350", 283, "Qatar Airways"));
        aircraft.add(new Aircraft("AC011", "Boeing 787", 208, "Saudi Arabian Airlines"));
        aircraft.add(new Aircraft("AC012", "Airbus A321", 200, "Royal Jordanian"));
        // Additional aircraft
        aircraft.add(new Aircraft("AC013", "Boeing 747", 350, "British Airways"));
        aircraft.add(new Aircraft("AC014", "Airbus A330", 250, "Turkish Airlines"));
        aircraft.add(new Aircraft("AC015", "Boeing 767", 220, "Delta Airlines"));
        aircraft.add(new Aircraft("AC016", "Airbus A319", 144, "Lufthansa"));
        aircraft.add(new Aircraft("AC017", "Boeing 737 MAX", 180, "Southwest Airlines"));
        aircraft.add(new Aircraft("AC018", "Airbus A321neo", 200, "JetBlue"));
        aircraft.add(new Aircraft("AC019", "Boeing 787-9", 280, "Air Canada"));
        aircraft.add(new Aircraft("AC020", "Airbus A350-1000", 350, "Cathay Pacific"));

        // Generate sample flights with dates spread over the next 30 days
        LocalDate today = LocalDate.now();
        flights.add(new Flight("FL001", "EK001", airports.get(5), airports.get(6), "09:00", "12:00", today.plusDays(1), aircraft.get(7)));
        flights.add(new Flight("FL002", "EY002", airports.get(6), airports.get(7), "10:00", "13:30", today.plusDays(1), aircraft.get(8)));
        flights.add(new Flight("FL003", "QR003", airports.get(7), airports.get(8), "12:00", "15:00", today.plusDays(2), aircraft.get(9)));
        flights.add(new Flight("FL004", "SV004", airports.get(8), airports.get(9), "14:00", "17:30", today.plusDays(2), aircraft.get(10)));
        flights.add(new Flight("FL005", "JY005", airports.get(9), airports.get(5), "16:00", "19:30", today.plusDays(3), aircraft.get(11)));
        flights.add(new Flight("FL006", "TK006", airports.get(10), airports.get(13), "08:00", "12:00", today.plusDays(3), aircraft.get(0)));
        flights.add(new Flight("FL007", "AI007", airports.get(13), airports.get(11), "10:00", "14:00", today.plusDays(4), aircraft.get(1)));
        flights.add(new Flight("FL008", "TG008", airports.get(11), airports.get(12), "12:00", "16:00", today.plusDays(5), aircraft.get(2)));
        flights.add(new Flight("FL009", "SA009", airports.get(12), airports.get(3), "14:00", "18:00", today.plusDays(5), aircraft.get(3)));
        flights.add(new Flight("FL010", "QF010", airports.get(3), airports.get(5), "16:00", "20:00", today.plusDays(6), aircraft.get(4)));
        flights.add(new Flight("FL011", "BA011", airports.get(2), airports.get(0), "08:30", "12:30", today.plusDays(7), aircraft.get(5)));
        flights.add(new Flight("FL012", "UA012", airports.get(0), airports.get(1), "14:00", "17:00", today.plusDays(7), aircraft.get(6)));
        flights.add(new Flight("FL013", "LA013", airports.get(1), airports.get(3), "10:00", "14:00", today.plusDays(8), aircraft.get(7)));
        flights.add(new Flight("FL014", "NH014", airports.get(3), airports.get(4), "12:00", "16:00", today.plusDays(9), aircraft.get(8)));
        flights.add(new Flight("FL015", "JL015", airports.get(4), airports.get(13), "14:00", "18:00", today.plusDays(10), aircraft.get(9)));
        flights.add(new Flight("FL016", "AI016", airports.get(13), airports.get(5), "16:00", "20:00", today.plusDays(11), aircraft.get(10)));
        flights.add(new Flight("FL017", "EK017", airports.get(5), airports.get(7), "09:30", "12:30", today.plusDays(12), aircraft.get(11)));
        flights.add(new Flight("FL018", "QR018", airports.get(7), airports.get(9), "11:00", "14:30", today.plusDays(13), aircraft.get(0)));
        flights.add(new Flight("FL019", "SV019", airports.get(9), airports.get(10), "13:00", "16:30", today.plusDays(14), aircraft.get(1)));
        flights.add(new Flight("FL020", "TK020", airports.get(10), airports.get(15), "15:00", "19:00", today.plusDays(15), aircraft.get(2)));
        flights.add(new Flight("FL021", "EK021", airports.get(5), airports.get(13), "11:00", "15:00", today.plusDays(16), aircraft.get(7)));
        flights.add(new Flight("FL022", "QR022", airports.get(6), airports.get(2), "13:00", "18:00", today.plusDays(17), aircraft.get(9)));
        flights.add(new Flight("FL023", "BA023", airports.get(2), airports.get(5), "09:00", "16:00", today.plusDays(18), aircraft.get(5)));
        flights.add(new Flight("FL024", "TK024", airports.get(10), airports.get(0), "12:00", "18:00", today.plusDays(19), aircraft.get(0)));
        flights.add(new Flight("FL025", "AI025", airports.get(13), airports.get(1), "14:00", "22:00", today.plusDays(20), aircraft.get(1)));
        // Additional flights
        flights.add(new Flight("FL026", "BA026", airports.get(2), airports.get(1), "07:00", "10:00", today.plusDays(21), aircraft.get(12)));
        flights.add(new Flight("FL027", "TK027", airports.get(10), airports.get(4), "11:00", "15:00", today.plusDays(22), aircraft.get(13)));
        flights.add(new Flight("FL028", "DL028", airports.get(0), airports.get(3), "13:00", "19:00", today.plusDays(23), aircraft.get(14)));
        flights.add(new Flight("FL029", "LH029", airports.get(4), airports.get(2), "15:00", "20:00", today.plusDays(24), aircraft.get(15)));
        flights.add(new Flight("FL030", "SW030", airports.get(1), airports.get(5), "17:00", "21:00", today.plusDays(25), aircraft.get(16)));
        flights.add(new Flight("FL031", "JB031", airports.get(5), airports.get(7), "19:00", "23:00", today.plusDays(26), aircraft.get(17)));
        flights.add(new Flight("FL032", "AC032", airports.get(6), airports.get(8), "08:00", "12:00", today.plusDays(27), aircraft.get(18)));
        flights.add(new Flight("FL033", "CX033", airports.get(8), airports.get(9), "10:00", "14:00", today.plusDays(28), aircraft.get(19)));
        flights.add(new Flight("FL034", "AF034", airports.get(0), airports.get(4), "06:00", "11:00", today.plusDays(29), aircraft.get(13))); // New York to Tokyo
        flights.add(new Flight("FL035", "DL035", airports.get(1), airports.get(8), "15:30", "22:00", today.plusDays(30), aircraft.get(14))); // Los Angeles to Beirut
        flights.add(new Flight("FL036", "LH036", airports.get(2), airports.get(16), "09:45", "14:30", today.plusDays(27), aircraft.get(15))); // London to Dammam
        flights.add(new Flight("FL037", "AC037", airports.get(6), airports.get(12), "13:20", "19:00", today.plusDays(28), aircraft.get(18))); // Doha to Cape Town
        flights.add(new Flight("FL038", "CX038", airports.get(17), airports.get(3), "21:00", "07:00", today.plusDays(31), aircraft.get(19))); // Abu Dhabi to Sydney
    }

    public Booking createBooking(String passengerId, String flightId, String seatNumber)
            throws BookingException {

        Passenger passenger = findPassenger(passengerId);
        if (passenger == null) {
            throw new PassengerNotFoundException("Passenger not found: " + passengerId);
        }

        Flight flight = findFlight(flightId);
        if (flight == null) {
            throw new FlightNotFoundException("Flight not found: " + flightId);
        }

        Seat seat = flight.getSeat(seatNumber);
        if (seat == null || !seat.isAvailable()) {
            throw new SeatNotAvailableException("Seat not available: " + seatNumber);
        }

        String bookingId = "BK" + System.currentTimeMillis();
        Booking booking = new Booking(bookingId, passenger, flight, seat);
        bookings.add(booking);
        return booking;
    }

    public boolean processBookingPayment(String bookingId, Payment payment)
            throws BookingException, PaymentException {

        Booking booking = findBooking(bookingId);
        if (booking == null) {
            throw new BookingException("Booking not found: " + bookingId);
        }

        if (payment.processPayment()) {
            booking.setPayment(payment);
            booking.confirmBooking();
            return true;
        }
        return false;
    }

    public void cancelBooking(String bookingId) throws BookingException {
        Booking booking = findBooking(bookingId);
        if (booking == null) {
            throw new BookingException("Booking not found: " + bookingId);
        }
        booking.cancelBooking();
    }

    // Search methods
    public List<Flight> searchFlights(String criteria) {
        return flights.stream()
                .filter(f -> f.getOrigin().getCode().contains(criteria) ||
                        f.getDestination().getCode().contains(criteria) ||
                        f.getFlightNumber().contains(criteria))
                .collect(Collectors.toList());
    }

    public List<Flight> filterResults(List<Flight> flights, String filter) {
        return flights.stream()
                .filter(f -> f.getStatus() == FlightStatus.SCHEDULED)
                .collect(Collectors.toList());
    }

    public List<Flight> searchFlightsByRoute(String origin, String destination) {
        return flights.stream()
                .filter(f -> f.getOrigin().getCode().equals(origin) &&
                        f.getDestination().getCode().equals(destination))
                .collect(Collectors.toList());
    }

    public List<Flight> searchFlightsByRouteAndDate(String origin, String destination, LocalDate date) {
        return flights.stream()
                .filter(f -> f.getOrigin().getCode().equals(origin) &&
                        f.getDestination().getCode().equals(destination) &&
                        f.getDepartureDate().equals(date))
                .collect(Collectors.toList());
    }

    public List<Flight> searchFlightsByDate(LocalDate date) {
        return flights.stream()
                .filter(f -> f.getDepartureDate().equals(date))
                .collect(Collectors.toList());
    }

    // Export methods
    public String exportData(ExportFormat format) {
        StringBuilder data = new StringBuilder();
        switch (format) {
            case PDF, EXCEL:
                break;
            case CSV:
                data.append("BookingID,Passenger,Flight,Seat,Status\n");
                for (Booking booking : bookings) {
                    data.append(booking.getBookingId()).append(",")
                            .append(booking.getPassenger().getName()).append(",")
                            .append(booking.getFlight().getFlightNumber()).append(",")
                            .append(booking.getSeat().getSeatNumber()).append(",")
                            .append(booking.getStatus()).append("\n");
                }
                break;
            case TXT:
                data.append("=== BOOKING REPORT ===\n");
                for (Booking booking : bookings) {
                    data.append(booking.toString()).append("\n");
                }
                break;
            default:
                data.append("Export format not supported yet");
        }
        return data.toString();
    }

    // Generate report
    public String generateReport() {
        return "=== FLIGHT BOOKING SYSTEM REPORT ===\n" +
                "Total Flights: " + flights.size() + "\n" +
                "Total Passengers: " + passengers.size() + "\n" +
                "Total Bookings: " + bookings.size() + "\n" +
                "Active Bookings: " +
                bookings.stream().mapToLong(b -> b.getStatus() == BookingStatus.CONFIRMED ? 1 : 0).sum() +
                "\n";
    }


    // Helper methods
    private Passenger findPassenger(String passengerId) {
        return passengers.stream()
                .filter(p -> p.getId().equals(passengerId))
                .findFirst()
                .orElse(null);
    }

    private Flight findFlight(String flightId) {
        return flights.stream()
                .filter(f -> f.getFlightId().equals(flightId))
                .findFirst()
                .orElse(null);
    }

    private Booking findBooking(String bookingId) {
        return bookings.stream()
                .filter(b -> b.getBookingId().equals(bookingId))
                .findFirst()
                .orElse(null);
    }

    // Management methods
    public void addPassenger(Passenger passenger) throws InvalidDataException {
        if (passenger.getName() == null || passenger.getName().isEmpty()) {
            throw new InvalidDataException("Passenger name cannot be empty");
        }
        passengers.add(passenger);
    }
    public void addFlight(Flight flight) { flights.add(flight); }
    public void addAirport(Airport airport) { airports.add(airport); }
    public void addAircraft(Aircraft aircraft) { this.aircraft.add(aircraft); }

    // Getters
    public List<Flight> getFlights() { return new ArrayList<>(flights); }
    public List<Passenger> getPassengers() { return new ArrayList<>(passengers); }
    public List<Booking> getBookings() { return new ArrayList<>(bookings); }
    public List<Airport> getAirports() { return new ArrayList<>(airports); }
}
