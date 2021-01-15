package dao;

import java.util.List;
import beans.Filiere;

public interface IFiliere {

	public void ajouterFiliere(Filiere p);
	public List<Filiere> listeFiliere();
	public Filiere chercherFiliere(int idFiliere);
	public void modifierFiliere(Filiere p);
	public void supprimerFiliere(int idFiliere);
	public int getNbreFilieres();
	
}
