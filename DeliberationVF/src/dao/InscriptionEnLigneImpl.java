package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.InscriptionEnLigne;

public class InscriptionEnLigneImpl implements InscriptionEnLigneI {

	@Override
	public void ajouterInscriptionEnLigne(InscriptionEnLigne p) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into inscriptionenligne(MassarEtud,NomFr,NomAr,PrenomFr,PrenomAr,CIN,Nationalite,Sexe,DateDeNaissance,LieuDeNaissance,LieuDeNaissanceAR,Ville,Province,AnneeBac,SerieBac,MentionBac,LyceeBac,VilleBac,Academie,Date1ereInscription) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, p.getMassarEtud());
			ps.setString(2, p.getNomFr());
			ps.setString(3, p.getNomAr());
			ps.setString(4, p.getPrenomFr());
			ps.setString(5, p.getPrenomAr());
			ps.setString(6, p.getCIN());
			ps.setString(7, p.getNationalite());
			ps.setString(8, p.getSexe());
			ps.setString(9, p.getDateDeNaissance());
			ps.setString(10, p.getLieuDeNaissance());
			ps.setString(11, p.getLieuDeNaissanceAR());
			ps.setString(12, p.getVille());
			ps.setString(13, p.getProvince());
			ps.setString(14, p.getAnneeBac());
			ps.setString(15, p.getSerieBac());
			ps.setString(16, p.getMentionBac());
			ps.setString(17, p.getLyceeBac());
			ps.setString(18, p.getVilleBac());
			ps.setString(19, p.getAcademie());
			ps.setString(20, p.getDate1ereInscription());
			
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public List<InscriptionEnLigne> listInscriptionEnLigne() {
		// TODO Auto-generated method stub
		List<InscriptionEnLigne> etudiants = new ArrayList<InscriptionEnLigne>();
		Connection conn = DAOFACTORY.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * from inscriptionenligne");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				InscriptionEnLigne i = new InscriptionEnLigne();
				i.setMassarEtud("MassarEtud");
				i.setNomFr("NomFr");
				i.setNomAr("NomAr");
				i.setPrenomFr("PrenomFr");
				i.setPrenomAr("PrenomAr");
				i.setCIN("CIN");
				i.setNationalite("Nationalite");
				i.setSexe("Sexe");
				i.setDateDeNaissance("DateDeNaissance");
				i.setLieuDeNaissance("LieuDeNaissance");
				i.setLieuDeNaissanceAR("LieuDeNaissanceAR");
				i.setVille("Ville");
				i.setProvince("Province");
				i.setAnneeBac("AnneeBac");
				i.setSerieBac("SerieBac");
				i.setMentionBac("MentionBac");
				i.setLyceeBac("LyceeBac");
				i.setVilleBac("VilleBac");
				i.setAcademie("Academie");
				i.setDate1ereInscription("Date1ereInscription");
				etudiants.add(i);
				
			}
		}catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return etudiants;
	}

	@Override
	public void deleteInscriptionEnLigne(String massarEtud) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		System.out.println("delete function");
		System.out.println("massarEtud: " + massarEtud);
			
			try {
				PreparedStatement ps = conn.prepareStatement("delete from inscriptionenligne where MassarEtud=?");
				
				ps.setString(1,massarEtud);
				
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
	}

	@Override
	public InscriptionEnLigne getEt(String massarEtud) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		InscriptionEnLigne i =null;
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * from inscriptionenligne WHERE MassarEtud=? ;");
			ps.setString(1, massarEtud);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				i = new InscriptionEnLigne();
				i.setMassarEtud("MassarEtud");
				i.setNomFr("NomFr");
				i.setNomAr("NomAr");
				i.setPrenomFr("PrenomFr");
				i.setPrenomAr("PrenomAr");
				i.setCIN("CIN");
				i.setNationalite("Nationalite");
				i.setSexe("Sexe");
				i.setDateDeNaissance("DateDeNaissance");
				i.setLieuDeNaissance("LieuDeNaissance");
				i.setLieuDeNaissanceAR("LieuDeNaissanceAR");
				i.setVille("Ville");
				i.setProvince("Province");
				i.setAnneeBac("AnneeBac");
				i.setSerieBac("SerieBac");
				i.setMentionBac("MentionBac");
				i.setLyceeBac("LyceeBac");
				i.setVilleBac("VilleBac");
				i.setAcademie("Academie");
				i.setDate1ereInscription("Date1ereInscription");
			}
			
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(i==null)throw new RuntimeException("Etudiant "+massarEtud+" inexistant");
		
	return i;	
	}

	@Override
	public void updateEt(InscriptionEnLigne etudiant) {
		// TODO Auto-generated method stub
		Connection conn = DAOFACTORY.getConnection();
		System.out.println("update function");
		try {
			PreparedStatement ps = conn.prepareStatement("update inscriptionenligne set MassarEtud=?, NomFr=?, NomAr=?, PrenomFr=?, PrenomAr=?, CIN=?, Nationalite=?, Sexe=?, DateDeNaissance=?, LieuDeNaissance=?, LieuDeNaissanceAR=?,Ville=?,Province=?,AnneeBac=?,SerieBac=?,MentionBac=?,LyceeBac=?,VilleBac=?,Academie=?,Date1ereInscription=? where MassarEtud=?");
			ps.setString(1, etudiant.getMassarEtud());
			ps.setString(2, etudiant.getNomFr());
			ps.setString(3, etudiant.getNomAr());
			ps.setString(4, etudiant.getPrenomFr());
			ps.setString(5, etudiant.getPrenomAr());
			ps.setString(6, etudiant.getCIN());
			ps.setString(7, etudiant.getNationalite());
			ps.setString(8, etudiant.getSexe());
			ps.setString(9, etudiant.getDateDeNaissance());
			ps.setString(10, etudiant.getLieuDeNaissance());
			ps.setString(11, etudiant.getLieuDeNaissanceAR());
			ps.setString(12, etudiant.getVille());
			ps.setString(13, etudiant.getProvince());
			ps.setString(14, etudiant.getAnneeBac());
			ps.setString(15, etudiant.getSerieBac());
			ps.setString(16, etudiant.getMentionBac());
			ps.setString(17, etudiant.getLyceeBac());
			ps.setString(18, etudiant.getVilleBac());
			ps.setString(19, etudiant.getAcademie());
			ps.setString(20, etudiant.getDate1ereInscription());
			ps.setString(21, etudiant.getMassarEtud());
	} catch (SQLException e1) {
		
		e1.printStackTrace();
	}
		}

}
