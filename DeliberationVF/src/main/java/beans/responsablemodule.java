package beans;

public class responsablemodule {
	private int idresponsablemodule;
	private String emailM;
	private String mdpM;
	
	
	public responsablemodule() {
		super();
	}


	public responsablemodule(int idresponsablemodule, String emailM, String mdpM) {
		super();
		this.idresponsablemodule = idresponsablemodule;
		this.emailM = emailM;
		this.mdpM = mdpM;
	}


	public int getIdresponsablemodule() {
		return idresponsablemodule;
	}


	public void setIdresponsablemodule(int idresponsablemodule) {
		this.idresponsablemodule = idresponsablemodule;
	}


	public String getEmailM() {
		return emailM;
	}


	public void setEmailM(String emailM) {
		this.emailM = emailM;
	}


	public String getMdpM() {
		return mdpM;
	}


	public void setMdpM(String mdpM) {
		this.mdpM = mdpM;
	}
	

	


}
