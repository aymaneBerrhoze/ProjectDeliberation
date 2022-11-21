package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import beans.Professeur;
import beans.User;
import dao.FiliereImpl;
import dao.IFiliere;
import dao.IProfessor;
import dao.ImplProfessor;
import dao.ModuleImpl;

/**
 * Servlet implementation class ServletProfessor
 */
@WebServlet(urlPatterns = {"/ModulelistParFil1","/AjouterProfList","/ModulelistParFil","/ajouterProfesseur","/listeProfesseur","/supprimerProfesseur","/editProfesseur","/updateProfesseur","/fetchProf"})
public class ServletProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IProfessor pMetier = new ImplProfessor();
	private IFiliere fMetier = new FiliereImpl();
	private dao.IModule mMetier = new ModuleImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProfessor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
if(request.getServletPath()!=null) {
	       if(request.getServletPath().equals("/ModulelistParFil")){	 
	    	    request.setAttribute("Departement", fMetier.listeFiliere());
	    	    request.setAttribute("Professeur", pMetier.listeProfesseur());
	    	    request.setAttribute("Module", pMetier.listeProfesseurParModule(request.getParameter("fil")));
	    	    request.setAttribute("filiere", request.getParameter("fil") );
				this.getServletContext().getRequestDispatcher("/add_professor.jsp").forward(request, response);
	}
	       if(request.getServletPath().equals("/ModulelistParFil1")){
	    	   System.out.println("hallo");
	    	    String id = request.getParameter("id");
	    	    System.out.println(id);
	    	    request.setAttribute("id", id);
	    	    request.setAttribute("Departement", fMetier.listeFiliere());
	    	    request.setAttribute("Professeur", pMetier.listeProfesseur());
	    	    request.setAttribute("Module", pMetier.listeProfesseurParModule(request.getParameter("fil")));
	    	    request.setAttribute("filiere", request.getParameter("fil") );
	    	    System.out.println("edit 2   "+ request.getParameter("fil"));
				this.getServletContext().getRequestDispatcher("/edit_professor.jsp").forward(request, response);
	}
	       if(request.getServletPath().equals("/AjouterProfList")){	 
	    	    request.setAttribute("Departement", fMetier.listeFiliere());
	    	    request.setAttribute("Professeur", pMetier.listeProfesseur());
	    	    request.setAttribute("Module", mMetier.listeModule());
	    	    request.setAttribute("filiere", request.getParameter("fil") );
	    	    request.setAttribute("ProfessorsOpen", "open");
				request.setAttribute("AjouterProfessor", "active");
				this.getServletContext().getRequestDispatcher("/add_professor.jsp").forward(request, response);
	}
			// Ajouter une categorie :
			if(request.getServletPath().equals("/ajouterProfesseur")){	 
					System.out.println(3);
					Professeur user = new Professeur();
					
					String NomProf = request.getParameter("NomProf");
					String PrenomProf = request.getParameter("PrenomProf");
					String emailP =request.getParameter("emailP");
					String discipline = request.getParameter("discipline");
					String mdpP =request.getParameter("mdpP");
					
					request.setAttribute("Departement", fMetier.listeFiliere());
		    	    request.setAttribute("Professeur", pMetier.listeProfesseur());
		    	    request.setAttribute("Module", mMetier.listeModule());
					
					int idModule = pMetier.getModuleParNom(request.getParameter("module_enseigne"));
					System.out.println(request.getParameter("module_enseigne"));
					user.setDepartement_dattache(mMetier.chercherModule(idModule).getFiliere());
					System.out.println(mMetier.chercherModule(idModule).getFiliere());
					
					String module_enseigne = request.getParameter("module_enseigne");
					String telP = request.getParameter("telP");
					
					user.setNomProf(NomProf);
					user.setPrenomProf(PrenomProf);
					user.setEmailP(emailP);
					user.setDiscipline(discipline);
					user.setMdpP(mdpP);
					user.setModule_enseigne(module_enseigne);
					user.setTelP(telP);
					
					
					pMetier.ajouterProfesseur(user);
					System.out.println(11);
					this.getServletContext().getRequestDispatcher("/listeProfesseur").forward(request, response);
				}
			// Lister les categories
					if (request.getServletPath().equals("/listeProfesseur")) { 
						System.out.println(4);
						request.setAttribute("ProfessorsOpen", "open");
						request.setAttribute("AllProfessors", "active");
						request.setAttribute("Professeur", pMetier.listeProfesseur());
						this.getServletContext().getRequestDispatcher("/all_professors.jsp").forward(request, response);
					}
					
			//Supprimer une categorie
					if (request.getServletPath().equals("/supprimerProfesseur")) {
						int numU = Integer.parseInt(request.getParameter("idProfesseur"));
						pMetier.supprimerProfesseur(numU);
						this.getServletContext().getRequestDispatcher("/listeProfesseur").forward(request, response);
					}
					
					if(request.getServletPath().equals("/editProfesseur")) {
						
						int numF = Integer.parseInt(request.getParameter("id"));
						String filiere=request.getParameter("filiere");
						request.setAttribute("Professeur", pMetier.chercherProfesseur(numF));
						request.setAttribute("Departement", fMetier.listeFiliere());
				    	request.setAttribute("Module", mMetier.listeModule());
				    	request.setAttribute("filiere", filiere);
				    	System.out.println("edit 1   "+ filiere);
						this.getServletContext().getRequestDispatcher("/edit_professor.jsp").forward(request, response);
					}
					 //Editer une categorie
					if(request.getServletPath().equals("/updateProfesseur")) {
					
						String id =request.getParameter("id");
						Professeur user = pMetier.chercherProfesseur(Integer.parseInt(id));
						
						String NomProf = request.getParameter("NomProf");
						String PrenomProf = request.getParameter("PrenomProf");
						String emailP =request.getParameter("emailP");
						String discipline = request.getParameter("discipline");
						String mdpP =request.getParameter("mdpP");
						
						request.setAttribute("Departement", fMetier.listeFiliere());
			    	    request.setAttribute("Professeur", pMetier.listeProfesseur());
			    	    request.setAttribute("Module", mMetier.listeModule());
						
			    	    int idModule = pMetier.getModuleParNom(request.getParameter("module_enseigne"));
						System.out.println(request.getParameter("module_enseigne"));
						user.setDepartement_dattache(mMetier.chercherModule(idModule).getFiliere());
						System.out.println(mMetier.chercherModule(idModule).getFiliere());
			    	    
						String module_enseigne = request.getParameter("module_enseigne");
						String telP = request.getParameter("telP");
						
						
						
						user.setNomProf(NomProf);
						user.setPrenomProf(PrenomProf);
						user.setDiscipline(discipline);
						user.setModule_enseigne(module_enseigne);
						user.setEmailP(emailP);
						user.setMdpP(mdpP);
						user.setTelP(telP);
						
						pMetier.modifierProfesseur(user);
						
						this.getServletContext().getRequestDispatcher("/listeProfesseur").forward(request, response);
					}
					
					//fetch prof data if exists
					if(request.getServletPath().equals("/fetchProf")){	 
						System.out.println(3);
					
						String NomProf = request.getParameter("nomU");
						
						Professeur prof = pMetier.getProfessorParNom(NomProf);
						String nomP= prof.getNomProf();
						String PrenomProf = prof.getPrenomProf();
						String emailP = prof.getEmailP();
						String mdpP = prof.getMdpP();
						
						request.setAttribute("Departement", fMetier.listeFiliere());
			    	    request.setAttribute("Professeur", pMetier.listeProfesseur());
			    	    request.setAttribute("Module", mMetier.listeModule());
			    	    
						User user = new User();
						user.setNomU(nomP);
						user.setPrenomU(PrenomProf);
						user.setEmailU(emailP);
						user.setMdpU(mdpP);
						
						System.out.println(user.toString());
						if(nomP != null)
							request.setAttribute("user", user);
						else
							request.setAttribute("err", "L'Utilisateur n'existe pas dans la base de données");
					
						this.getServletContext().getRequestDispatcher("/add_user.jsp").forward(request, response);
					}
}
	}

}
