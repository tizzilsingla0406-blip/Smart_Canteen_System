package users;

public class Staff extends User {

    private String designation;

    public Staff(String id, String name, String designation) {
        super(id, name);
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Restaurant Staff");
    }
}