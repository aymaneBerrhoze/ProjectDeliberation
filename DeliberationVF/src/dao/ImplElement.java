package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Element;

public class ImplElement implements IElement {

	@Override
	public void ajouterElement(Element p) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into element(LibelleElement,CodeElement,idModule) values(?,?)");
				
			ps.setString(1,p.getLibelleElement());
			ps.setString(2, p.getCodeElement());
			ps.setInt(3, p.getIdModule());
			

			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public List<Element> listeElement() {
		// TODO Auto-generated method stub
		List<Element> professeurs = new ArrayList<Element>();
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * from element ;");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Element p = new Element();
				p.setIdElement(rs.getInt("idElement"));
		        p.setLibelleElement(rs.getString("LibelleElement"));
        		p.setCodeElement(rs.getString("CodeElement"));
        		p.setIdModule(rs.getInt("idModule"));
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
	public Element chercherElement(int idElement) {
		Connection conn = DAOFACTORY.getConnection();
		Element p = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * from element WHERE idElement=? ;");
			ps.setInt(1, idElement);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				p= new Element();
				p.setIdElement(rs.getInt("idElement"));
		        p.setLibelleElement(rs.getString("LibelleElement"));
        		p.setCodeElement(rs.getString("CodeElement"));
        		p.setIdModule(rs.getInt("idModule"));
			
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(p==null)throw new RuntimeException("User "+idElement+" inexistant");
		
	return p;	
	}

	@Override
	public void modifierElement(Element p) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		System.out.println("update function");
		try {
			PreparedStatement ps = conn.prepareStatement("update element set "
					+ "LibelleElement=? ,CodeElement=?, idModule=?"
					+ "where idElement=?");
			
			
			ps.setString(1,p.getLibelleElement());
			ps.setString(2, p.getCodeElement());
			ps.setInt(3, p.getIdModule());
			ps.setInt(4, p.getIdElement());
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}

	@Override
	public void supprimerElement(int idElement) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		System.out.println("delete function");
		System.out.println("idElement: " + idElement);
			
			try {
				PreparedStatement ps = conn.prepareStatement("delete from element where idElement=?");
				
				ps.setInt(1,idElement);
				
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
	}

	@Override
	public int getNbreElementsParModule(String module) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		int n = 0 ;
		try {
			PreparedStatement ps=conn.prepareStatement("SELECT count(e.idElement) from element e, module m where e.idModule=m.idModule and m.LebelleModule=?; "); 
			ps.setString(1,module);
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				n = res.getInt("count(e.idElement)");
			}ps.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}
	    	
			return n ;
	}

	@Override
	public int getNbreElements() {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		int n = 0 ;
		try {
			PreparedStatement ps=conn.prepareStatement("SELECT count(idElement) from element ; "); 
			
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				n = res.getInt("count(idElement)");
			}ps.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}
	    	
			return n ;
	}

	@Override
	public List<Element> listeElementParMod(String module) {
		// TODO Auto-generated method stub
		List<Element> professeurs = new ArrayList<Element>();
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT e.LibelleElement from element e, module m where e.idModule=m.idModule and m.LebelleModule=?;");
			ps.setString(1, module);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Element p = new Element();
				p.setLibelleElement(rs.getString("e.LibelleElement"));
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
