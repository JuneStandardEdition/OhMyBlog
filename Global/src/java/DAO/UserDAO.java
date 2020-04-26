package DAO;

import beans.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author June
 */
public class UserDAO implements DAO<User> {

    @Override
    public User find(Integer id) {
        User usr = null;
        try {
            String req = "SELECT * FROM user WHERE id = ?";
            PreparedStatement pstmt = CONNEXION.prepareStatement(req);
            pstmt.setInt(1, id);
            ResultSet result = pstmt.executeQuery();
            if (result.first()) {
                usr = new User(result.getString("name"), result.getString("email"), result.getString("password"), result.getBoolean("isAdmin"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usr;
    }

    @Override
    public void create(User u) {
        try {
            String req = "INSERT INTO user (name, email, password) VALUES (?,?,?)";
            PreparedStatement pstmt = CONNEXION.prepareStatement(req);
            pstmt.setString(1, u.getName());
            pstmt.setString(2, u.getEmail());
            pstmt.setString(3, u.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            String req = "DELETE FROM user WHERE id = ?";
            PreparedStatement pstmt = CONNEXION.prepareStatement(req);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(User u) {
        try {
            String req = "UPDATE user SET name = ?, email = ?, password = ?, isAdmin = ? WHERE id = ?";
            PreparedStatement pstmt = CONNEXION.prepareStatement(req);
            pstmt.setString(1, u.getName());
            pstmt.setString(2, u.getEmail());
            pstmt.setString(3, u.getPassword());
            pstmt.setBoolean(4, u.isIsAdmin());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<User> getAll() {
        List<User> udao = new ArrayList<>();
        String sqlQuery = "SELECT * FROM user";
        try (Statement stmt = CONNEXION.createStatement()) {
            ResultSet resSetUser = stmt.executeQuery(sqlQuery);
            while (resSetUser.next()) {
                udao.add(new User(resSetUser.getString("name"), resSetUser.getString("email"), resSetUser.getString("password"), resSetUser.getBoolean("isAdmin")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return udao;
    }

    /* Finds an User object if the given name matches with one of the Users name
       Returns usr = null otherwise */
    public User findByName(String name) {
        User usr = null;
        try {
            String req = "SELECT * FROM user WHERE name = ?";
            PreparedStatement pstmt = CONNEXION.prepareStatement(req);
            pstmt.setString(1, name);
            ResultSet res = pstmt.executeQuery();
            if (res.first()) {
                usr = new User(res.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usr;
    }

    public boolean isPwdRight(String name, String pwd) {
        boolean b = false;
        try {
            String req = "SELECT * FROM user WHERE name = ?";
            PreparedStatement pstmt = CONNEXION.prepareStatement(req);
            pstmt.setString(1, name);
            ResultSet res = pstmt.executeQuery();
            if (res.first() && res.getString("password").matches(pwd)) {
                b = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }

    public boolean isUserAdmin(String name) {
        boolean b = false;
        try {
            String req = "SELECT * FROM user WHERE name = ?";
            PreparedStatement pstmt = CONNEXION.prepareStatement(req);
            pstmt.setString(1, name);
            ResultSet res = pstmt.executeQuery();
            if (res.first()) {
                b = res.getBoolean("isAdmin");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }

}
