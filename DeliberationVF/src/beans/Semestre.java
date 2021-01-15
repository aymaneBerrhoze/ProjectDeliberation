package beans;

public class Semestre {

	private int idSemestre;
	private String LibelleSemestre;
	private int idModule;
	private int idEtape;
	
	public Semestre() {
		super();
	}

	public Semestre(int idSemestre, String libelleSemestre, int idModule) {
		super();
		this.idSemestre = idSemestre;
		LibelleSemestre = libelleSemestre;
		this.idModule = idModule;
	}

	public int getIdSemestre() {
		return idSemestre;
	}

	public void setIdSemestre(int idSemestre) {
		this.idSemestre = idSemestre;
	}

	public String getLibelleSemestre() {
		return LibelleSemestre;
	}

	public void setLibelleSemestre(String libelleSemestre) {
		LibelleSemestre = libelleSemestre;
	}

	public int getIdModule() {
		return idModule;
	}

	public void setIdModule(int idModule) {
		this.idModule = idModule;
	}

	public int getIdEtape() {
		return idEtape;
	}

	public void setIdEtape(int idEtape) {
		this.idEtape = idEtape;
	}
	
	
	
}
