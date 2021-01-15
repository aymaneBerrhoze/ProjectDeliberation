package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Semestre;

public class ImplSemestre implements ISemestre {

	@Override
	public void ajouterSemestre(Semestre p) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into semestre(LibelleSemestre,idEtape) values(?,?)");
			
			ps.setString(1,p.getLibelleSemestre());
			ps.setInt(2, p.getIdEtape());
			
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public List<Semestre> listeSemestre() {
		// TODO Auto-generated method stub
		List<Semestre> professeurs = new ArrayList<Semestre>();
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * from semestre ;");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Semestre p = new Semestre();
				p.setIdSemestre(rs.getInt("idSemestre"));
		        p.setLibelleSemestre(rs.getString("LibelleSemestre"));
        		p.setIdEtape(rs.getInt("idEtape"));
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
	public Semestre chercherSemestre(int idSemestre) {
		Connection conn = DAOFACTORY.getConnection();
		Semestre p = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * from semestre WHERE idSemestre=? ;");
			ps.setInt(1, idSemestre);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				p= new Semestre();
				p.setIdSemestre(rs.getInt("idSemestre"));
		        p.setLibelleSemestre(rs.getString("LibelleSemestre"));
        		p.setIdEtape(rs.getInt("idEtape"));
			
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(p==null)throw new RuntimeException("User "+idSemestre+" inexistant");
		
	return p;	
	}

	@Override
	public void modifierSemestre(Semestre p) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		System.out.println("update function");
		try {
			PreparedStatement ps = conn.prepareStatement("update semestre set "
					+ "LibelleSemestre=? ,idEtape=?"
					+ "where idSemestre=?");
			
			
			ps.setString(1,p.getLibelleSemestre());
			ps.setInt(2, p.getIdEtape());
			ps.setInt(3, p.getIdSemestre());
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}

	@Override
	public void supprimerSemestre(int idSemestre) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		System.out.println("delete function");
		System.out.println("idSemestre: " + idSemestre);
			
			try {
				PreparedStatement ps = conn.prepareStatement("delete from semestre where idSemestre=?");
				
				ps.setInt(1,idSemestre);
				
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
	}

	@Override
	public int getNbreSemestres() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int chercherSemestreParNom(String semestre) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		int id=-1;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT idSemestre from semestre WHERE LibelleSemestre=? ;");
			ps.setString(1, semestre);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				id = rs.getInt("idSemestre");
				return id;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return id;	
	}

	@Override
	public List<Semestre> listeSemestreParFil(String Fil) {
		// TODO Auto-generated method stub
		List<Semestre> professeurs = new ArrayList<Semestre>();
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT DISTINCT  s.LibelleSemestre from semestre s, etape e, filiere f where f.idFiliere=e.idFiliere and e.idEtape=s.idEtape and f.NomFiliere=? order by s.LibelleSemestre ;");
			ps.setString(1, Fil);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Semestre p = new Semestre();
				p.setLibelleSemestre(rs.getString("s.LibelleSemestre"));
				professeurs.add(p);
			}
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return professeurs;
	}

	
}
