package beans;

public class Admin {

	private int idadmin;
	private String nomAdmin;
	private String emailAdmin;
	private String mdpAdmin;
	
	public Admin() {
		super();
	}

	public Admin(int idadmin, String emailAdmin, String mdpAdmin) {
		super();
		this.idadmin = idadmin;
		this.emailAdmin = emailAdmin;
		this.mdpAdmin = mdpAdmin;
		
	}

	public int getIdadmin() {
		return idadmin;
	}

	public void setIdadmin(int idadmin) {
		this.idadmin = idadmin;
	}

	public String getEmailAdmin() {
		return emailAdmin;
	}

	public void setEmailAdmin(String emailAdmin) {
		this.emailAdmin = emailAdmin;
	}

	public String getMdpAdmin() {
		return mdpAdmin;
	}

	public void setMdpAdmin(String mdpAdmin) {
		this.mdpAdmin = mdpAdmin;
	}

	public String getNomAdmin() {
		return nomAdmin;
	}

	public void setNomAdmin(String nomAdmin) {
		this.nomAdmin = nomAdmin;
	}
	
	
}
