public class Aircraft implements Displayable{
    private final String aircraftId;
    private final String model;
    private final int totalSeats;
    private final String airline;

    public Aircraft(String aircraftId, String model, int totalSeats, String airline){
        this.aircraftId = aircraftId;
        this.model = model;
        this.totalSeats = totalSeats;
        this.airline = airline;
    }

    public String getAircraftId() { return aircraftId; }
    public String getModel() { return model; }
    public int getTotalSeats() { return totalSeats; }
    public String getAirline() { return airline; }


    @Override
    public String display() {
        return "";
    }

    @Override
    public void displayInfo() {
        System.out.println("Aircraft ID: " + aircraftId + ", Model: " + model + ", Capacity: " + totalSeats + ", Airline: " + airline);
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "aircraftId='" + aircraftId + '\'' +
                ", model='" + model + '\'' +
                ", totalSeats=" + totalSeats +
                ", airline='" + airline + '\'' +
                '}';
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
        return model + " (" + aircraftId + ")";
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
}