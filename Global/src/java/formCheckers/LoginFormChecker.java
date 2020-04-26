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

    private static final String FIELD_NAME = "name";
    private static final String FIELD_PWD = "password";
    private Map<String, String> errors = new HashMap<>();
    private String result; // Global result

    public User checkForm(HttpServletRequest request) {
        String name = request.getParameter("name");
        String pwd = request.getParameter("password");

        User usr = new User();

        try {
            checkName(name);
        } catch (Exception e) {
            setError(FIELD_NAME, e.getMessage());
        }
        usr.setName(name);

        try {
            checkPwd(name, pwd);
        } catch (Exception e) {
            setError(FIELD_PWD, e.getMessage());
        }
        usr.setPassword(pwd);

        if (errors.isEmpty()) {
            result = "Connected";
        } else {
            result = "Error";
        }

        return usr;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public String getResult() {
        return result;
    }

    private void checkName(String name) throws Exception {
        UserDAO udao = new UserDAO();
        if (name == null) {
            throw new Exception("Please type your username.");
        }
        if (udao.findByName(name) == null) {
            throw new Exception("Wrong username or password.");
        }
    }

    private void checkPwd(String name, String pwd) throws Exception {
        UserDAO udao = new UserDAO();
        if (pwd == null) {
            throw new Exception("Please type your password.");
        }
        udao.isPwdRight(name, pwd);
    }
    
    private void setError(String field, String message) {
        errors.put(field, message);
    }

}
