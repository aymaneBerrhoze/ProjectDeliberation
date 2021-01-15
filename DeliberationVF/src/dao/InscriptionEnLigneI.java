package dao;

import java.util.List;

import beans.InscriptionEnLigne;

public interface InscriptionEnLigneI {

	public void ajouterInscriptionEnLigne(InscriptionEnLigne p);
	public List<InscriptionEnLigne> listInscriptionEnLigne();
	public void deleteInscriptionEnLigne(String massarEtud);
	public InscriptionEnLigne getEt(String massarEtud);
	public void updateEt(InscriptionEnLigne etudiant);
	
}
