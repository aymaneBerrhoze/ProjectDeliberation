package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Filiere;
import beans.InscriptionAdministrative;

public class InscriptionAdministrativeImpl implements InscriptionAdminisrativeI{

	@Override
	public int getIdFil(String filiere) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		PreparedStatement ps;
		int ID = 0;
		try {
			
			 ps = conn.prepareStatement("SELECT idFiliere from filiere WHERE NomFiliere=?");
			 ps.setString(1, filiere);
			 ResultSet rs = ps.executeQuery();
			 while(rs.next())
			 {
				ID=rs.getInt("idFiliere");
			 }
			 
			
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return ID;
	}

	@Override
	public void addAdmini(InscriptionAdministrative inscriptionAd) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into inscriptionadministrative(MassarEtud,Diplome,AdressePersonnelle,Telephone,AdresseEmail,AdresseParents,DateInscription,Bourse,Annee,idFiliere) values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, inscriptionAd.getMassarEtud());
			ps.setString(2, inscriptionAd.getDiplome());
			ps.setString(3, inscriptionAd.getAdressePersonnelle());
			ps.setString(4, inscriptionAd.getTelephone());
			ps.setString(5, inscriptionAd.getAdresseEmail());
			ps.setString(6, inscriptionAd.getAdresseParents());
			ps.setString(7, inscriptionAd.getDateInscription());
			ps.setString(8, inscriptionAd.getBourse());
			ps.setString(9, inscriptionAd.getAnnee());
			ps.setInt(10, getIdFil(inscriptionAd.getFiliere()));
			
			
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public List<InscriptionAdministrative> listInsA() {
		// TODO Auto-generated method stub
		List<InscriptionAdministrative> InscriptionAdministrative = new ArrayList<InscriptionAdministrative>();
        Connection conn = DAOFACTORY.getConnection();
        PreparedStatement ps;
        try {
            ps=conn.prepareStatement("SELECT * from inscriptionadministrative");

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {


                InscriptionAdministrative IA=new InscriptionAdministrative();
                IA.setIdIA(rs.getInt("idIA"));
                IA.setMassarEtud(rs.getString("MassarEtud"));
                IA.setDiplome(rs.getString("Diplome"));
                IA.setAdressePersonnelle(rs.getString("AdressePersonnelle"));
                IA.setAdresseParents(rs.getString("AdresseParents"));
                IA.setVille(rs.getString("Ville"));
                IA.setTelephone(rs.getString("Telephone"));
                IA.setAdresseEmail(rs.getString("AdresseEmail"));;
                IA.setAnnee(rs.getString("Annee"));
                IA.setBourse(rs.getString("Bourse"));
                int fil=rs.getInt("idFiliere");
                IA.setFiliere(String.valueOf(fil));
                IA.setDateInscription(rs.getString("DateInscription"));
                
                InscriptionAdministrative.add(IA);


            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return InscriptionAdministrative;
	}

	@Override
	public List<String> an_acad() {
		// TODO Auto-generated method stub
		List<String> an_acad = new ArrayList<String>();
        Connection conn = DAOFACTORY.getConnection();
        PreparedStatement ps;
        try
        {
        	 ps=conn.prepareStatement("select Annee from inscriptionadministrative");
        	 ResultSet rs = ps.executeQuery();
             while(rs.next())
             {
            	 an_acad.add(rs.getString("Annee"));
             }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return an_acad;
	}

	@Override
	public void deleteEt(int IDIA) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		PreparedStatement ps;
		try {
		       ps = conn.prepareStatement("delete from inscriptionadministrative where idIA = ?");
		       ps.setInt(1, IDIA);
		       System.out.print("delete : ");
		       ps.executeUpdate();
		       ps.close();
		       conn.close();
		       
		       
		       
		       
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public InscriptionAdministrative chercherIA(int idIA) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		InscriptionAdministrative IA = null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * from inscriptionadministrative WHERE idIA=? ;");
			ps.setInt(1, idIA);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				IA= new InscriptionAdministrative();
				IA.setIdIA(rs.getInt("idIA"));
				IA.setMassarEtud(rs.getString("MassarEtud"));
                IA.setDiplome(rs.getString("Diplome"));
                IA.setAdressePersonnelle(rs.getString("AdressePersonnelle"));
                IA.setAdresseParents(rs.getString("AdresseParents"));
                IA.setVille(rs.getString("Ville"));
                IA.setTelephone(rs.getString("Telephone"));
                IA.setAdresseEmail(rs.getString("AdresseEmail"));;
                IA.setAnnee(rs.getString("Annee"));
                IA.setBourse(rs.getString("Bourse"));
                int fil=rs.getInt("idFiliere");
                IA.setFiliere(String.valueOf(fil));
                IA.setDateInscription(rs.getString("DateInscription"));
			
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(IA==null)throw new RuntimeException("User "+idIA+" inexistant");
		
	return IA;	
	}

	@Override
	public void modifierIA(InscriptionAdministrative p) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		System.out.println("update function");
		try {
			PreparedStatement ps = conn.prepareStatement("update inscriptionadministrative set "
					+ "MassarEtud=?,Diplome=?,AdressePersonnelle=?,Telephone=?,AdresseEmail=?,AdresseParents=?,DateInscription=?,Bourse=?,Annee=?,idFiliere=? where idIA=?");
			
			ps.setString(1, p.getMassarEtud());
			ps.setString(2, p.getDiplome());
			ps.setString(3, p.getAdressePersonnelle());
			ps.setString(4, p.getTelephone());
			ps.setString(5, p.getAdresseEmail());
			ps.setString(6, p.getAdresseParents());
			ps.setString(7, p.getDateInscription());
			ps.setString(8, p.getBourse());
			ps.setString(9, p.getAnnee());
			ps.setInt(10, getIdFil(p.getFiliere()));
			ps.setInt(11, p.getIdIA());
			
			
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}

	@Override
	public List<Filiere> listFil() {
		// TODO Auto-generated method stub
		List<Filiere> Filieres = new ArrayList<Filiere>();
		Connection conn = DAOFACTORY.getConnection();
		PreparedStatement ps;
		try {
			
			 ps = conn.prepareStatement("SELECT * from filiere");
			 ResultSet rs = ps.executeQuery();
			 while(rs.next())
			 {
				 Filiere filiere=new Filiere();
				 filiere.setIdFiliere(rs.getInt("idFiliere"));
				 filiere.setNomFiliere(rs.getString("NomFiliere"));
				 Filieres.add(filiere);
			 }
			
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return Filieres;
	}

}
