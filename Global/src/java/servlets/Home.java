package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author June
 */
@WebServlet(name = "Home")
public class Home extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        beans.Article article = new beans.Article();
        article.setId(3);
        article.setTitre("Coucou");
        article.setContenu("Contenu");
        article.setScore(5);

        request.setAttribute("article1", article);

        beans.Article article2 = new beans.Article();
        article2.setId(4);
        article2.setTitre("Corona Vie Russe");
        article2.setContenu("Le Corona vie Russe est un petit Mamifère d'Asie.");
        article2.setScore(3);

        request.setAttribute("article2", article2);

        beans.Article article3 = new beans.Article();
        article3.setId(5);
        article3.setTitre("La 9eme planète");
        article3.setContenu("Un cailloux qui orbite autour du Soleil a été déclaré 9 eme planètes de notre Système Solaire");
        article3.setScore(4);

        request.setAttribute("article3", article3);

        this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
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
