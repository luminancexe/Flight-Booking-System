import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GUI extends JFrame {
    private final FlightBookingSystem system;

    // Search Panel Components
    private JTextField originField, destinationField;
    private JComboBox<String> departureDateBox;
    private DefaultTableModel flightTableModel;

    // Booking Panel Components
    private JTextField passengerIdField, flightIdField, seatNumberField;
    private JTextField nameField, emailField, phoneField, passportField;
    private JComboBox<String> paymentMethodBox;
    private JTextField cardNumberField, expiryDateField, cvvField, paypalEmailField;
    private JTextArea bookingResultArea;
    private JComboBox<Object> seatClassBox;
    private JComboBox<String> availableSeatsBox;

    // View Bookings Components
    private JTable bookingTable;
    private DefaultTableModel bookingTableModel;

    // Reports Components
    private JTextArea reportArea;
    private JComboBox<ExportFormat> exportFormatBox;
    private JPanel bookingForm;

    public GUI(FlightBookingSystem system) {
        this.system = system;
        initializeGUI();
    }

    private void initializeGUI() {
        setTitle("Flight Booking System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Search Flights", createSearchPanel());
        tabbedPane.addTab("Book Flight", createBookingPanel());
        tabbedPane.addTab("View Bookings", createViewBookingsPanel());
        tabbedPane.addTab("Reports", createReportsPanel());
        add(tabbedPane);

        refreshFlightTable();
        refreshBookingTable();
    }

    private JPanel createSearchPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Search Flights"));

        JPanel searchForm = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0; gbc.gridy = 0;
        searchForm.add(new JLabel("Origin:"), gbc);
        gbc.gridx = 1;
        originField = new JTextField(10);
        searchForm.add(originField, gbc);

        gbc.gridx = 2; gbc.gridy = 0;
        searchForm.add(new JLabel("Destination:"), gbc);
        gbc.gridx = 3;
        destinationField = new JTextField(10);
        searchForm.add(destinationField, gbc);

        gbc.gridx = 4; gbc.gridy = 0;
        searchForm.add(new JLabel("Departure Date:"), gbc);
        gbc.gridx = 5;
        departureDateBox = new JComboBox<>();
        populateDateOptions();
        searchForm.add(departureDateBox, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> searchFlights());
        searchForm.add(searchButton, gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        JButton searchByDateButton = new JButton("Search by Date");
        searchByDateButton.addActionListener(e -> searchFlightsByDate());
        searchForm.add(searchByDateButton, gbc);

        gbc.gridx = 2; gbc.gridy = 1;
        JButton showAllButton = new JButton("Show All");
        showAllButton.addActionListener(e -> refreshFlightTable());
        searchForm.add(showAllButton, gbc);

        panel.add(searchForm, BorderLayout.NORTH);

        String[] columns = {"Flight ID", "Flight No", "Origin", "Destination", "Date", "Departure", "Arrival", "Airline", "Status", "Available Seats"};
        flightTableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable flightTable = new JTable(flightTableModel);
        flightTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(flightTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private void populateDateOptions() {
        departureDateBox.removeAllItems();
        departureDateBox.addItem("Any Date");

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd (EEE)");

        for (int i = 0; i < 30; i++) {
            LocalDate date = today.plusDays(i);
            departureDateBox.addItem(date.format(formatter));
        }
    }

    private JPanel createBookingPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Book Flight"));

        bookingForm = new JPanel(new GridBagLayout());
        bookingForm.setPreferredSize(new Dimension(0, 480)); // Prevents resizing when toggling payment fields
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 4;
        JLabel passengerHeader = new JLabel("Passenger Information:");
        passengerHeader.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        bookingForm.add(passengerHeader, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0; bookingForm.add(new JLabel("Passenger ID:"), gbc);
        gbc.gridx = 1; passengerIdField = new JTextField(10); bookingForm.add(passengerIdField, gbc);
        gbc.gridx = 2; bookingForm.add(new JLabel("Name:"), gbc);
        gbc.gridx = 3; nameField = new JTextField(15); bookingForm.add(nameField, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0; bookingForm.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1; emailField = new JTextField(15); bookingForm.add(emailField, gbc);
        gbc.gridx = 2; bookingForm.add(new JLabel("Phone:"), gbc);
        gbc.gridx = 3; phoneField = new JTextField(15); bookingForm.add(phoneField, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0; bookingForm.add(new JLabel("Passport:"), gbc);
        gbc.gridx = 1; passportField = new JTextField(15); bookingForm.add(passportField, gbc);

        gbc.gridy = 4; gbc.gridx = 0; gbc.gridwidth = 4;
        JLabel flightHeader = new JLabel("Flight Information:");
        flightHeader.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        bookingForm.add(flightHeader, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 5;
        gbc.gridx = 0; bookingForm.add(new JLabel("Flight ID:"), gbc);
        gbc.gridx = 1; flightIdField = new JTextField(10); bookingForm.add(flightIdField, gbc);
        gbc.gridx = 2; bookingForm.add(new JLabel("Seat Class:"), gbc);
        gbc.gridx = 3;
        seatClassBox = new JComboBox<>();
        seatClassBox.addItem("Select");
        for (SeatClass sc : SeatClass.values()) {
            seatClassBox.addItem(sc);
        }
        seatClassBox.setSelectedIndex(0);
        seatClassBox.addActionListener(e -> updateAvailableSeats());
        bookingForm.add(seatClassBox, gbc);

        gbc.gridy = 6;
        gbc.gridx = 0; bookingForm.add(new JLabel("Available Seats:"), gbc);
        gbc.gridx = 1; gbc.gridwidth = 2;
        availableSeatsBox = new JComboBox<>();
        bookingForm.add(availableSeatsBox, gbc);

        gbc.gridy = 7;
        gbc.gridx = 0; bookingForm.add(new JLabel("Seat Number:"), gbc);
        gbc.gridx = 1; seatNumberField = new JTextField(10); bookingForm.add(seatNumberField, gbc);

        gbc.gridy = 8; gbc.gridx = 0; gbc.gridwidth = 4;
        JLabel paymentHeader = new JLabel("Payment Information:");
        paymentHeader.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        bookingForm.add(paymentHeader, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 9;
        gbc.gridx = 0; bookingForm.add(new JLabel("Payment Method:"), gbc);
        gbc.gridx = 1;
        paymentMethodBox = new JComboBox<>();
        paymentMethodBox.addItem("Select");
        paymentMethodBox.addItem("Credit Card");
        paymentMethodBox.addItem("PayPal");
        paymentMethodBox.setSelectedIndex(0);
        paymentMethodBox.addActionListener(e -> togglePaymentFields());
        bookingForm.add(paymentMethodBox, gbc);

        gbc.gridy = 10;
        gbc.gridx = 0; bookingForm.add(new JLabel("Card Number:"), gbc);
        gbc.gridx = 1; cardNumberField = new JTextField(16); bookingForm.add(cardNumberField, gbc);
        gbc.gridx = 2; bookingForm.add(new JLabel("Expiry Date (MM/YY):"), gbc);
        gbc.gridx = 3; expiryDateField = new JTextField(5); bookingForm.add(expiryDateField, gbc);

        gbc.gridy = 11;
        gbc.gridx = 0; bookingForm.add(new JLabel("CVV:"), gbc);
        gbc.gridx = 1; cvvField = new JTextField(3); bookingForm.add(cvvField, gbc);

        gbc.gridy = 12;
        gbc.gridx = 0;
        bookingForm.add(new JLabel("PayPal Email:"), gbc);
        gbc.gridx = 1;
        paypalEmailField = new JTextField(20);
        bookingForm.add(paypalEmailField, gbc);

        gbc.gridy = 13; gbc.gridx = 0;
        JButton loadSeatsButton = new JButton("Load Available Seats");
        loadSeatsButton.addActionListener(e -> updateAvailableSeats());
        bookingForm.add(loadSeatsButton, gbc);

        gbc.gridx = 1;
        JButton createPassengerButton = new JButton("Create Passenger");
        createPassengerButton.addActionListener(e -> createPassenger());
        bookingForm.add(createPassengerButton, gbc);

        gbc.gridx = 2;
        JButton bookButton = new JButton("Book Flight");
        bookButton.addActionListener(e -> bookFlight());
        bookingForm.add(bookButton, gbc);

        panel.add(bookingForm, BorderLayout.NORTH);

        bookingResultArea = new JTextArea(10, 50);
        bookingResultArea.setEditable(false);
        bookingResultArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        JScrollPane resultScrollPane = new JScrollPane(bookingResultArea);
        resultScrollPane.setBorder(BorderFactory.createTitledBorder("Booking Results"));
        panel.add(resultScrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createViewBookingsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("View Bookings"));

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> refreshBookingTable());

        JButton cancelButton = new JButton("Cancel Selected Booking");
        cancelButton.addActionListener(e -> cancelSelectedBooking());

        buttonPanel.add(refreshButton);
        buttonPanel.add(cancelButton);
        panel.add(buttonPanel, BorderLayout.NORTH);

        String[] columns = {"Booking ID", "Passenger", "Flight", "Date", "Seat", "Seat Class", "Status", "Booking Date", "Price"};
        bookingTableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        bookingTable = new JTable(bookingTableModel);
        bookingTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(bookingTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createReportsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("System Reports"));

        JPanel controlPanel = new JPanel(new FlowLayout());

        JButton generateReportButton = new JButton("Generate System Report");
        generateReportButton.addActionListener(e -> generateSystemReport());
        controlPanel.add(generateReportButton);

        exportFormatBox = new JComboBox<>(ExportFormat.values());
        controlPanel.add(new JLabel("Export Format:"));
        controlPanel.add(exportFormatBox);

        JButton exportButton = new JButton("Export Data");
        exportButton.addActionListener(e -> exportData());
        controlPanel.add(exportButton);

        panel.add(controlPanel, BorderLayout.NORTH);

        reportArea = new JTextArea(25, 60);
        reportArea.setEditable(false);
        reportArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(reportArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private void togglePaymentFields() {
            String paymentMethod = (String) paymentMethodBox.getSelectedItem();
            boolean isCreditCard = "Credit Card".equals(paymentMethod);
            boolean isPayPal = "PayPal".equals(paymentMethod);

            cardNumberField.setVisible(isCreditCard);
            expiryDateField.setVisible(isCreditCard);
            cvvField.setVisible(isCreditCard);
            // Also set their labels visible/invisible if you have label references

            paypalEmailField.setVisible(isPayPal);
            // Also set PayPal label visible/invisible if you have label reference

            bookingForm.revalidate();
            bookingForm.repaint();
        }

    private void updateAvailableSeats() {
        String flightId = flightIdField.getText().trim();
        if (flightId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter Flight ID first", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Flight flight = system.getFlights().stream()
                .filter(f -> f.getFlightId().equals(flightId))
                .findFirst()
                .orElse(null);

        if (flight == null) {
            JOptionPane.showMessageDialog(this, "Flight not found", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Object selected = seatClassBox.getSelectedItem();
        if (!(selected instanceof SeatClass)) {
            availableSeatsBox.removeAllItems();
            availableSeatsBox.addItem("Select");
            return;
        }
        SeatClass selectedClass = (SeatClass) selected;
        java.util.List<Seat> availableSeats = flight.getAvailableSeatsByClass(selectedClass);

        availableSeatsBox.removeAllItems();
        availableSeatsBox.addItem("Select");

        for (Seat seat : availableSeats) {
            availableSeatsBox.addItem(seat.getSeatNumber() + " - $" + seat.getPrice());
        }

        if (availableSeats.isEmpty()) {
            availableSeatsBox.addItem("No seats available in " + selectedClass + " class");
        }
    }

    private void searchFlights() {
        String origin = originField.getText().trim().toUpperCase();
        String destination = destinationField.getText().trim().toUpperCase();
        String selectedDateStr = (String) departureDateBox.getSelectedItem();

        if (origin.isEmpty() || destination.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both origin and destination", "Input Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        java.util.List<Flight> results;
        if ("Any Date".equals(selectedDateStr)) {
            results = system.searchFlightsByRoute(origin, destination);
        } else {
            LocalDate selectedDate = LocalDate.parse(selectedDateStr.substring(0, 10));
            results = system.searchFlightsByRouteAndDate(origin, destination, selectedDate);
        }

        updateFlightTable(results);
    }

    private void searchFlightsByDate() {
        String selectedDateStr = (String) departureDateBox.getSelectedItem();

        if ("Any Date".equals(selectedDateStr)) {
            refreshFlightTable();
            return;
        }

        LocalDate selectedDate = LocalDate.parse(selectedDateStr.substring(0, 10));
        java.util.List<Flight> results = system.searchFlightsByDate(selectedDate);
        updateFlightTable(results);
    }

    private void refreshFlightTable() {
        updateFlightTable(system.getFlights());
    }

    private void updateFlightTable(List<Flight> flights) {
        flightTableModel.setRowCount(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (Flight flight : flights) {
            Object[] rowData = {
                    flight.getFlightId(),
                    flight.getFlightNumber(),
                    flight.getOrigin().getCode(),
                    flight.getDestination().getCode(),
                    flight.getDepartureDate().format(formatter),
                    flight.getDepartureTime(),
                    flight.getArrivalTime(),
                    flight.getAircraft().getAirline(), // <-- show airline name
                    flight.getStatus(),
                    flight.getAvailableSeats().size()
            };
            flightTableModel.addRow(rowData);
        }
    }

    private void createPassenger() {
        try {
            String id = passengerIdField.getText().trim();
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String phone = phoneField.getText().trim();
            String passport = passportField.getText().trim();

            if (id.isEmpty() || name.isEmpty() || email.isEmpty() || phone.isEmpty() || passport.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all passenger fields", "Input Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Passenger passenger = new Passenger(id, name, email, phone, passport);
            system.addPassenger(passenger);

            bookingResultArea.append("Passenger created successfully: " + passenger.toString() + "\n");
            JOptionPane.showMessageDialog(this, "Passenger created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error creating passenger: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void bookFlight() {
        try {
            String passengerId = passengerIdField.getText().trim();
            String flightId = flightIdField.getText().trim();
            String seatNumber = seatNumberField.getText().trim();

            if (seatNumber.isEmpty() && availableSeatsBox.getSelectedItem() != null) {
                String selectedSeat = (String) availableSeatsBox.getSelectedItem();
                if (!selectedSeat.contains("No seats available")) {
                    seatNumber = selectedSeat.split(" - ")[0];
                }
            }

            if (passengerId.isEmpty() || flightId.isEmpty() || seatNumber.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all booking fields", "Input Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String paymentMethod = (String) paymentMethodBox.getSelectedItem();
            if (!"Credit Card".equals(paymentMethod) && !"PayPal".equals(paymentMethod)) {
                JOptionPane.showMessageDialog(this, "Please select a payment method", "Payment Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Booking booking = system.createBooking(passengerId, flightId, seatNumber);
            bookingResultArea.append("Booking created: " + booking.getBookingId() + "\n");

            Payment payment;
            if ("Credit Card".equals(paymentMethod)) {
                String cardNumber = cardNumberField.getText().trim();
                String expiryDate = expiryDateField.getText().trim();
                String cvv = cvvField.getText().trim();

                if (cardNumber.length() != 16) {
                    JOptionPane.showMessageDialog(this, "Please enter valid 16-digit card number", "Payment Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if (expiryDate.isEmpty() || cvv.length() != 3) {
                    JOptionPane.showMessageDialog(this, "Please enter valid expiry date and CVV", "Payment Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                payment = new CreditCardPayment("PAY" + System.currentTimeMillis(),
                        booking.getSeat().getPrice(), booking.getBookingId(),
                        cardNumber, expiryDate, cvv);
            } else { // PayPal
                String paypalEmail = paypalEmailField.getText().trim();
                if (paypalEmail.isEmpty() || !paypalEmail.contains("@")) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid PayPal email", "Payment Error", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                payment = new PayPalPayment("PAY" + System.currentTimeMillis(),
                        booking.getSeat().getPrice(), booking.getBookingId(), paypalEmail) {
                    @Override
                    public void processPayment(Payment payment) throws PaymentException {
                        // Implement PayPal payment logic if needed
                    }
                };
            }

            if (system.processBookingPayment(booking.getBookingId(), payment)) {
                bookingResultArea.append("Payment successful! Amount: $" + payment.getAmount() + "\n");
                bookingResultArea.append("Booking confirmed: " + booking.toString() + "\n");
                bookingResultArea.append("Seat: " + booking.getSeat().getSeatNumber() +
                        " (" + booking.getSeat().getSeatClass() + " class)\n\n");
                JOptionPane.showMessageDialog(this, "Flight booked successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                refreshBookingTable();
                clearBookingForm();
                updateAvailableSeats();
            }

        } catch (Exception e) {
            bookingResultArea.append("Booking failed: " + e.getMessage() + "\n\n");
            JOptionPane.showMessageDialog(this, "Booking failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearBookingForm() {
        passengerIdField.setText("");
        flightIdField.setText("");
        seatNumberField.setText("");
        cardNumberField.setText("");
        expiryDateField.setText("");
        cvvField.setText("");
        paypalEmailField.setText("");
        availableSeatsBox.removeAllItems();
    }

    private void refreshBookingTable() {
        bookingTableModel.setRowCount(0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (Booking booking : system.getBookings()) {
            Object[] rowData = {
                    booking.getBookingId(),
                    booking.getPassenger().getName(),
                    booking.getFlight().getFlightNumber(),
                    booking.getFlight().getDepartureDate().format(formatter),
                    booking.getSeat().getSeatNumber(),
                    booking.getSeat().getSeatClass(),
                    booking.getStatus(),
                    booking.getBookingDate().substring(0, 10),
                    "$" + booking.getSeat().getPrice()
            };
            bookingTableModel.addRow(rowData);
        }
    }

    private void cancelSelectedBooking() {
        int selectedRow = bookingTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a booking to cancel", "Selection Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String bookingId = (String) bookingTableModel.getValueAt(selectedRow, 0);
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel booking " + bookingId + "?",
                "Confirm Cancellation", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                system.cancelBooking(bookingId);
                JOptionPane.showMessageDialog(this, "Booking cancelled successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                refreshBookingTable();
            } catch (BookingException e) {
                JOptionPane.showMessageDialog(this, "Error cancelling booking: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void generateSystemReport() {
        String report = system.generateReport();
        reportArea.setText(report);
    }

    private void exportData() {
        ExportFormat format = (ExportFormat) exportFormatBox.getSelectedItem();
        assert format != null;
        String exportedData = system.exportData(format);
        reportArea.setText("=== EXPORTED DATA (" + format + ") ===\n\n" + exportedData);
    }

    public void start() {
        SwingUtilities.invokeLater(() -> {
            setVisible(true);
        });
    }
}