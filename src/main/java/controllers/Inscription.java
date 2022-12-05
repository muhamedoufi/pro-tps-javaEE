package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Operations;
import models.Person;
import models.PersonBeans;

import java.io.IOException;
import java.io.PrintWriter;


/**
 * Servlet implementation class Inscription
 */
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Operations op;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	
    	op = new Operations();
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String address = request.getParameter("address");
		String mot_de_pass = request.getParameter("mot_de_pass");
		String confirm_mot_de_pass = request.getParameter("confirm_mot_de_pass");
		
//		if(request.getParameter("action") != null) {
//			op.remove(int.parseInt(request.getParameter("id")));
//		}else {
			
			if(mot_de_pass.equals( confirm_mot_de_pass)) {
				Person p = new Person(1,nom,address,mot_de_pass);
				
				PersonBeans pb = new PersonBeans();
				op.add(p);
				pb.setListe(op.gettAll());
				
				request.setAttribute("model" , pb);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else {
				request.setAttribute("Persons" , "les mots de passe que tu saisie ne sont pas meme");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
//		}
		
		
//		PrintWriter pr = response.getWriter();
//		if(mot_de_pass==confirm_mot_de_pass) {
//			pr.println("nom :"+nom+" | address :"+address);
//		}else {
//			pr.println("les mots de passe que tu saisie ne sont pas meme");
//		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
