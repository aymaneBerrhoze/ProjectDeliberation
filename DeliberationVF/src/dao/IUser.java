package dao;

import java.util.List;

import beans.User;

public interface IUser {

	public void ajouterUser(User p);
	public User getUser(String login, String pwd);	
	public String getNatureUser(String login, String pwd);	
	public boolean login(String login, String pwd);
	public User chercherUser(int idUser);
	public void modifierUser(User ad);
	public List<User> listeUser();
	public List<User> listeUserRespoF();
	public List<User> listeUserRespoM();
	public void supprimerUser(int idUser);
	public int getNbreUsers();
	//public int getNbreAdmin();
}
