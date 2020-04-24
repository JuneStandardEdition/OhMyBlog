package formCheckers;

import DAO.UserDAO;
import beans.User;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * @author June
 */
public class LoginFormChecker {
    private Map<String, String> errors = new HashMap<>();
    
    public User checkForm(HttpServletRequest request) {
        User user;
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        
        // Verif
        // Name: Min 3 chars
        if (name.length() < 3) {
            errors.put("name", "Name requires at least 3 characters.");
        }
        // Email: Contains @
        if (!email.contains("@")) {
            errors.put("email", "Mail is invalid.");
        }
        UserDAO udao = new UserDAO();
        User connectable = udao.findByMail(email);
        user = new User(name, email, null, true);
        return user;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
    
}
