package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Module;
import beans.Professeur;

public class ImplProfessor implements IProfessor {

	@Override
	public void ajouterProfesseur(Professeur p) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into professeur(NomProf,PrenomProf,emailP,departement_dattache,discipline,etablissement,module_enseigne,mdpP,telP) values(?,?,?,?,?,?,?,?,?)");
				
			ps.setString(1,p.getNomProf());
			ps.setString(2, p.getPrenomProf());
			ps.setString(3, p.getEmailP());
			ps.setString(4, p.getDepartement_dattache());
			ps.setString(5, p.getDiscipline());
			ps.setString(6, p.getEtablissement());
			ps.setString(7, p.getModule_enseigne());
			ps.setString(8, p.getMdpP());
			ps.setString(9, p.getTelP());

			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	
	}

	@Override
	public List<Professeur> listeProfesseur() {
		List<Professeur> professeurs = new ArrayList<Professeur>();
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * from professeur ;");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Professeur p = new Professeur();
				p.setIdProfesseur(rs.getInt("idProfesseur"));
		        p.setNomProf(rs.getString("NomProf"));
        		p.setPrenomProf(rs.getString("PrenomProf"));
				p.setDiscipline(rs.getString("discipline"));
				p.setEtablissement(rs.getString("etablissement"));
				p.setDepartement_dattache(rs.getString("departement_dattache"));
				p.setModule_enseigne(rs.getString("module_enseigne"));
				p.setEmailP(rs.getString("emailP"));
				p.setMdpP(rs.getString("mdpP"));
				p.setTelP(rs.getString("telP"));
				professeurs.add(p);	
			}
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return professeurs;
	}

	@Override
	public Professeur chercherProfesseur(int idProfesseur) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		Professeur p = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * from professeur WHERE idProfesseur=? ;");
			ps.setInt(1, idProfesseur);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				p= new Professeur();
				p.setIdProfesseur(rs.getInt("idProfesseur"));
		        p.setNomProf(rs.getString("NomProf"));
        		p.setPrenomProf(rs.getString("PrenomProf"));
				p.setDiscipline(rs.getString("discipline"));
				p.setEtablissement(rs.getString("etablissement"));
				p.setDepartement_dattache(rs.getString("departement_dattache"));
				p.setModule_enseigne(rs.getString("module_enseigne"));
				p.setEmailP(rs.getString("emailP"));
				p.setMdpP(rs.getString("mdpP"));
				p.setTelP(rs.getString("telP"));
			
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(p==null)throw new RuntimeException("User "+idProfesseur+" inexistant");
		
	return p;	
	}

	@Override
	public void modifierProfesseur(Professeur p) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		System.out.println("update function");
		try {
			PreparedStatement ps = conn.prepareStatement("update professeur set "
					+ "NomProf=? ,PrenomProf=?,discipline=?,etablissement=?,departement_dattache=?,module_enseigne=?,emailP=?,mdpP=?,telP=?"
					+ "where idProfesseur=?");
			
			
			ps.setString(1,p.getNomProf());
			ps.setString(2, p.getPrenomProf());
			ps.setString(7, p.getEmailP());
			ps.setString(5, p.getDepartement_dattache());
			ps.setString(3, p.getDiscipline());
			ps.setString(4, p.getEtablissement());
			ps.setString(6, p.getModule_enseigne());
			ps.setString(8, p.getMdpP());
			ps.setString(9, p.getTelP());
			ps.setInt(10, p.getIdProfesseur());
			
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}

	@Override
	public void supprimerProfesseur(int idProfesseur) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		System.out.println("delete function");
		System.out.println("idProfesseur: " + idProfesseur);
			
			try {
				PreparedStatement ps = conn.prepareStatement("delete from professeur where idProfesseur=?");
				
				ps.setInt(1,idProfesseur);
				
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
	}

	@Override
	public Professeur getProfessor(String login, String pwd) {
		Connection connection= DAOFACTORY.getConnection();
		Professeur p  = new Professeur();
		try {
			PreparedStatement ps = connection.prepareStatement 
					("SELECT *  FROM professeur  WHERE emailP=? and mdpP=?");	
			ps.setString(1, login);
			ps.setString(2, pwd);
            ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				p.setIdProfesseur(rs.getInt("idProfesseur"));
		        p.setNomProf(rs.getString("NomProf"));
        		p.setPrenomProf(rs.getString("PrenomProf"));
				p.setDiscipline(rs.getString("discipline"));
				p.setEtablissement(rs.getString("etablissement"));
				p.setDepartement_dattache(rs.getString("departement_dattache"));
				p.setModule_enseigne(rs.getString("module_enseigne"));
				p.setEmailP(rs.getString("emailP"));
				p.setMdpP(rs.getString("mdpP"));
				p.setMdpP(pwd);		
			}			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public boolean login(String login, String pwd) {
		boolean a=false;		
		System.out.println(login +" "+ pwd);
		Connection connection = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps  = connection.prepareStatement("SELECT mdpP FROM professeur WHERE emailP=? ");
			ps.setString(1, login);
			ResultSet rs = ps.executeQuery();
			if(rs.next() && (rs.getString("mdpP")).equals(pwd) ){
				a=true;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public List<Module> listeProfesseurParModule(String Fil) {
		// TODO Auto-generated method stub
		List<Module> professeurs = new ArrayList<Module>();
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * from module where filiere=? ;");
			ps.setString(1, Fil);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Module p = new Module();
				p.setIdModule(rs.getInt("idModule"));
		        p.setLebelleModule(rs.getString("LebelleModule"));
		        p.setFiliere(rs.getString("filiere"));
				professeurs.add(p);
			}
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return professeurs;
	}

	@Override
	public int getModuleParNom(String nom) {
		// TODO Auto-generated method stub
		Connection con = DAOFACTORY.getConnection();
		int id=-1;
		try {
			PreparedStatement ps = con.prepareStatement("SELECT idModule FROM module WHERE LebelleModule= ?");
			
			ps.setString(1, nom);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt("idModule");
				return id;
			}
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return id ;
	}
	
	@Override
	public Professeur getProfessorParNom(String nom) {
		Connection connection= DAOFACTORY.getConnection();
		Professeur p  = new Professeur();
		try {
			PreparedStatement ps = connection.prepareStatement 
					("SELECT *  FROM professeur  WHERE NomProf=?");	
			ps.setString(1, nom);
            ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				p.setIdProfesseur(rs.getInt("idProfesseur"));
		        p.setNomProf(rs.getString("NomProf"));
        		p.setPrenomProf(rs.getString("PrenomProf"));
				p.setDiscipline(rs.getString("discipline"));
				p.setEtablissement(rs.getString("etablissement"));
				p.setDepartement_dattache(rs.getString("departement_dattache"));
				p.setModule_enseigne(rs.getString("module_enseigne"));
				p.setEmailP(rs.getString("emailP"));
				p.setMdpP(rs.getString("mdpP"));
			}			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public int getNbreProfesseurs() {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		int n = 0 ;
		try {
			PreparedStatement ps=conn.prepareStatement("SELECT count(idProfesseur) from professeur; "); 
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				n = res.getInt("count(idProfesseur)");
			}ps.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}
	    	
			return n ;
	}

}
