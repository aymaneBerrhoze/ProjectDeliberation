package dao;

import java.util.List;

import beans.Etape;
import beans.Module;
import beans.Semestre;
import beans.InscriptionPedagogique;

public interface InscriptionPedagogiqueI {

	public List<Etape> listEtapes();
	public List<Semestre> listSemestres();
	public List<Module> listModules();
	public void ajouterIP(InscriptionPedagogique IP);
	public List <Semestre>getSemestreParEtape(int IDEtape);
	public List <Module>getModuleParSem(int IDSem);
	public void addSem(InscriptionPedagogique inscriptionPedagogique,int IDSemestre);
	public void addMod(InscriptionPedagogique inscriptionPedagogique,int IDModule);
	public List<InscriptionPedagogique> listInP();

}
