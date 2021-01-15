package dao;

import java.util.List;

import beans.Etape;

public interface IEtape {

	public void ajouterEtape(Etape p);
	public List<Etape> listeEtape();
	public Etape chercherEtape(int idEtape);
	public void modifierEtape(Etape p);
	public void supprimerEtape(int idEtape);
}
