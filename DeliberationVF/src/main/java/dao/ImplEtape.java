package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Etape;

public class ImplEtape implements IEtape {

	@Override
	public void ajouterEtape(Etape p) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into etape(LibelleEtape,idFiliere) values(?,?)");
				
			ps.setString(1,p.getLibelleEtape());
			ps.setInt(2, p.getIdFiliere());
			

			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public List<Etape> listeEtape() {
		// TODO Auto-generated method stub
		List<Etape> professeurs = new ArrayList<Etape>();
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * from etape ;");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Etape p = new Etape();
				p.setIdEtape(rs.getInt("idEtape"));
		        p.setLibelleEtape(rs.getString("LibelleEtape"));
        		p.setIdFiliere(rs.getInt("idFiliere"));
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
	public Etape chercherEtape(int idEtape) {
		Connection conn = DAOFACTORY.getConnection();
		Etape p = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * from element WHERE idEtape=? ;");
			ps.setInt(1, idEtape);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				p= new Etape();
				p.setIdEtape(rs.getInt("idEtape"));
		        p.setLibelleEtape(rs.getString("LibelleEtape"));
        		p.setIdFiliere(rs.getInt("idFiliere"));
			
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(p==null)throw new RuntimeException("User "+idEtape+" inexistant");
		
	return p;	
	}

	@Override
	public void modifierEtape(Etape p) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		System.out.println("update function");
		try {
			PreparedStatement ps = conn.prepareStatement("update etape set "
					+ "LibelleEtape=? ,idFiliere=?"
					+ "where idEtape=?");
			
			
			ps.setString(1,p.getLibelleEtape());
			ps.setInt(2, p.getIdFiliere());
			ps.setInt(3, p.getIdEtape());
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}

	@Override
	public void supprimerEtape(int idEtape) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		System.out.println("delete function");
		System.out.println("idElement: " + idEtape);
			
			try {
				PreparedStatement ps = conn.prepareStatement("delete from etape where idEtape=?");
				
				ps.setInt(1,idEtape);
				
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
	}

	
}
