package users;

public class Admin extends User {

    private String password;

    public Admin(String id, String username, String password) {
        super(id, username);
        this.password = password;
    }

    public boolean login(String username, String password) {

        return getName().equals(username)
                && this.password.equals(password)
                && username.equals("admin")
                && password.equals("admin123");
    }

    @Override
    public void displayRole() {
        System.out.println("Role: Administrator");
    }
}