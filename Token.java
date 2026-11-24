package order;

public class Token {

    private int tokenNumber;

    public Token(int tokenNumber) {
        this.tokenNumber = tokenNumber;
    }

    public int getTokenNumber() {
        return tokenNumber;
    }

    public void displayToken() {

        System.out.println("\n-------------------------");
        System.out.println("       ORDER TOKEN");
        System.out.println("-------------------------");
        System.out.println("Token Number: " + tokenNumber);
        System.out.println("-------------------------");
    }
}