package dao;

import java.util.List;

import beans.Module;
import beans.Professeur;

public interface IProfessor {

	public void ajouterProfesseur(Professeur p);
	public List<Professeur> listeProfesseur();
	public List<Module> listeProfesseurParModule(String Fil);
	public Professeur chercherProfesseur(int idProfesseur);
	public void modifierProfesseur(Professeur p);
	public void supprimerProfesseur(int idProfesseur);
	public Professeur getProfessor(String login, String pwd);	
	public boolean login(String login, String pwd);
	public int getModuleParNom(String nom);
	public Professeur getProfessorParNom(String nom);
	public int getNbreProfesseurs();

}
