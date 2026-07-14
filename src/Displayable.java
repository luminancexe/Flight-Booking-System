public interface Displayable {
    String display();

    void displayInfo();
    String toString();
    String getId();
    String getName();
    String getEmail();
    String getPhone();
    UserRole getRole();
    void setName(String name);
    void setEmail(String email);
    void setPhone(String phone);
    String getDisplayName();
    String getDisplayEmail();
    String getDisplayPhone();
    String getDisplayRole();
    String getDisplayId();
    String getDisplayInfo();
    String getDisplayInfoWithId();
    String getDisplayInfoWithName();
    String getDisplayInfoWithEmail();
    String getDisplayInfoWithPhone();
    String getDisplayInfoWithRole();
    String getDisplayInfoWithIdAndName();
    String getDisplayInfoWithIdAndEmail();
    String getDisplayInfoWithIdAndPhone();
    String getDisplayInfoWithIdAndRole();
}
