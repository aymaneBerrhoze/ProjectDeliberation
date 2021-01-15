package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.IResponsablemodule;
import beans.responsablemodule;

public class RespModuleImp implements IResponsablemodule{
	@Override
	public responsablemodule getresponsableModule(String emailRF, String mdpRF){
		Connection connection= DAOFACTORY.getConnection();
		System.out.println("emailM "+emailRF+" mdpM : " +mdpRF);
		responsablemodule c  = new responsablemodule();
		try {
			PreparedStatement ps = connection.prepareStatement 
					("SELECT *  FROM responsablemodule  WHERE emailM=? and mdpM=?");	
			ps.setString(1, emailRF);
			ps.setString(2, mdpRF);
            ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				c.setIdresponsablemodule(rs.getInt("idresponsablemodule"));
				c.setEmailM(rs.getString("emailM"));
				c.setMdpM(rs.getString("mdpM"));
				c.setMdpM(mdpRF);		
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
			PreparedStatement ps  = connection.prepareStatement("SELECT mdpRF FROM responsablemodule WHERE emailM=? ");
			ps.setString(1, emailRF);
			ResultSet rs = ps.executeQuery();
			if(rs.next() && (rs.getString("mdpM")).equals(mdpRF) ){
				a=true;	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	
	}

}
