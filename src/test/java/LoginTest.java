import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    private Login registeredUser() {
        Login login = new Login("kyl_1", "Ch&sec@ke99!", "+27838968976", "Kyle", "Smith");
        return login;
    }

    @Test
    public void usernameIsCorrectlyFormatted() {
        Login login = registeredUser();
        login.setEnteredUsername("kyl_1");
        login.setEnteredPassword("Ch&sec@ke99!");
        assertEquals("Welcome Kyle,Smith it is great to see you again.", login.returnLoginStatus());
    }

    @Test
    public void usernameIncorrectlyFormatted() {
        Login login = new Login("kyle!!!!!!!", "Ch&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertEquals(
                "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.",
                login.registerUser()
        );
    }

    @Test
    public void passwordMeetsComplexityRequirements() {
        Login login = registeredUser();
        assertEquals("Password successfully captured.", login.getPasswordMessage());
    }

    @Test
    public void passwordDoesNotMeetComplexityRequirements() {
        Login login = new Login("kyl_1", "password", "+27838968976", "Kyle", "Smith");
        assertEquals(
                "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.",
                login.registerUser()
        );
    }

    @Test
    public void cellPhoneIsCorrectlyFormatted() {
        Login login = registeredUser();
        assertEquals("Cell number successfully captured.", login.getCellPhoneMessage());
    }

    @Test
    public void cellPhoneNumberIsIncorrectlyFormatted() {
        Login login = new Login("kyl_1", "Ch&sec@ke99!", "08966553", "Kyle", "Smith");
        assertEquals(
                "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.",
                login.registerUser()
        );
    }

    @Test
    public void loginSuccessful() {
        Login login = registeredUser();
        login.setEnteredUsername("kyl_1");
        login.setEnteredPassword("Ch&sec@ke99!");
        assertTrue(login.loginUser());
    }

    @Test
    public void loginFailed() {
        Login login = registeredUser();
        login.setEnteredUsername("kyl_1");
        login.setEnteredPassword("wrongPass1!");
        assertFalse(login.loginUser());
    }

    @Test
    public void usernameCorrectlyFormattedBoolean() {
        Login login = registeredUser();
        assertTrue(login.checkUserName());
    }

    @Test
    public void usernameIncorrectlyFormattedBoolean() {
        Login login = new Login("kyle!!!!!!!", "Ch&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertFalse(login.checkUserName());
    }

    @Test
    public void passwordMeetsComplexityBoolean() {
        Login login = registeredUser();
        assertTrue(login.checkPasswordComplexity());
    }

    @Test
    public void passwordDoesNotMeetComplexityBoolean() {
        Login login = new Login("kyl_1", "password", "+27838968976", "Kyle", "Smith");
        assertFalse(login.checkPasswordComplexity());
    }

    @Test
    public void cellPhoneNumberCorrectlyFormattedBoolean() {
        Login login = registeredUser();
        assertTrue(login.checkCellPhoneNumber());
    }

    @Test
    public void cellPhoneNumberIncorrectlyFormattedBoolean() {
        Login login = new Login("kyl_1", "Ch&sec@ke99!", "08966553", "Kyle", "Smith");
        assertFalse(login.checkCellPhoneNumber());
    }
}
