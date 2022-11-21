package web;

//import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import beans.User;
import dao.FiliereImpl;
import dao.IFiliere;
import dao.IModule;
import dao.IProfessor;
import dao.IUser;
import dao.ImplProfessor;
import dao.ModuleImpl;
import dao.UserImpl;

/**
 * Servlet implementation class ServletUser
 */
@WebServlet(urlPatterns = {"/ajouterUser","/listeUser","/listeAjouterUser","/supprimerUser","/editUser","/updateUser","/afficherUser","/Home","/connexionUser","/logout"})
public class ServletUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUser uMetier = new UserImpl();
	private IFiliere fMetier = new FiliereImpl();
	private IModule mMetier = new ModuleImpl();
	private IProfessor pMetier = new ImplProfessor();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUser() {
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
		HttpSession session =request.getSession();
		PrintWriter out;
		if(request.getServletPath()!=null) {
			if(request.getServletPath().equals("/ajouterUser")){	
				try {
				User user = new User();
				
				ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
				List<FileItem> fi= sf.parseRequest(request);
				
				
				String nomU = fi.get(0).getString();
				String prenomU = fi.get(1).getString();
				String natureUser = fi.get(4).getString();
				
				String emailU = fi.get(2).getString();
				String mdpU = fi.get(3).getString();
		
				
				
				byte[] my_byte_array = IOUtils.toByteArray(fi.get(5).getInputStream());
				Blob blob = new SerialBlob(my_byte_array);
				
				user.setImage(blob);
				//System.out.println(fi.get(0).getString());
				//System.out.println(fi);
				
				/*response.setContentType("text/html;charset=UTF-8");
		        out = response.getWriter();
		        Part part = request.getPart("imageU");
		        
		        if (part != null) {
		        	InputStream is = part.getInputStream();
		        	user.setImage((Blob) is);
		        }*/
				user.setNomU(nomU);
				user.setPrenomU(prenomU);
				user.setNatureUser(natureUser);
				user.setEmailU(emailU);
				user.setMdpU(mdpU);
				
				uMetier.ajouterUser(user);
				} catch (FileUploadException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.getServletContext().getRequestDispatcher("/listeUser").forward(request, response);
			}
			
			
			if (request.getServletPath().equals("/listeAjouterUser")) { 
				request.setAttribute("UsersOpen", "open");
				request.setAttribute("AjouterUser", "active");
				this.getServletContext().getRequestDispatcher("/add_user.jsp").forward(request, response);
			}
			
			
			if (request.getServletPath().equals("/listeUser")) { 
				request.setAttribute("UsersOpen", "open");
				request.setAttribute("AllUsers", "active");
				request.setAttribute("User", uMetier.listeUser());
				this.getServletContext().getRequestDispatcher("/all_users.jsp").forward(request, response);
			}
			
			
			if (request.getServletPath().equals("/supprimerUser")) {
				int numU = Integer.parseInt(request.getParameter("idUser"));
				if (numU !=1)
					uMetier.supprimerUser(numU);
				else if(numU == 1)
					request.setAttribute("msg", "Impossible de supprimer l'admin principal !!");
				
				this.getServletContext().getRequestDispatcher("/listeUser").forward(request, response);
			}
			
			
			if(request.getServletPath().equals("/editUser")) {
				int numU = Integer.parseInt(request.getParameter("id"));
				request.setAttribute("User", uMetier.chercherUser(numU));
				this.getServletContext().getRequestDispatcher("/edit_user.jsp").forward(request, response);
			}
			
			if(request.getServletPath().equals("/updateUser")) {
				
				try {
					ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
					List<FileItem> fi= sf.parseRequest(request);
					String id = fi.get(0).getString();
					User user = uMetier.chercherUser(Integer.parseInt(id));
					String nomU = fi.get(1).getString();
					String prenomU = fi.get(2).getString();
					String natureUser = fi.get(5).getString();
					
					String emailU = fi.get(3).getString();
					String mdpU = fi.get(4).getString();
					
					user.setNomU(nomU);
					user.setPrenomU(prenomU);
					user.setNatureUser(natureUser);
					user.setEmailU(emailU);
					user.setMdpU(mdpU);
					
					
					
					if (fi.get(6).getSize() != 0) {
						byte[] my_byte_array = IOUtils.toByteArray(fi.get(6).getInputStream());
						Blob blob = new SerialBlob(my_byte_array);
						user.setImage(blob);
					}
					else {
						System.out.println(user.getImageU());
						user.setImage(user.getImageU());
					}
					
					uMetier.modifierUser(user);
				} catch (FileUploadException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.getServletContext().getRequestDispatcher("/listeUser").forward(request, response);
			}
			
			
			if (request.getServletPath().equals("/afficherUser")) {
				int idUser = Integer.parseInt(request.getParameter("idUser"));
				request.setAttribute("idUser", uMetier.chercherUser(idUser));
				this.getServletContext().getRequestDispatcher("/user_profile.jsp").forward(request, response);
				
			}
			
			
			if (request.getServletPath().equals("/Home")) {
				request.setAttribute("User", uMetier.listeUser());
				request.setAttribute("Home", "active");
				this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				
			}
			
			
			if (request.getServletPath().equals("/connexionUser")) {
				String emailU = request.getParameter("emailU");
				String mdpU = request.getParameter("mdpU");
				if(uMetier.login(emailU, mdpU)){
					User u = uMetier.getUser(emailU, mdpU);
					String nature=u.getNatureUser();
					nature=nature.trim();
					System.out.println(nature);
					String tab[]=nature.split(" ");
					String tabNV=tab[0];
					for(int i=1; i<tab.length;i++) {
						tabNV+=tab[i];
					}
					System.out.println(tabNV);
					session.setAttribute("NomUser", u.getNomU());
					session.setAttribute("PrenomUser", u.getPrenomU());
					session.setAttribute("natureU",u.getNatureUser());
					session.setAttribute("natureUNV",tabNV);
					session.setAttribute("idUser",u.getIdUser());
					session.setAttribute("photo",u.getEncodedPhoto());
					session.setAttribute("nbreFilieres", fMetier.getNbreFilieres());
					session.setAttribute("nbreProfesseurs", pMetier.getNbreProfesseurs());
					session.setAttribute("nbreUsers", uMetier.getNbreUsers());
					session.setAttribute("nbreModules", mMetier.getNbreModules());
					request.setAttribute("User", uMetier.listeUser());
					//System.out.println(u.getNatureUser());
					
					request.getRequestDispatcher("/index.jsp").forward(request, response); 		    	 
				}
				else {
					session.setAttribute("user", null);
					int testA = 1 ; 
					String erreurA = "Connexion échouée <br / > Mauvaise combinaison Email/Mot de passe !";
					session.setAttribute("testA", testA);
					session.setAttribute("eA", erreurA);
					System.out.println(erreurA);
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					
				}
			}
			if(request.getServletPath().equals("/logout")) {
				System.out.println(00);
				session.invalidate();
				System.out.println(99);
				response.sendRedirect("login.jsp");
			
		}
		}
	}

}
