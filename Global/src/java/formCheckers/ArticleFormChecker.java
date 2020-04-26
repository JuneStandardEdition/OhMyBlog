package formCheckers;

import beans.Article;
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
public class ArticleFormChecker {

    private Map<String, String> errors = new HashMap<>();
    private String result; // Global result

    public Article checkForm(HttpServletRequest request) {
        try {
            /* Gathering form fields */
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(RegisterFormChecker.class.getName()).log(Level.SEVERE, null, ex);
        }
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Article atl = new Article();
        atl.setTitle(title);
        atl.setContent(content);

        /* Checks title */
        try {
            titleCheck(title);
        } catch (FormException e) {
            errors.put("title", e.getMessage());
        }

        /* Checks content */
        try {
            contentCheck(content);
        } catch (FormException e) {
            errors.put("content", e.getMessage());
        }

        /* Inits result */
        if (errors.isEmpty()) {
            result = "Creation success.";
        } else {
            result = "Creation failed.";
        }
        return atl;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public String getResult() {
        return result;
    }

    /* Field checkers */
    /**
     * Checks if title is valid or not
     */
    private void titleCheck(String title) throws FormException {
        if (title != null && title.length() < 3) {
            throw new FormException("Title must be 3 characters long at least.");
        }
    }

    /**
     * Checks if content is valid or not
     */
    private void contentCheck(String content) throws FormException {
        if (content != null && content.length() < 10) {
            throw new FormException("Content must be 10 characters long at least.");
        }
    }
}
