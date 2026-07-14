public abstract class Payment implements PaymentProcessor{
    protected String paymentId;
    protected double amount;
    protected PaymentStatus status;
    protected String bookingId;

    public Payment(String paymentId, double amount, String bookingId) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.bookingId = bookingId;
        this.status = PaymentStatus.PENDING;
    }
    public abstract boolean processPayment();
    public String getPaymentId() { return paymentId; }
    public double getAmount() { return amount; }
    public PaymentStatus getStatus() { return status; }
    public String getBookingId() { return bookingId; }

    public void setStatus(PaymentStatus status) { this.status = status; }
    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", amount=" + amount +
                ", status=" + status +
                ", bookingId='" + bookingId + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return false;
    }
}