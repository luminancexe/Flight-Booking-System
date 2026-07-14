public class CreditCardPayment extends Payment {
    private final String cardNumber;
    private final String expiryDate;
    private final String cvv;

    public CreditCardPayment(String paymentId, double amount, String bookingId,
                             String cardNumber, String expiryDate, String cvv) {
        super(paymentId, amount, bookingId);
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public void processPayment(Payment payment) throws PaymentException {

    }

    @Override
    public boolean processPayment() {
        try {
            if (!validatePayment()) {
                throw new PaymentException("Credit card validation failed");
            }

            // Simulate payment processing
            System.out.println("Processing credit card payment of $" + amount);
            status = PaymentStatus.COMPLETED;
            return true;
        } catch (Exception e) {
            status = PaymentStatus.FAILED;
            try {
                throw new PaymentException("Payment processing failed: " + e.getMessage());
            } catch (PaymentException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public boolean validatePayment() throws InvalidPaymentException {
        if (cardNumber == null || cardNumber.length() != 16) {
            throw new InvalidPaymentException("Invalid card number");
        }
        if (expiryDate == null || cvv == null || cvv.length() != 3) {
            throw new InvalidPaymentException("Invalid card details");
        }
        return true;
    }

    @Override
    public boolean refundPayment(Payment payment) throws PaymentException {
        return false;
    }

    @Override
    public boolean isPaymentSuccessful() {
        return false;
    }

    @Override
    public boolean isPaymentFailed() {
        return false;
    }

    @Override
    public boolean isPaymentPending() {
        return false;
    }

    @Override
    public boolean isPaymentCancelled() {
        return false;
    }

    @Override
    public String getPaymentStatus() {
        return "";
    }

    @Override
    public double getPaymentAmount() {
        return 0;
    }

    @Override
    public String getPaymentMethod() {
        return "";
    }

    @Override
    public String getTransactionId() {
        return "";
    }

    @Override
    public String getPaymentDate() {
        return "";
    }

    @Override
    public String getPaymentDescription() {
        return "";
    }

    public String getCardNumber() { return "****-****-****-" + cardNumber.substring(12); }
    public String getExpiryDate() { return expiryDate; }
    public String getCvv() { return "***"; }
}
