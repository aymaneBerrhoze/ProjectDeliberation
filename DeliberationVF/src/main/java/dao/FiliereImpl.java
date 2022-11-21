package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Filiere;

public class FiliereImpl implements IFiliere {

	@Override
	public void ajouterFiliere(Filiere p) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into filiere(NomFiliere,responsablefiliere) values(?,?)");
				
			ps.setString(1,p.getNomFiliere());
			ps.setString(2, p.getResponsablefiliere());
			

			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public List<Filiere> listeFiliere() {
		// TODO Auto-generated method stub
		List<Filiere> filieres = new ArrayList<Filiere>();
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * from filiere ;");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Filiere p = new Filiere();
				p.setIdFiliere(rs.getInt("idFiliere"));
		        p.setNomFiliere(rs.getString("NomFiliere"));
		        p.setResponsablefiliere(rs.getString("responsablefiliere"));
				filieres.add(p);	
			}
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return filieres;
	}

	@Override
	public Filiere chercherFiliere(int idFiliere) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		Filiere p = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * from filiere WHERE idFiliere=? ;");
			ps.setInt(1, idFiliere);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				p= new Filiere();
				p.setIdFiliere(rs.getInt("idFiliere"));
		        p.setNomFiliere(rs.getString("NomFiliere"));
		        p.setResponsablefiliere(rs.getString("responsablefiliere"));
			
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(p==null)throw new RuntimeException("User "+idFiliere+" inexistant");
		
	return p;	
	}

	@Override
	public void modifierFiliere(Filiere p) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		System.out.println("update function");
		try {
			PreparedStatement ps = conn.prepareStatement("update filiere set "
					+ "NomFiliere=?, responsablefiliere=?"
					+ "where idFiliere=?");
			
			
			ps.setString(1,p.getNomFiliere());
			ps.setString(2, p.getResponsablefiliere());
			ps.setInt(3,  p.getIdFiliere());
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}

	@Override
	public void supprimerFiliere(int idFiliere) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		System.out.println("delete function");
		System.out.println("idFiliere: " + idFiliere);
			
			try {
				PreparedStatement ps = conn.prepareStatement("delete from filiere where idFiliere=?");
				
				ps.setInt(1,idFiliere);
				
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
	}

	@Override
	public int getNbreFilieres() {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		int n = 0 ;
		try {
			PreparedStatement ps=conn.prepareStatement("SELECT count(idFiliere) from filiere; "); 
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				n = res.getInt("count(idFiliere)");
			}ps.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}
	    	
			return n ;
		
	}
	
	

}
