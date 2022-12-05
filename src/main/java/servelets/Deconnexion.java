package servelets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//public class Deconnexion extends HttpServlet {
//    public static final String URL_REDIRECTION = "http://www.zestedesavoir.com";
//
//    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
//        /* Récupération et destruction de la session en cours */
//        HttpSession session = request.getSession();
//        session.invalidate();
//
//        /* Redirection vers le Site du Zéro ! */
//        response.sendRedirect( URL_REDIRECTION );
//    }
//}

public class Deconnexion extends HttpServlet {
    public static final String VUE = "/connexion";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Récupération et destruction de la session en cours */
        HttpSession session = request.getSession();
        session.invalidate();

        /* Affichage de la page de connexion */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}