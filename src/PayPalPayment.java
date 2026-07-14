public abstract class PayPalPayment extends Payment {
    private final String paypalEmail;
    private String transactionId;
    private String paymentDate;
    private String description;

    public PayPalPayment(String paymentId, double amount, String bookingId, String paypalEmail) {
        super(paymentId, amount, bookingId);
        this.paypalEmail = paypalEmail;
        this.description = "PayPal payment for booking " + bookingId;
    }

    @Override
    public boolean processPayment() {
        try {
            if (!validatePayment()) {
                throw new PaymentException("PayPal validation failed");
            }
            System.out.println("Processing PayPal payment of $" + amount + " for " + paypalEmail);
            transactionId = "PAYPAL-" + System.currentTimeMillis();
            status = PaymentStatus.COMPLETED;
            paymentDate = java.time.LocalDateTime.now().toString();
            return true;
        } catch (Exception e) {
            status = PaymentStatus.FAILED;
            try {
                throw new PaymentException("PayPal payment processing failed: " + e.getMessage());
            } catch (PaymentException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public boolean validatePayment() throws InvalidPaymentException {
        if (paypalEmail == null || !paypalEmail.contains("@")) {
            throw new InvalidPaymentException("Invalid PayPal email");
        }
        return true;
    }

    // Optional: implement refund logic if needed
    public boolean refundPayment(Payment payment) throws PaymentException {
        if (status != PaymentStatus.COMPLETED) {
            throw new PaymentException("Cannot refund: payment not completed");
        }
        status = PaymentStatus.FAILED; // Or a new REFUNDED status if you add it
        return true;
    }

    public boolean isPaymentSuccessful() {
        return status == PaymentStatus.COMPLETED;
    }

    public boolean isPaymentFailed() {
        return status == PaymentStatus.FAILED;
    }

    public boolean isPaymentPending() {
        return status == PaymentStatus.PENDING;
    }

    public boolean isPaymentCancelled() {
        return false; // Add logic if you support cancellation
    }

    public String getPaymentStatus() {
        return status.name();
    }

    public double getPaymentAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return "PayPal";
    }

    public String getTransactionId() {
        return transactionId != null ? transactionId : "";
    }

    public String getPaymentDate() {
        return paymentDate != null ? paymentDate : "";
    }

    public String getPaymentDescription() {
        return description;
    }

    public String getPaypalEmail() {
        return paypalEmail;
    }
}