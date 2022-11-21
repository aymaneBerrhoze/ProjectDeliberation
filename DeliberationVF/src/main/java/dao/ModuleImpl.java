package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Module;

public class ModuleImpl implements IModule {

	@Override
	public void ajouterModule(Module p) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into module(LebelleModule,filiere,idSemestre) values(?,?,?)");
				
			ps.setString(1,p.getLebelleModule());
			ps.setString(2, p.getFiliere());
			ps.setInt(3, p.getIdSemestre());
			
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public List<Module> listeModule() {
		// TODO Auto-generated method stub
		List<Module> professeurs = new ArrayList<Module>();
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT m.*,s.* from module m, semestre s where m.idSemestre=s.idSemestre ;");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Module p = new Module();
				p.setIdModule(rs.getInt("m.idModule"));
		        p.setLebelleModule(rs.getString("m.LebelleModule"));
		        p.setFiliere(rs.getString("m.filiere"));
		        p.setSemestre(rs.getString("s.LibelleSemestre"));
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
	public Module chercherModule(int idModule) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		Module p = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * from module WHERE idModule=? ;");
			ps.setInt(1, idModule);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				p= new Module();
				p.setIdModule(idModule);
		        p.setLebelleModule(rs.getString("LebelleModule"));
		        p.setFiliere(rs.getString("filiere"));
		        p.setIdSemestre(rs.getInt("idSemestre"));
			
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(p==null)throw new RuntimeException("User "+idModule+" inexistant");
		
	return p;	
	}

	@Override
	public void modifierModule(Module p) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		System.out.println("update function");
		try {
			PreparedStatement ps = conn.prepareStatement("update module set "
					+ "LebelleModule=?,filiere=?,idSemestre=? "
					+ "where idModule=?");
			
			
			ps.setString(1,p.getLebelleModule());
			ps.setString(2, p.getFiliere());
			ps.setInt(3, p.getIdSemestre());
			ps.setInt(4, p.getIdModule());
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}

	@Override
	public void supprimerModule(int idModule) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		System.out.println("delete function");
		System.out.println("idModule: " + idModule);
			
			try {
				PreparedStatement ps = conn.prepareStatement("delete from module where idModule=?");
				
				ps.setInt(1,idModule);
				
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
	}

	
	@Override
	public int getNbreModules() {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		int n = 0 ;
		try {
			PreparedStatement ps=conn.prepareStatement("SELECT count(idModule) from module; "); 
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				n = res.getInt("count(idModule)");
			}ps.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}
	    	
			return n ;
	}
	

}
