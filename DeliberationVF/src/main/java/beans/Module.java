package beans;

public class Module {

	private int idModule;
	private String LebelleModule;
	private int idElement;
	private String filiere;
	private String responsableModule;
	private int idSemestre;
	private String semestre;
	
	public Module() {
		super();
	}
	
	public Module(int idModule, String lebelleModule, int idElement) {
		super();
		this.idModule = idModule;
		LebelleModule = lebelleModule;
		this.idElement = idElement;
	}

	public int getIdModule() {
		return idModule;
	}

	public void setIdModule(int idModule) {
		this.idModule = idModule;
	}

	public String getLebelleModule() {
		return LebelleModule;
	}

	public void setLebelleModule(String lebelleModule) {
		LebelleModule = lebelleModule;
	}

	public int getIdElement() {
		return idElement;
	}

	public void setIdElement(int idElement) {
		this.idElement = idElement;
	}

	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	public String getResponsableModule() {
		return responsableModule;
	}

	public void setResponsableModule(String responsableModule) {
		this.responsableModule = responsableModule;
	}

	public int getIdSemestre() {
		return idSemestre;
	}

	public void setIdSemestre(int idSemestre) {
		this.idSemestre = idSemestre;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	
	
	
}
