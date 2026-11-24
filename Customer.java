package users;

public class Customer extends User {

    private String phone;

    public Customer(String id, String name, String phone) {
        super(id, name);
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Customer");
    }
}