package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.IResponsableFiliere;
import beans.responsableFiliere;

public class RespFiliereImp implements IResponsableFiliere{
	@Override
	public responsableFiliere getresponsablefiliere(String emailRF, String mdpRF){
		Connection connection= DAOFACTORY.getConnection();
		System.out.println("emailRF "+emailRF+" mdpRF : " +mdpRF);
		responsableFiliere c  = new responsableFiliere();
		try {
			PreparedStatement ps = connection.prepareStatement 
					("SELECT *  FROM responsablefiliere  WHERE emailRF=? and mdpRF=?");	
			ps.setString(1, emailRF);
			ps.setString(2, mdpRF);
            ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				c.setIdresponsablefiliere(rs.getInt("idresponsableFiliere"));
				c.setEmailRF(rs.getString("emailRF"));
				c.setMdpRF(rs.getString("mdpRF"));
				c.setMdpRF(mdpRF);		
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	
	@Override
	public boolean login(String emailRF, String mdpRF) {
		boolean a=false;		
		System.out.println(emailRF +" "+ mdpRF);
		Connection connection = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps  = connection.prepareStatement("SELECT mdpRF FROM responsablefiliere WHERE emailRF=? ");
			ps.setString(1, emailRF);
			ResultSet rs = ps.executeQuery();
			if(rs.next() && (rs.getString("mdpRF")).equals(mdpRF) ){
				a=true;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	
	}

}
