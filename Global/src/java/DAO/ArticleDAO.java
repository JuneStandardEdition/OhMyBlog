package DAO;

import beans.Article;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author June
 */
public class ArticleDAO implements DAO<Article> {

    @Override
    public Article find(Integer id) {
        Article atl = null;
        try {
            String req = "SELECT * FROM article WHERE id = ?";
            PreparedStatement pstmt = CONNEXION.prepareStatement(req);
            pstmt.setInt(1, id);
            ResultSet res = pstmt.executeQuery();
            if (res.first()) {
                atl = new Article(res.getInt("id"), res.getString("title"), res.getString("content"), res.getInt("score"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return atl;
    }

    @Override
    public void create(Article T) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Article T) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Article> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
