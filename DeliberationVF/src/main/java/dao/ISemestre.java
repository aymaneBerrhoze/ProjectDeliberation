package dao;

import java.util.List;

import beans.Semestre;

public interface ISemestre {

	public void ajouterSemestre(Semestre p);
	public List<Semestre> listeSemestre();
	public Semestre chercherSemestre(int idSemestre);
	public void modifierSemestre(Semestre p);
	public void supprimerSemestre(int idSemestre);
	public int getNbreSemestres();
	public int chercherSemestreParNom(String semestre);
	public List<Semestre> listeSemestreParFil(String Fil);
	
	
}
