public class Airport implements Displayable{
    private final String code;
    private final String name;
    private final String city;
    private final String country;

    public Airport(String code, String name, String city, String country) {
        this.code = code;
        this.name = name;
        this.city = city;
        this.country = country;
    }


    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
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

    public String getCity() {
        return city;
    }
    public String getCountry() {
        return country;
    }

    @Override
    public String display() {
        return "";
    }

    @Override
    public void displayInfo() {
        System.out.println("Airport: " + name + " (" + code + ") - " + city + ", " + country);
    }

    @Override
    public String toString() {
        return code + " - " + name + ", " + city;
    }

    @Override
    public String getId() {
        return "";
    }

    @Override
    public String getDisplayName() {
        return name;
    }
    @Override
    public String getDisplayEmail() {
        return "N/A";
    }
    @Override
    public String getDisplayPhone() {
        return "N/A";
    }
    @Override
    public String getDisplayId() {
        return code;
    }
    @Override
    public String getDisplayRole() {
        return "Airport";
    }
    @Override
    public String getDisplayInfo() {
        return "Airport: " + name + " (" + code + ") - " + city + ", " + country;
    }
    @Override
    public String getDisplayInfoWithId() {
        return "Airport ID: " + code + ", Name: " + name + ", City: " + city + ", Country: " + country;
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