package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ************************************************
 * @author June
 *************************************************
 */
public class SQLConnection {

    private static final String host = "127.0.0.1";
    private static final String port = "3306";
    private static final String base = "ohmyblog";
    private static final String login = "ohmyblog";
    private static final String password = "1234512345";
    private static final String url = "jdbc:mysql://" + host + ":" + port + "/" + base;
    private static Connection c;

    private SQLConnection() {
        // Did you expect a needle?
    }

    public static Connection getInstance() {
        if (c == null) {
            try {
                c = DriverManager.getConnection(url, login, password);
            } catch (SQLException ex) {
                Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Connecté à la base de données " + base + " avec l'URL " + url);
        return c;
    }

    public static String getPassword() {
        return password;
    }
   
}
