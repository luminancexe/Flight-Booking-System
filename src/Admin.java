import java.util.List;

public class Admin extends Person {
    private final String adminLevel;
    public Admin(String id, String name, String email, String phone, String adminLevel) {
        super(id, name, email, phone, UserRole.ADMIN);
        this.adminLevel = adminLevel;
    }

    public String getAdminLevel() { return adminLevel; }

    public void manageFlights(List<Flight> flights) {
        System.out.println("Managing flights as admin: " + name);
    }

    @Override
    public String toString() {
        return "Admin{id='" + id + "', name='" + name + "', level='" + adminLevel + "'}";
    }

    @Override
    public String display() {

        return null;
    }

    @Override
    public String getDisplayName() {
        return "";
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

    @Override
    public String getDisplayInfoWithNameAndEmail() {
        return "";
    }
    @Override
    public String getDisplayInfoWithNameAndPhone() {
        return "";
    }

}
