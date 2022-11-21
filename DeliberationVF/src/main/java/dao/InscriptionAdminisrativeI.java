package dao;

import java.util.List;

import beans.InscriptionAdministrative;
import beans.Filiere;

public interface InscriptionAdminisrativeI {

	public List<Filiere> listFil();
	public int getIdFil(String filiere);
	public void addAdmini(InscriptionAdministrative inscriptionAd);
	public List<InscriptionAdministrative> listInsA();
	public List<String> an_acad();
	public void deleteEt(int IDIA);
	public InscriptionAdministrative chercherIA(int idIA);
	public void modifierIA(InscriptionAdministrative p);
}
