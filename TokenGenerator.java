package order;

public class TokenGenerator {

    private static int counter = 1000;

    public static Token generateToken() {

        counter++;

        return new Token(counter);
    }
}