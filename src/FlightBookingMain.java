public class FlightBookingMain {
    public static void main(String[] args) {
        try {
            // Initialize system
            FlightBookingSystem system = new FlightBookingSystem();

            // Add sample passengers
            system.addPassenger(new Passenger("P001", "Noman", "noman@example.com", "123-456-7890", "AB123456"));
            system.addPassenger(new Passenger("P002", "Alice", "alice@email.com", "098-765-4321", "CD789012"));
            system.addPassenger(new Passenger("P003", "Charlotte", "charlotte@yahoo.com", "555-123-4567", "EF345678"));
            system.addPassenger(new Passenger("P004", "Aisha", "aisha@email.com", "777-888-9999", "GH901234"));

            // Start GUI
            GUI gui = new GUI(system);
            gui.start();

        } catch (Exception e) {
            System.err.println("System error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}