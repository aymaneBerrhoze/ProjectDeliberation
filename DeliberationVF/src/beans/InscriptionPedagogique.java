package beans;

public class InscriptionPedagogique {
	
	private int idIP;
	private int idIA;
	private int idFiliere;
	private String MassarEtud;
	private int IDEtape;
	private int IDSemestre;
	private int IDModule;
	
	public InscriptionPedagogique() {
		super();
		// TODO Auto-generated constructor stub
	}


	public InscriptionPedagogique(int idIP, int idIA, int idFiliere, String massarEtud, int iDEtape, int iDSemestre,
			int iDModule) {
		super();
		this.setIdIP(idIP);
		this.setIdIA(idIA);
		this.setIdFiliere(idFiliere);
		MassarEtud = massarEtud;
		IDEtape = iDEtape;
		IDSemestre = iDSemestre;
		IDModule = iDModule;
	}





	public String getMassarEtud() {
		return MassarEtud;
	}

	public void setMassarEtud(String MassarEtud) {
		this.MassarEtud = MassarEtud;
	}

	public int getIDEtape() {
		return IDEtape;
	}

	public void setIDEtape(int iDEtape) {
		IDEtape = iDEtape;
	}

	public int getIDSemestre() {
		return IDSemestre;
	}

	public void setIDSemestre(int iDSemestre) {
		IDSemestre = iDSemestre;
	}

	public int getIDModule() {
		return IDModule;
	}

	public void setIDModule(int iDModule) {
		IDModule = iDModule;
	}


	public int getIdIP() {
		return idIP;
	}


	public void setIdIP(int idIP) {
		this.idIP = idIP;
	}


	public int getIdIA() {
		return idIA;
	}


	public void setIdIA(int idIA) {
		this.idIA = idIA;
	}


	public int getIdFiliere() {
		return idFiliere;
	}


	public void setIdFiliere(int idFiliere) {
		this.idFiliere = idFiliere;
	}

	
	
}
