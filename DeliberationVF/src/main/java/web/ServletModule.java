package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FiliereImpl;
import dao.IFiliere;
import dao.IModule;
import dao.ISemestre;
import dao.IUser;
import dao.ImplSemestre;
import dao.ModuleImpl;
import dao.UserImpl;
import beans.Filiere;
import beans.Module;
/**
 * Servlet implementation class ServletModule
 */
@WebServlet(urlPatterns = {"/listeSemestreParFil","/listeAjouterModule","/ajouterModule","/listeModules","/supprimerModule","/updateModule","/editModule"})
public class ServletModule extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IModule mMetier = new ModuleImpl();
	private ISemestre sMetier = new ImplSemestre();
	private IFiliere fMetier = new FiliereImpl();
	private IUser uMetier = new UserImpl();
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModule() {
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
			if(request.getServletPath().equals("/listeSemestreParFil")){
				request.setAttribute("filiere", fMetier.listeFiliere());
				request.setAttribute("RespoM", uMetier.listeUserRespoM());
				request.setAttribute("ModulesOpen", "open");
				request.setAttribute("AjouterModule", "active");
				request.setAttribute("semestre", sMetier.listeSemestreParFil(request.getParameter("fil")));
				this.getServletContext().getRequestDispatcher("/add_module.jsp").forward(request, response);
			}
			if(request.getServletPath().equals("/listeAjouterModule")){
				request.setAttribute("filiere", fMetier.listeFiliere());
				request.setAttribute("RespoM", uMetier.listeUserRespoM());
				request.setAttribute("ModulesOpen", "open");
				request.setAttribute("AjouterModule", "active");
				this.getServletContext().getRequestDispatcher("/add_module.jsp").forward(request, response);
			}
			if(request.getServletPath().equals("/ajouterModule")){	
				Module mod = new Module();
				String nomM = request.getParameter("LebelleModule");
				String semestre= request.getParameter("semestre");
				String filiere=request.getParameter("filiere");
				System.out.println(1);
				int idSemestre=sMetier.chercherSemestreParNom(semestre);
                System.out.println(idSemestre);
				mod.setIdSemestre(idSemestre);
				
				System.out.println(2);
				mod.setLebelleModule(nomM);
				mod.setFiliere(filiere);
				
				System.out.println(3);
				
				mMetier.ajouterModule(mod);
				System.out.println(4);
				this.getServletContext().getRequestDispatcher("/listeModules").forward(request, response);
			}
			if(request.getServletPath().equals("/listeModules")){	
				request.setAttribute("Modules", mMetier.listeModule());
				request.setAttribute("ModulesOpen", "open");
				request.setAttribute("AllModules", "active");
				this.getServletContext().getRequestDispatcher("/all_modules.jsp").forward(request, response);
			}
			if (request.getServletPath().equals("/supprimerModule")) {
				int numU = Integer.parseInt(request.getParameter("idModule"));
				mMetier.supprimerModule(numU);
				this.getServletContext().getRequestDispatcher("/listeModules").forward(request, response);
			}
			if(request.getServletPath().equals("/editModule")) {
				int numU = Integer.parseInt(request.getParameter("id"));
				request.setAttribute("Module", mMetier.chercherModule(numU));
				this.getServletContext().getRequestDispatcher("/edit_module.jsp").forward(request, response);
			}
			
			if(request.getServletPath().equals("/updateModule")) {
				
				String id =request.getParameter("id");
				System.out.println(id);
				Module user = mMetier.chercherModule(Integer.parseInt(id));
				String nomM = request.getParameter("LebelleModule");
				String semestre= request.getParameter("semestre");
				String filiere=request.getParameter("filiere");
				System.out.println(1);
				int idSemestre=sMetier.chercherSemestreParNom(semestre);
                System.out.println(idSemestre);
				user.setIdSemestre(idSemestre);
				
				System.out.println(2);
				user.setLebelleModule(nomM);
				user.setFiliere(filiere);
				
				System.out.println(3);
				mMetier.modifierModule(user);
				
				this.getServletContext().getRequestDispatcher("/listeModules").forward(request, response);
			}
			
		}
	}

}
