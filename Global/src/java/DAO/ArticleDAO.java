package DAO;

import beans.Article;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author June
 */
public class ArticleDAO implements DAO<Article> {

    public List<Article> adao = new ArrayList<>();

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
    public void create(Article a) {
        try {
            String req = "INSERT INTO article (title, content) VALUES  (?,?)";
            PreparedStatement pstmt = CONNEXION.prepareStatement(req);
            pstmt.setString(1, a.getTitre());
            pstmt.setString(2, a.getContenu());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            String req = "DELETE FROM article WHERE id = ?";
            PreparedStatement pstmt = CONNEXION.prepareStatement(req);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Article a) {
        try {
            String req = "UPDATE article SET title = ?, content = ? WHERE id = ?";
            PreparedStatement pstmt = CONNEXION.prepareStatement(req);
            pstmt.setString(1, a.getTitre());
            pstmt.setString(2, a.getContenu());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Article> getAll() {
        try {
            String req = "SELECT * FROM article";
            PreparedStatement pstmt = CONNEXION.prepareStatement(req);
            ResultSet resSetArticle = pstmt.executeQuery(req);
            while (resSetArticle.next()) {
                adao.add(new Article(resSetArticle.getInt("id"), resSetArticle.getString("title"), resSetArticle.getString("content"), resSetArticle.getInt("score")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return adao;
    }
}
