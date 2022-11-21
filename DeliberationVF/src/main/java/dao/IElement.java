package dao;

import java.util.List;

import beans.Element;
//import beans.Module;

public interface IElement {

	public void ajouterElement(Element p);
	public List<Element> listeElement();
	public Element chercherElement(int idElement);
	public void modifierElement(Element p);
	public void supprimerElement(int idElement);
	public int getNbreElements();
	public int getNbreElementsParModule(String module);
	public List<Element> listeElementParMod(String module);
}
