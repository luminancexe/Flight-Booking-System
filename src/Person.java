public abstract class Person implements Displayable {
    protected String id;
    protected String name;
    protected String email;
    protected String phone;
    protected UserRole role;

    public Person(String id, String name, String email, String phone, UserRole role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }
    public Person(String id, String name, String email, UserRole role) {
        this(id, name, email, null, role);
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public UserRole getRole() { return role; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
    }

    @Override
    public String toString() {
        return "Person{id='" + id + "', name='" + name + "', email='" + email + "'}";
    }

    public abstract String getDisplayInfoWithNameAndEmail();

    public abstract String getDisplayInfoWithNameAndPhone();
}

