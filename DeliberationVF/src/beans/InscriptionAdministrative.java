package beans;

public class InscriptionAdministrative {

	private int idIA;
	private String MassarEtud;
	private String Nom;
	private String Prenom;
	private String Diplome;
	private String Annee;
	private String AdressePersonnelle;
	private String Ville;
	private String Telephone;
	private String AdresseEmail;
	private String AdresseParents;
	private String DateInscription;
	private String Bourse;
	private String Filiere;
	private int idFiliere;
	
	public InscriptionAdministrative() {
		super();
	}

	public InscriptionAdministrative(int idIA, String massarEtud, String nom, String prenom, String diplome,
			String annee, String adressePersonnelle, String ville, String telephone, String adresseEmail,
			String adresseParents, String dateInscription, String bourse, String filiere, int idFiliere) {
		super();
		this.idIA = idIA;
		MassarEtud = massarEtud;
		Nom = nom;
		Prenom = prenom;
		Diplome = diplome;
		Annee = annee;
		AdressePersonnelle = adressePersonnelle;
		Ville = ville;
		Telephone = telephone;
		AdresseEmail = adresseEmail;
		AdresseParents = adresseParents;
		DateInscription = dateInscription;
		Bourse = bourse;
		Filiere = filiere;
		this.idFiliere = idFiliere;
	}

	public int getIdIA() {
		return idIA;
	}

	public void setIdIA(int idIA) {
		this.idIA = idIA;
	}

	public String getMassarEtud() {
		return MassarEtud;
	}

	public void setMassarEtud(String massarEtud) {
		MassarEtud = massarEtud;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getDiplome() {
		return Diplome;
	}

	public void setDiplome(String diplome) {
		Diplome = diplome;
	}

	public String getAnnee() {
		return Annee;
	}

	public void setAnnee(String annee) {
		Annee = annee;
	}

	public String getAdressePersonnelle() {
		return AdressePersonnelle;
	}

	public void setAdressePersonnelle(String adressePersonnelle) {
		AdressePersonnelle = adressePersonnelle;
	}

	public String getVille() {
		return Ville;
	}

	public void setVille(String ville) {
		Ville = ville;
	}

	public String getTelephone() {
		return Telephone;
	}

	public void setTelephone(String telephone) {
		Telephone = telephone;
	}

	public String getAdresseEmail() {
		return AdresseEmail;
	}

	public void setAdresseEmail(String adresseEmail) {
		AdresseEmail = adresseEmail;
	}

	public String getAdresseParents() {
		return AdresseParents;
	}

	public void setAdresseParents(String adresseParents) {
		AdresseParents = adresseParents;
	}

	public String getDateInscription() {
		return DateInscription;
	}

	public void setDateInscription(String dateInscription) {
		DateInscription = dateInscription;
	}

	public String getBourse() {
		return Bourse;
	}

	public void setBourse(String bourse) {
		Bourse = bourse;
	}

	public String getFiliere() {
		return Filiere;
	}

	public void setFiliere(String filiere) {
		Filiere = filiere;
	}

	public int getIdFiliere() {
		return idFiliere;
	}

	public void setIdFiliere(int idFiliere) {
		this.idFiliere = idFiliere;
	}
	
	
	
}
