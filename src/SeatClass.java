public enum SeatClass {
    ECONOMY, BUSINESS, FIRSTCLASS;

    public String getDescription() {
        switch (this) {
            case ECONOMY -> {
                return "Economy Class - Affordable seating with basic amenities.";
            }
            case BUSINESS -> {
                return "Business Class - Enhanced comfort and services.";
            }
            case FIRSTCLASS -> {
                return "First Class - Premium experience with top-notch services.";
            }
            default -> {
                return "Unknown Class";
            }
        }
    }
}
