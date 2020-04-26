package formCheckers;

import beans.User;
import exceptions.FormException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 * @author June
 */
public class RegisterFormChecker {

    private static final String FIELD_NAME = "name";
    private static final String FIELD_EMAIL = "email";
    private static final String FIELD_PWD = "pwd";
    private static final String FIELD_CONF = "conf";
    private String result; // Global result
    private final Map<String, String> errors = new HashMap<>(); // Errors

    public User checkForm(HttpServletRequest request) {
        try {
            /* Gathering form fields */
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(RegisterFormChecker.class.getName()).log(Level.SEVERE, null, ex);
        }

        String name = request.getParameter(FIELD_NAME);
        String email = request.getParameter(FIELD_EMAIL);
        String pwd = request.getParameter(FIELD_PWD);
        String conf = request.getParameter(FIELD_CONF);
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(pwd);

        /* Checks name */
        try {
            nameCheck(name);
        } catch (FormException e) {
            errors.put(FIELD_NAME, e.getMessage());
        }

        /* Checks email */
        try {
            emailCheck(email);
        } catch (FormException e) {
            errors.put(FIELD_EMAIL, e.getMessage());
        }

        /* Checks pwd and conf */
        try {
            pwdCheck(pwd, conf);
        } catch (FormException e) {
            errors.put(FIELD_PWD, e.getMessage());
        }

        /* Inits result */
        if (errors.isEmpty()) {
            result = "Inscription success.";
        } else {
            result = "Inscription failed.";
        }
        return user;
    }

    /* Field checkers */
    /**
     * Checks if name is valid or not
     */
    private void nameCheck(String name) throws FormException {
        if (name != null && name.length() < 3) {
            throw new FormException("Username must be 3 characters long at least.");
        }
    }

    /**
     * Checks if mail is valid or not
     */
    private void emailCheck(String email) throws FormException {
        if (email != null && email.length() != 0) {
            if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
                throw new FormException("This is not an email, you coward.");
            }
        } else {
            throw new FormException("No email.");
        }
    }

    /**
     * Checks if pwd is valid or not
     */
    private void pwdCheck(String motDePasse, String confirmation) throws FormException {
        if (motDePasse != null && motDePasse.length() != 0 && confirmation != null && confirmation.length() != 0) {
            if (!motDePasse.equals(confirmation)) {
                throw new FormException("Passwords are different, please retype them.");
            } else if (motDePasse.length() < 3) {
                throw new FormException("Password must be 3 characters long at least.");
            }
        } else {
            throw new FormException("Please type and confirm your password.");
        }
    }

    public String getResult() {
        return result;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

}
