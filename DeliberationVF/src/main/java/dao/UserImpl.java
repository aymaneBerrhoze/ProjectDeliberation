package dao;

import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.codec.binary.Base64;

import beans.User;

public class UserImpl implements IUser {

	@Override
	public void ajouterUser(User p) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into user(nomU,prenomU,natureU,emailU,mdpU,imageU) values(?,?,?,?,?,?)");
				
			ps.setString(1,p.getNomU());
			ps.setString(2, p.getPrenomU());
			ps.setString(3, p.getNatureUser());
			ps.setString(4, p.getEmailU());
			ps.setString(5, p.getMdpU());
			ps.setBlob(6, p.getImage());
			

			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public User getUser(String login, String pwd) {
		// TODO Auto-generated method stub
		Connection connection= DAOFACTORY.getConnection();
		User c  = new User();
		try {
			PreparedStatement ps = connection.prepareStatement 
					("SELECT *  FROM user  WHERE emailU=? and mdpU=? ");	
			ps.setString(1, login);
			ps.setString(2, pwd);
            ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				c.setNomU(rs.getString("nomU"));
				c.setPrenomU(rs.getString("prenomU"));
				c.setNatureUser(rs.getString("natureU"));
				c.setEmailU(rs.getString("emailU"));
				c.setMdpU(rs.getString("mdpU"));
				c.setMdpU(pwd);		
				

				Blob blob = rs.getBlob("imageU");
        		
        		if(blob != null) {
        		
        		System.out.println(blob);
        		byte[] photo =blob.getBytes(1l, (int)blob.length());
        		photo=Base64.encodeBase64(photo);
        		String en=new String(photo,"UTF-8");
        		c.setEncodedPhoto(en);
        		
        		}
			}			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public boolean login(String login, String pwd) {
		// TODO Auto-generated method stub
		boolean a=false;		
		System.out.println(login +" "+ pwd);
		Connection connection = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps  = connection.prepareStatement("SELECT mdpU FROM user WHERE emailU=? ");
			ps.setString(1, login);
			ResultSet rs = ps.executeQuery();
			if(rs.next() && (rs.getString("mdpU")).equals(pwd) ){
				a=true;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public User chercherUser(int idUser) {
		// TODO Auto-generated method stub
		User ad = null ; 
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = connexion.prepareStatement( 
					" select * from user where iduser=? ");
			ps.setInt(1, idUser);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				ad  = new User();
				ad.setIdUser(rs.getInt("iduser"));
				ad.setEmailU(rs.getString("emailU"));
				ad.setMdpU(rs.getString("mdpU"));
				ad.setNomU(rs.getString("nomU"));
				ad.setPrenomU(rs.getString("prenomU"));
				ad.setNatureUser(rs.getString("natureU"));
				ad.setImage(rs.getBlob("imageU")); 
				Blob blob = rs.getBlob("imageU");
        		
        		if(blob != null) {
        		
        		//System.out.println(blob);
        		byte[] photo =blob.getBytes(1l, (int)blob.length());
        		photo=Base64.encodeBase64(photo);
        		String en=new String(photo,"UTF-8");
        		ad.setEncodedPhoto(en);
        		
        		}	
			}
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ad;
	}

	@Override
	public void modifierUser(User ad) {
		// TODO Auto-generated method stub
		Connection connexion = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps=connexion.prepareStatement("update user \r\n" + 
					"set  emailU=? , mdpU=? , nomU=?, prenomU=?, natureU=?, imageU=? WHERE iduser=? ;");
			
			ps.setString(1, ad.getEmailU());
			ps.setString(2, ad.getMdpU());
			ps.setString(3, ad.getNomU());
			ps.setString(4, ad.getPrenomU());
			ps.setString(5, ad.getNatureUser());
			ps.setBlob(6, ad.getImage());
			ps.setInt(7, ad.getIdUser());
			
			
			ps.executeUpdate();
	        ps.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
	}

	@Override
	public List<User> listeUser() {
		// TODO Auto-generated method stub
		List<User> professeurs = new ArrayList<User>();
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * from user ;");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User p = new User();
				p.setIdUser(rs.getInt("iduser"));
		        p.setNomU(rs.getString("nomU"));
		        p.setPrenomU(rs.getString("prenomU"));
		        p.setNatureUser(rs.getString("natureU"));
        		p.setEmailU(rs.getString("emailU"));
        		p.setMdpU(rs.getString("mdpU"));
        		//p.setImage(rs.getBlob("imageU"));
        		Blob blob = rs.getBlob("imageU");
        		
        		if(blob != null) {
        		
        		byte[] photo =blob.getBytes(1l, (int)blob.length());
        		photo=Base64.encodeBase64(photo);
        		String en=new String(photo,"UTF-8");
        		p.setEncodedPhoto(en);
        		
        		}
				professeurs.add(p);	
			}
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return professeurs;
	}

	@Override
	public void supprimerUser(int idUser) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		System.out.println("delete function");
		System.out.println("idAdmin: " + idUser);
			
			try {
				PreparedStatement ps = conn.prepareStatement("delete from user where iduser=?");
				
				ps.setInt(1,idUser);
				
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
	}

	@Override
	public List<User> listeUserRespoF() {
		// TODO Auto-generated method stub
		List<User> professeurs = new ArrayList<User>();
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * from user where natureU ='Responsable de la filiere' ;");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User p = new User();
				p.setIdUser(rs.getInt("iduser"));
		        p.setNomU(rs.getString("nomU"));
		        p.setPrenomU(rs.getString("prenomU"));
		        p.setNatureUser(rs.getString("natureU"));
        		p.setEmailU(rs.getString("emailU"));
        		p.setMdpU(rs.getString("mdpU"));

        		Blob blob = rs.getBlob("imageU");
        		
        		if(blob != null) {
        		
        		System.out.println(blob);
        		byte[] photo =blob.getBytes(1l, (int)blob.length());
        		photo=Base64.encodeBase64(photo);
        		String en=new String(photo,"UTF-8");
        		p.setEncodedPhoto(en);
        		
        		}
				professeurs.add(p);	
			}
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return professeurs;
	}

