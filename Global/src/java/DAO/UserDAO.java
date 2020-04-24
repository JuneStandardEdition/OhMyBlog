package DAO;

import beans.User;
import java.util.ArrayList;
import java.util.List;

/**
 * @author June
 */
public class UserDAO implements DAO<User> {

    @Override
    public User find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(User T) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(User T) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        users.add(new User("toto", "toto", "toto", true));
        users.add(new User("tata", "tata", "tata", true));
        return users;
    }
    
    public User findByMail(String email) {
        
        return null;
    }
    
}
