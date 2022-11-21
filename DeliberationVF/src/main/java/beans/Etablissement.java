package beans;

public class Etablissement {
	private int idEtablissement;
	private String etablissement;
	private String description;
	
	
	
	public Etablissement() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Etablissement(int idEtablissement, String etablissement, String description) {
		super();
		this.setIdEtablissement(idEtablissement);
		this.etablissement = etablissement;
		this.description = description;
	}



	public String getEtablissement() {
		return etablissement;
	}
	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}



	public int getIdEtablissement() {
		return idEtablissement;
	}



	public void setIdEtablissement(int idEtablissement) {
		this.idEtablissement = idEtablissement;
	}
	
	
	
	

}