	@Override
	public List<User> listeUserRespoM() {
		// TODO Auto-generated method stub
		List<User> professeurs = new ArrayList<User>();
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * from user where natureU ='Responsable de module' ;");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User p = new User();
				p.setIdUser(rs.getInt("iduser"));
		        p.setNomU(rs.getString("nomU"));
		        p.setPrenomU(rs.getString("prenomU"));
		        p.setNatureUser(rs.getString("natureU"));
        		p.setEmailU(rs.getString("emailU"));
        		p.setMdpU(rs.getString("mdpU"));

        		Blob blob = rs.getBlob("imageU");
        		
        		if(blob != null) {
        		
        		System.out.println(blob);
        		byte[] photo =blob.getBytes(1l, (int)blob.length());
        		photo=Base64.encodeBase64(photo);
        		String en=new String(photo,"UTF-8");
        		p.setEncodedPhoto(en);
        		
        		}
				professeurs.add(p);	
			}
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return professeurs;
	}

	@Override
	public String getNatureUser(String login, String pwd) {
		// TODO Auto-generated method stub
		Connection connection= DAOFACTORY.getConnection();
		String nature=null;
		try {
			PreparedStatement ps = connection.prepareStatement 
					("SELECT natureU  FROM user  WHERE emailU=? and mdpU=? ");	
			ps.setString(1, login);
			ps.setString(2, pwd);
            ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				nature = rs.getString("natureU");
				return nature;		
			}			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nature;
	}

	@Override
	public int getNbreUsers() {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		int n = 0 ;
		try {
			PreparedStatement ps=conn.prepareStatement("SELECT count(iduser) from user; "); 
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				n = res.getInt("count(iduser)");
			}ps.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}
	    	
			return n ;
	}

	/*@Override
	public int getNbreAdmin() {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		int n = 0 ;
		try {
			PreparedStatement ps=conn.prepareStatement("SELECT count(iduser) from user where natureU='Administrateur' ; "); 
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				n = res.getInt("count(iduser)");
			}ps.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}
	    	
			return n ;
	}*/

}
