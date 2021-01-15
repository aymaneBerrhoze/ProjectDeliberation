package dao;

import java.util.List;

import beans.Admin;

public interface IAdminDAO {

	public void ajouterAdmin(Admin p);
	public Admin getAdmin(String login, String pwd);	
	public boolean login(String login, String pwd);
	public Admin chercherAdmin(String loginAdmin);
	public void modifierAdmin(Admin ad);
	public List<Admin> listeAdmin();
	public void supprimerAdmin(int idAdmin);
	
}
