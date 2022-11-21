package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Admin;

public class IAdminDaoImpl implements IAdminDAO {

	@Override
	public Admin getAdmin(String login, String pwd) {
		Connection connection= DAOFACTORY.getConnection();
		Admin c  = new Admin();
		try {
			PreparedStatement ps = connection.prepareStatement 
					("SELECT *  FROM admin  WHERE EmailAdmin=? and mdpAdmin=?");	
			ps.setString(1, login);
			ps.setString(2, pwd);
            ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				c.setEmailAdmin(rs.getString("EmailAdmin"));
				c.setMdpAdmin(rs.getString("mdpAdmin"));
				c.setMdpAdmin(pwd);		
			}			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public boolean login(String login, String pwd) {
		boolean a=false;		
		System.out.println(login +" "+ pwd);
		Connection connection = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps  = connection.prepareStatement("SELECT mdpAdmin FROM admin WHERE EmailAdmin=? ");
			ps.setString(1, login);
			ResultSet rs = ps.executeQuery();
			if(rs.next() && (rs.getString("mdpAdmin")).equals(pwd) ){
				a=true;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public Admin chercherAdmin(String loginAdmin) {
		Admin ad = null ; 
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = connexion.prepareStatement( 
					" select * from admin where EmailAdmin=? ");
			ps.setString(1, loginAdmin);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				ad  = new Admin();
				ad.setIdadmin(rs.getInt("idAdmin"));
				ad.setEmailAdmin(rs.getString("EmailAdmin"));
				ad.setMdpAdmin(rs.getString("mdpAdmin"));
				ad.setNomAdmin(rs.getString("nomAdmin"));
				
			}
			  ps.close();


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ad;
	
	}

	@Override
	public void modifierAdmin(Admin ad) {
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps=connexion.prepareStatement("update admin \r\n" + 
					"set  EmailAdmin=? , mdpAdmin=? ;");
			
			ps.setString(1, ad.getEmailAdmin());
			ps.setString(2, ad.getMdpAdmin());
			
			
			ps.executeUpdate();
	        ps.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
	}

	@Override
	public void ajouterAdmin(Admin p) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into admin(nomAdmin,EmailAdmin,mdpAdmin) values(?,?,?)");
				
			ps.setString(1,p.getNomAdmin());
			ps.setString(2, p.getEmailAdmin());
			ps.setString(3, p.getMdpAdmin());
			

			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public List<Admin> listeAdmin() {
		// TODO Auto-generated method stub
		List<Admin> professeurs = new ArrayList<Admin>();
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * from admin ;");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Admin p = new Admin();
				p.setIdadmin(rs.getInt("idadmin"));
		        p.setNomAdmin(rs.getString("nomAdmin"));
        		p.setEmailAdmin(rs.getString("EmailAdmin"));
        		p.setMdpAdmin(rs.getString("mdpAdmin"));
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
	public void supprimerAdmin(int idAdmin) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		System.out.println("delete function");
		System.out.println("idAdmin: " + idAdmin);
			
			try {
				PreparedStatement ps = conn.prepareStatement("delete from admin where idAdmin=?");
				
				ps.setInt(1,idAdmin);
				
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
	}

}
