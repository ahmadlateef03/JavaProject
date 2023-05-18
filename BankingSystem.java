import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankingSystem {
    private Map<String, User> users;

    public BankingSystem() {
        users = new HashMap<>();
    }

    public void createUser(String username, String password) {
        User newUser = new User(username, password);
        users.put(username, newUser);
        System.out.println("User created successfully!");
    }

    public boolean authenticateUser(String username, String password) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            if (user.getPassword().equals(password)) {
                System.out.println("Authentication successful!");
                return true;
            }
        }
        System.out.println("Authentication failed. Invalid username or password.");
        return false;
    }

    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (bankingSystem.authenticateUser(username, password)) {
            // User is authenticated, perform account-related operations here
            // For example, create account, deposit, withdraw, etc.
        }
    }
}

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
