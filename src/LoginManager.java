import java.io.*;
import java.security.*;
import java.util.Scanner;
public class LoginManager {
    private Scanner scanner;
    private AccountManager accountManager;

    public LoginManager() throws IOException {
        scanner = new Scanner(System.in);
        accountManager = new AccountManager();
    }

    // Đăng nhập
    public void login() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        if (!accountManager.containsAccount(username)) {
            System.out.println("Invalid username.");
            return;
        }
        System.out.print("Password: ");
        String password = scanner.nextLine();
        if (accountManager.checkPassword(username, password)) {
            System.out.println("Login success!");
        } else {
            System.out.println("Invalid password.");
        }
    }

    // Đăng ký
    public void register() throws IOException {
        System.out.print( "Username: ");
        String username = scanner.nextLine();
        if (accountManager.containsAccount(username)) {
            System.out.println("Username already exists.");
            return;
        }
        System.out.print("Password: ");
        String password = scanner.nextLine();
        accountManager.addAccount(username, password);
        System.out.println("Account created successfully.");
    }

    // Chạy chương trình
    public void run() throws IOException {
        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    login();
                    break;
                case "2":
                    register();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}