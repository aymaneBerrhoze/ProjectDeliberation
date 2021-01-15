package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.Etape;
import beans.InscriptionPedagogique;
import beans.Module;
import beans.Semestre;

public class InscriptionPedagogiqueImpl implements InscriptionPedagogiqueI {

	@Override
	public List<Etape> listEtapes() {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		List<Etape> Etapes = new ArrayList<Etape>();
		PreparedStatement ps;
		try {
			 ps = conn.prepareStatement("select * from etape");
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()) {
				 Etape et=new Etape();
				 et.setIdEtape(rs.getInt("idEtape"));
				 et.setLibelleEtape(rs.getString("LibelleEtape"));
				 et.setIdFiliere(rs.getInt("idFiliere"));
				 Etapes.add(et);
			 }
			 ps.close();
		     conn.close();
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		return Etapes;
	}

	@Override
	public List<Semestre> listSemestres() {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
        List<Semestre> Se = new ArrayList<Semestre>();
        PreparedStatement ps;
        try {
             ps = conn.prepareStatement("select * from semestre");
             ResultSet rs = ps.executeQuery();
             while(rs.next()) {
                 Semestre se=new Semestre();
                 se.setIdSemestre(rs.getInt("idSemestre"));
                 se.setLibelleSemestre(rs.getString("LibelleSemestre"));
                 se.setIdEtape(rs.getInt("idEtape"));
                 Se.add(se);
             }
             ps.close();
             conn.close();

        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return Se;
	}

	@Override
	public List<Module> listModules() {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
        List<Module> module = new ArrayList<Module>();
        PreparedStatement ps;
        try {
             ps = conn.prepareStatement("select * from module");
             ResultSet rs = ps.executeQuery();
             while(rs.next()) {
                 Module mod=new Module();
                 mod.setIdModule(rs.getInt("idModule"));
                 mod.setLebelleModule(rs.getString("LebelleModule"));
                 mod.setIdSemestre(rs.getInt("idSemestre"));
                 module.add(mod);
                 
             }
             ps.close();
             conn.close();

        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return module;
	}

	@Override
	public void ajouterIP(InscriptionPedagogique IP) {
		// TODO Auto-generated method stub
		 Connection conn = DAOFACTORY.getConnection();
		 PreparedStatement ps;
		 try {
            ps=conn.prepareStatement("insert into inscriptionpedagogique(idIA,MassarEtud,idEtape)values(?,?,?)");
            
            ps.setInt(1, IP.getIdIA());
            ps.setString(2, IP.getMassarEtud());
            ps.setInt(3, IP.getIDEtape());
           
            ps.executeUpdate();
            
            ps.close();
             conn.close();

        }

        catch (Exception e) {
            e.printStackTrace();
        }
	}

	@Override
	public List<Semestre> getSemestreParEtape(int IDEtape) {
		// TODO Auto-generated method stub
		 Connection conn = DAOFACTORY.getConnection();
         List<Semestre> Se = new ArrayList<Semestre>();
         PreparedStatement ps;
         try {
              ps = conn.prepareStatement("select * from semestre where idEtape=?");
              ps.setInt(1, IDEtape);
              ResultSet rs = ps.executeQuery();
              
              while(rs.next()) {
                  Semestre se=new Semestre();
                  se.setIdSemestre(rs.getInt("idSemestre"));
                  se.setLibelleSemestre(rs.getString("LibelleSemestre"));
                  se.setIdEtape(rs.getInt("idEtape"));
                  Se.add(se);
              }
              ps.close();
              conn.close();

         }

         catch (Exception e) {
             e.printStackTrace();
         }
         return Se;
	}

	@Override
	public List<Module> getModuleParSem(int IDSem) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
        List<Module> Se = new ArrayList<Module>();
        PreparedStatement ps;
        try {
             ps = conn.prepareStatement("select * from module where idSemestre=?");
             ps.setInt(1, IDSem);
             ResultSet rs = ps.executeQuery();
             
             while(rs.next()) {
                 Module se=new Module();
                 se.setIdModule(rs.getInt("idModule"));
                 se.setLebelleModule(rs.getString("LebelleModule"));
                 se.setIdSemestre(rs.getInt("idSemestre"));
                 Se.add(se);
             }
             ps.close();
             conn.close(); 
             } catch (Exception e) {
            e.printStackTrace();
        }
        return Se;
	}

	@Override
	public void addSem(InscriptionPedagogique inscriptionPedagogique, int IDSemestre) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		 PreparedStatement ps;
		 
		 try {
	            ps = conn.prepareStatement("UPDATE inscriptionpedagogique SET idSemestre=? where idIP=?");

	            ps.setInt(1, IDSemestre);
	            ps.setInt(2, inscriptionPedagogique.getIdIP());
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	             
	             
	        }

	        catch (Exception e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public void addMod(InscriptionPedagogique inscriptionPedagogique, int IDModule) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		 PreparedStatement ps;
		 try {
	            ps = conn.prepareStatement("UPDATE inscriptionpedagogique SET idModule=? where idIP=?");

	            ps.setInt(1, IDModule);
	            ps.setInt(2, inscriptionPedagogique.getIdIP());
	            ps.executeUpdate();
	            ps.close();
	            conn.close();
	             
	            
	        }

	        catch (Exception e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public List<InscriptionPedagogique> listInP() {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		 List<InscriptionPedagogique> insP=new ArrayList<InscriptionPedagogique>();
		 PreparedStatement ps;
		 try {
           ps = conn.prepareStatement("select * from inscriptionpedagogique");
           ResultSet rs = ps.executeQuery();
           while(rs.next()) {
           	InscriptionPedagogique se=new InscriptionPedagogique();
               se.setIdIA(rs.getInt("idIA"));
               se.setIDEtape(rs.getInt("idEtape"));
               se.setMassarEtud(rs.getString("MassarEtud"));
               se.setIDModule(rs.getInt("idModule"));
               se.setIDSemestre(rs.getInt("idSemestre"));
               se.setIdIP(rs.getInt("idIP"));
               insP.add(se);
               
           }
           ps.close();
            conn.close();

       }

       catch (Exception e) {
           e.printStackTrace();
       }
		return insP;
	}

}
