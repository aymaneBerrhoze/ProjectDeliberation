package beans;

public class Filiere {

	private int idFiliere;
	private String NomFiliere;
	private int idEtape;
	private String responsablefiliere;
	
	
	public Filiere() {
		super();
	}
	
	public Filiere(int idFiliere, String nomFiliere, int idEtape) {
		super();
		this.idFiliere = idFiliere;
		NomFiliere = nomFiliere;
		this.idEtape = idEtape;
	}

	public int getIdFiliere() {
		return idFiliere;
	}

	public void setIdFiliere(int idFiliere) {
		this.idFiliere = idFiliere;
	}

	public String getNomFiliere() {
		return NomFiliere;
	}

	public void setNomFiliere(String nomFiliere) {
		NomFiliere = nomFiliere;
	}

	public int getIdEtape() {
		return idEtape;
	}

	public void setIdEtape(int idEtape) {
		this.idEtape = idEtape;
	}

	public String getResponsablefiliere() {
		return responsablefiliere;
	}

	public void setResponsablefiliere(String responsablefiliere) {
		this.responsablefiliere = responsablefiliere;
	}
	
	
	
}
