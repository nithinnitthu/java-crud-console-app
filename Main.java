import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<User> users = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n==== User Management System ====");
            System.out.println("1. Add User");
            System.out.println("2. View Users");
            System.out.println("3. Delete User");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    viewUsers();
                    break;
                case 3:
                    deleteUser();
                    break;
                case 4:
                    System.out.println("Exiting application...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void addUser() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        users.add(new User(name, email));
        System.out.println("User added successfully!");
    }

    public static void viewUsers() {
        if (users.isEmpty()) {
            System.out.println("No users available.");
            return;
        }

        for (int i = 0; i < users.size(); i++) {
            System.out.println(i + ". " + users.get(i));
        }
    }

    public static void deleteUser() {
        viewUsers();
        if (!users.isEmpty()) {
            System.out.print("Enter index to delete: ");
            int index = scanner.nextInt();
            if (index >= 0 && index < users.size()) {
                users.remove(index);
                System.out.println("User deleted successfully!");
            } else {
                System.out.println("Invalid index.");
            }
        }
    }
}
