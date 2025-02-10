import java.security.SecureRandom;
import java.util.Scanner;

public class ProfileGenerator {
    private static final SecureRandom random = new SecureRandom();
    private static final String validChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890-_+";
    private static final String validCharArguments = "1234567890";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Your login: ");
        String username = in.nextLine();

        if (!username.matches("[a-zA-Z]+")) {
            System.out.println("Invalid arguments");
            in.close();
            return;
        }

        Profile profile = new Profile(username);
        profile.displayProfile();
        in.close();
    }

    public static String generatePassword(int length) {
        validateLength(length);
        StringBuilder password = new StringBuilder();
        while (password.length() < length) {
            char nextChar = generateRandomChar();
            password.append(nextChar);
        }
        return password.toString();
    }

    public static String generateID(int length) {
        validateLength(length);
        StringBuilder id = new StringBuilder();
        while (id.length() < length) {
            char nextChar = generateRandomCharArguments();
            id.append(nextChar);
        }
        return id.toString();
    }

    private static void validateLength(int length) {
        if (length < 10 || length > 30) {
            throw new IllegalArgumentException("Invalid arguments");
        }
    }

    private static char generateRandomChar() {
        return validChar.charAt(random.nextInt(validChar.length()));
    }

    private static char generateRandomCharArguments() {
        return validCharArguments.charAt(random.nextInt(validCharArguments.length()));
    }
}

class Profile {
    private final String username;
    private final String password;
    private final String ID;

    public Profile(String username) {
        this.username = username;
        this.password = ProfileGenerator.generatePassword(15);
        this.ID = ProfileGenerator.generateID(20);
    }

    public void displayProfile() {
        System.out.println("Your password: " + password);
        System.out.println("Your ID: " + ID);
    }
}




