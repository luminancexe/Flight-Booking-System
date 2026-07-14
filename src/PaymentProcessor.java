public interface PaymentProcessor {
    void processPayment(Payment payment) throws PaymentException;
    boolean processPayment() throws PaymentException;
    boolean validatePayment() throws InvalidPaymentException;
    boolean refundPayment(Payment payment) throws PaymentException;
    boolean isPaymentSuccessful();
    boolean isPaymentFailed();
    boolean isPaymentPending();
    boolean isPaymentCancelled();
    String getPaymentStatus();
    String getPaymentId();
    double getPaymentAmount();
    String getPaymentMethod();
    String getTransactionId();
    String getPaymentDate();
    String getPaymentDescription();
}
