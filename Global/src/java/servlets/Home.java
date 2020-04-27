package servlets;

import DAO.ArticleDAO;
import beans.Article;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author June
 */
public class Home extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*Article article = new Article();
        article.setId(3);
        article.setTitle("Coucou");
        article.setContent("Contenu");
        article.setScore(5);

        request.setAttribute("article1", article);

        Article article2 = new Article();
        article2.setId(4);
        article2.setTitle("Corona Vie Russe");
        article2.setContent("Le Corona vie Russe est un petit Mammifère d'Asie.");
        article2.setScore(3);

        request.setAttribute("article2", article2);

        Article article3 = new Article();
        article3.setId(5);
        article3.setTitle("La 9eme planète");
        article3.setContent("Un caillou qui orbite autour du Soleil a été déclaré 9e planète de notre Système Solaire");
        article3.setScore(4);

        request.setAttribute("article3", article3);*/

        ArticleDAO adao = new ArticleDAO();
        List<Article> allofem = new ArrayList<>();
        allofem = adao.getAll();
        if (!allofem.isEmpty()) {
            Collections.reverse(allofem);
        }
        request.setAttribute("articles", allofem);
        this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
