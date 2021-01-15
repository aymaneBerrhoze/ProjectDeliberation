package beans;

public class Professeur {

	private int idProfesseur;
	private String NomProf;
	private String PrenomProf;
	private String Discipline;
	private String etablissement;
	private String Departement_dattache ;
	private String module_enseigne;
	private String emailP;
	private String mdpP;
	private String telP;
	
	public Professeur() {
		super();
	}
	
	public Professeur(int idProfesseur, String nomProf, String prenomProf, String discipline, String etablissement,
			String departement_dattache, String module_enseigne, String emailP, String mdpP) {
		super();
		this.idProfesseur = idProfesseur;
		NomProf = nomProf;
		PrenomProf = prenomProf;
		Discipline = discipline;
		this.etablissement = etablissement;
		Departement_dattache = departement_dattache;
		this.module_enseigne = module_enseigne;
		this.emailP = emailP;
		this.mdpP = mdpP;
	}
	
	public int getIdProfesseur() {
		return idProfesseur;
	}

	public void setIdProfesseur(int idProfesseur) {
		this.idProfesseur = idProfesseur;
	}

	public String getNomProf() {
		return NomProf;
	}

	public void setNomProf(String nomProf) {
		NomProf = nomProf;
	}

	public String getPrenomProf() {
		return PrenomProf;
	}

	public void setPrenomProf(String prenomProf) {
		PrenomProf = prenomProf;
	}

	public String getDiscipline() {
		return Discipline;
	}

	public void setDiscipline(String discipline) {
		Discipline = discipline;
	}

	public String getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}

	public String getDepartement_dattache() {
		return Departement_dattache;
	}

	public void setDepartement_dattache(String departement_dattache) {
		Departement_dattache = departement_dattache;
	}

	public String getModule_enseigne() {
		return module_enseigne;
	}

	public void setModule_enseigne(String module_enseigne) {
		this.module_enseigne = module_enseigne;
	}


	public String getEmailP() {
		return emailP;
	}

	public void setEmailP(String emailP) {
		this.emailP = emailP;
	}

	public String getMdpP() {
		return mdpP;
	}

	public void setMdpP(String mdpP) {
		this.mdpP = mdpP;
	}

	public String getTelP() {
		return telP;
	}

	public void setTelP(String telP) {
		this.telP = telP;
	}
	
	
	
}
