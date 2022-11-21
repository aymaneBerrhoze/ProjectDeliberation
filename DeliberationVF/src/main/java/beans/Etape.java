package beans;

public class Etape {

	private int idEtape;
	private String LibelleEtape;
	private int idSemestre;
	private int idFiliere;
	
	public Etape() {
		super();
	}
	
	public Etape(int idEtape, String libelleEtape, int idSemestre) {
		super();
		this.idEtape = idEtape;
		LibelleEtape = libelleEtape;
		this.idSemestre = idSemestre;
	}
	
	public int getIdEtape() {
		return idEtape;
	}
	public void setIdEtape(int idEtape) {
		this.idEtape = idEtape;
	}
	public String getLibelleEtape() {
		return LibelleEtape;
	}
	public void setLibelleEtape(String libelleEtape) {
		LibelleEtape = libelleEtape;
	}
	public int getIdSemestre() {
		return idSemestre;
	}
	public void setIdSemestre(int idSemestre) {
		this.idSemestre = idSemestre;
	}

	public int getIdFiliere() {
		return idFiliere;
	}

	public void setIdFiliere(int idFiliere) {
		this.idFiliere = idFiliere;
	}
	
	
}
