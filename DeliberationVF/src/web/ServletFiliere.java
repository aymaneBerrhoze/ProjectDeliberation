package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Filiere;
import dao.IFiliere;
import dao.IUser;
import dao.UserImpl;
import dao.FiliereImpl;

/**
 * Servlet implementation class ServletFiliere
 */
@WebServlet(urlPatterns = {"/ListRespoFil","/ajouterFiliere","/listeFiliere","/supprimerFiliere","/editFiliere","/updateFiliere"})
public class ServletFiliere extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IFiliere uMetier = new FiliereImpl();
	private IUser userMetier = new UserImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFiliere() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getServletPath()!=null) {
			if(request.getServletPath().equals("/ListRespoFil")){	 
	    	    request.setAttribute("RespoF", userMetier.listeUserRespoF());
	    	    request.setAttribute("FilieresOpen", "open");
				request.setAttribute("AjouterFiliere", "active");
	    	    this.getServletContext().getRequestDispatcher("/add_department.jsp").forward(request, response);
			}
			if(request.getServletPath().equals("/ajouterFiliere")){	
				Filiere user = new Filiere();
				String nomF = request.getParameter("NomFiliere");
				String respoF = request.getParameter("responsablefiliere");
				
				user.setNomFiliere(nomF);
				user.setResponsablefiliere(respoF);
				
				uMetier.ajouterFiliere(user);
				
				this.getServletContext().getRequestDispatcher("/listeFiliere").forward(request, response);
			}
			if (request.getServletPath().equals("/listeFiliere")) { 
				System.out.println(4);
				request.setAttribute("Filiere", uMetier.listeFiliere());
				request.setAttribute("FilieresOpen", "open");
				request.setAttribute("AllFilieres", "active");
				this.getServletContext().getRequestDispatcher("/all_department.jsp").forward(request, response);
			}
			if (request.getServletPath().equals("/supprimerFiliere")) {
				int numU = Integer.parseInt(request.getParameter("idFiliere"));
				uMetier.supprimerFiliere(numU);
				this.getServletContext().getRequestDispatcher("/listeFiliere").forward(request, response);
			}
			if(request.getServletPath().equals("/editFiliere")) {
				int numU = Integer.parseInt(request.getParameter("id"));
				request.setAttribute("RespoF", userMetier.listeUserRespoF());
				request.setAttribute("Filiere", uMetier.chercherFiliere(numU));
				this.getServletContext().getRequestDispatcher("/edit_department.jsp").forward(request, response);
			}
			
			if(request.getServletPath().equals("/updateFiliere")) {
				
				String id =request.getParameter("id");
				System.out.println(id);
				Filiere user = uMetier.chercherFiliere(Integer.parseInt(id));
				String nomF = request.getParameter("NomFiliere");
				String respoF = request.getParameter("responsablefiliere");
				
				user.setNomFiliere(nomF);
				user.setResponsablefiliere(respoF);
				
				uMetier.modifierFiliere(user);
				
				this.getServletContext().getRequestDispatcher("/listeFiliere").forward(request, response);
			}
		}
	}

}
