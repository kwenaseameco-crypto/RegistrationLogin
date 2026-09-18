import java.util.regex.Pattern;

/**
 * Handles user registration and login validation.
 */
public class Login {
    private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;
    private String enteredUsername;
    private String enteredPassword;

    public Login() {
    }

    public Login(String username, String password, String cellPhoneNumber, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEnteredUsername(String enteredUsername) {
        this.enteredUsername = enteredUsername;
    }

    public void setEnteredPassword(String enteredPassword) {
        this.enteredPassword = enteredPassword;
    }

    /**
     * Username must contain an underscore and be no more than five characters long.
     */
    public boolean checkUserName() {
        return username != null
                && username.contains("_")
                && username.length() <= 5;
    }

    /**
     * Password must be at least eight characters, and contain a capital letter,
     * a number, and a special character.
     */
    public boolean checkPasswordComplexity() {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char current = password.charAt(i);
            if (Character.isUpperCase(current)) {
                hasCapital = true;
            } else if (Character.isDigit(current)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(current)) {
                hasSpecial = true;
            }
        }

        return hasCapital && hasNumber && hasSpecial;
    }

    /**
     * South African numbers must start with the international code +27, followed
     * by no more than ten digits.
     */
    public boolean checkCellPhoneNumber() {
        if (cellPhoneNumber == null) {
            return false;
        }

        Pattern saNumber = Pattern.compile("^\\+27[0-9]{1,10}$");
        return saNumber.matcher(cellPhoneNumber).matches();
    }

    /**
     * Returns registration messages based on username, password, and cell number checks.
     */
    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted. Please ensure that your username contains an underscore and is not longer than five characters in length.";
        }

        if (!checkPasswordComplexity()) {
            return "Password is not correctly formattedP please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber()) {
            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }

        return "Username successfully captured.\nPassword successfully captured.\nCell number successfully captured.";
    }

    /**
     * Confirms that the login details entered match the stored registration details.
     */
    public boolean loginUser() {
        if (username == null || password == null || enteredUsername == null || enteredPassword == null) {
            return false;
        }
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }

    /**
     * Returns the success or failure login message.
     */
    public String returnLoginStatus() {
        if (loginUser()) {
            return "Welcome " + firstName + "," + lastName + " it is great to see you again.";
        }
        return "Username or password incorrect, please try again.";
    }

    public String getUsernameMessage() {
        if (checkUserName()) {
            return "Username successfully captured.";
        }
        return "Username is not correctly formatted. Please ensure that your username contains an underscore and is no more than five characters in length.";
    }

    public String getPasswordMessage() {
        if (checkPasswordComplexity()) {
            return "Password successfully captured.";
        }
        return "Password is not correctly formatted. Please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
    }

    public String getCellPhoneMessage() {
        if (checkCellPhoneNumber()) {
            return "Cell number successfully captured.";
        }
        return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
    }
}
