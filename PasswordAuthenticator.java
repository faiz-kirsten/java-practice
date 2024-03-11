import java.io.FileNotFoundException;
import java.util.Formatter;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class PasswordAuthenticator {
    /* Pseudocode
     ask user to input password
     - check if password entered contains any number
      - if it doesn't then ask them to enter a new password write incorrect password to userPasswords.txt
     check if password entered is empty
     - if it is then notify the user and ask the user to enter a new password
     ask user to confirm password
     - if it is not the same as the first password then ask the user to enter a new password
     if it is correct display that the password was created and write it to userPasswords.txt
     create method that will write the password to a file
    */
    public static void main(String[] args) {
//        boolean isEmpty = false;
        String newPassword = "";
        String newPasswordConfirmation;
        boolean containsDigit = false;
        ArrayList<String> passwords = new ArrayList<>();
        while (newPassword.isBlank() || !containsDigit) {
            newPassword = JOptionPane.showInputDialog("Enter new password.");

            passwords.add(newPassword);
            // converts new password to an array of characters
            char[] passwordChars = newPassword.toCharArray();
            // each character in 'passwordChar' is iterated through, and if it is a digit,
            // 'containsDigit' is set to true and the loop is terminated
            for (char pc : passwordChars)
                if (Character.isDigit(pc)) {
                    containsDigit = true;
                    break;
                }

            // Displays a message to user about what they need to correct in their password
            if (newPassword.isBlank() || !containsDigit) {
                JOptionPane.showMessageDialog(null,
                        "Password cannot be empty and must contain at least 1 number.");
            }
        }

        // 'passwords' is iterated through and each iteration is added to 'userPasswords.txt'
        try {
            Formatter f = new Formatter("userPasswords.txt");
            for (String password : passwords) f.format("%s", password + "\n");
            f.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        newPasswordConfirmation = JOptionPane.showInputDialog(null,
                "Please confirm the password.");

        // checks whether password entered matches the confirmed password
        if (!newPasswordConfirmation.equals(newPassword)) {
            System.out.println("Passwords don't match! Therefore new password has not been created.");
            JOptionPane.showMessageDialog(null,
                    "Passwords don't match! Therefore new password has not been created.");
        } else {
            System.out.println("New password successfully created");
            JOptionPane.showMessageDialog(null, "New password successfully created.");
        }
    }
}