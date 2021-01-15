package dao;

import java.util.List;

import beans.Module;

public interface IModule {

	public void ajouterModule(Module p);
	public List<Module> listeModule();
	public Module chercherModule(int idModule);
	public void modifierModule(Module p);
	public void supprimerModule(int idModule);
	public int getNbreModules();
}
