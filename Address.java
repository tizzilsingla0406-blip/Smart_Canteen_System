package users;

public class Address {

    private String city;
    private String state;
    private String pinCode;

    public Address(String city, String state, String pinCode) {
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
    }

    public void displayAddress() {
        System.out.println("City: " + city);
        System.out.println("State: " + state);
        System.out.println("PIN Code: " + pinCode);
    }
}