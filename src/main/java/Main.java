import java.util.Scanner;

/**
 * Console application for registration and login.
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Login login = new Login();

        System.out.println("=== Registration ===");
        System.out.print("Enter first name: ");
        login.setFirstName(input.nextLine());

        System.out.print("Enter last name: ");
        login.setLastName(input.nextLine());

        System.out.print("Enter username: ");
        login.setUsername(input.nextLine());
        System.out.println(login.getUsernameMessage());

        System.out.print("Enter password: ");
        login.setPassword(input.nextLine());
        System.out.println(login.getPasswordMessage());

        System.out.print("Enter South African cell phone number (include +27 and do not add spaces): ");
        login.setCellPhoneNumber(input.nextLine());
        System.out.println(login.getCellPhoneMessage());

        System.out.println();
        System.out.println(login.registerUser());

        if (!login.checkUserName() || !login.checkPasswordComplexity() || !login.checkCellPhoneNumber()) {
            System.out.println("Registration failed. Please restart the application and try again. Thank you.");
            input.close();
            return;
        }

        System.out.println();
        System.out.println("==== Login ====");
        System.out.print("Enter username: ");
        login.setEnteredUsername(input.nextLine());

        System.out.print("Enter password: ");
        login.setEnteredPassword(input.nextLine());

        System.out.println(login.returnLoginStatus());
        input.close();
    }
}
