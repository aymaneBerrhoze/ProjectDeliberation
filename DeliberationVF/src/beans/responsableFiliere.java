package beans;

public class responsableFiliere {
	private int idresponsablefiliere;
	private String emailRF;
	private String mdpRF;
	
	public responsableFiliere() {
		super();
	}
	public responsableFiliere(int idresponsablefiliere, String emailRF, String mdpRF) {
		super();
		this.idresponsablefiliere = idresponsablefiliere;
		this.emailRF = emailRF;
		this.mdpRF = mdpRF;
	}
	
	public int getIdresponsablefiliere() {
		return idresponsablefiliere;
	}
	public void setIdresponsablefiliere(int idresponsablefiliere) {
		this.idresponsablefiliere = idresponsablefiliere;
	}
	public String getEmailRF() {
		return emailRF;
	}
	public void setEmailRF(String emailRF) {
		this.emailRF = emailRF;
	}
	public String getMdpRF() {
		return mdpRF;
	}
	public void setMdpRF(String mdpRF) {
		this.mdpRF = mdpRF;
	}
	
	
	
	
}
