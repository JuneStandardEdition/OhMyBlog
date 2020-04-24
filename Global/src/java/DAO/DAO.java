package DAO;

import connections.SQLConnection;
import java.sql.Connection;
import java.util.List;

/**
 * ************************************************
 * @author June
 *************************************************
 */
public interface DAO<T> {

    // Const connexion
    Connection CONNEXION = SQLConnection.getInstance();

    T find(Integer id);

    void create(T T);

    void delete(Integer id);

    void update(T T);
    
    List<T> getAll();

}