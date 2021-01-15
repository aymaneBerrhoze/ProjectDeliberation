package beans;

public class InscriptionEnLigne {

	private String MassarEtud;
	private String NomFr;
	private String PrenomFr;
	private String NomAr;
	private String PrenomAr;
	private String Sexe;
	private String DateDeNaissance;
	private String LieuDeNaissance;
	private String LieuDeNaissanceAR;
	private String CIN;
	private String Nationalite;
	private String Ville;
	private String Province;
	private String AnneeBac;
	private String SerieBac;
	private String MentionBac;
	private String LyceeBac;
	private String VilleBac;
	private String Academie;
	private String Date1ereInscription;
	
	public InscriptionEnLigne() {
		super();
	}

	public InscriptionEnLigne(String massarEtud, String nomFr, String prenomFr, String nomAr, String prenomAr,
			String sexe, String dateDeNaissance, String lieuDeNaissance, String lieuDeNaissanceAR, String cIN,
			String nationalite, String Ville, String province, String anneeBac, String serieBac,
			String mentionBac, String lyceeBac, String villeBac, String academie, String date1ereInscription) {
		super();
		MassarEtud = massarEtud;
		NomFr = nomFr;
		PrenomFr = prenomFr;
		NomAr = nomAr;
		PrenomAr = prenomAr;
		Sexe = sexe;
		DateDeNaissance = dateDeNaissance;
		LieuDeNaissance = lieuDeNaissance;
		LieuDeNaissanceAR = lieuDeNaissanceAR;
		CIN = cIN;
		Nationalite = nationalite;
		this.Ville = Ville;
		Province = province;
		AnneeBac = anneeBac;
		SerieBac = serieBac;
		MentionBac = mentionBac;
		LyceeBac = lyceeBac;
		VilleBac = villeBac;
		Academie = academie;
		Date1ereInscription = date1ereInscription;
	}

	public String getMassarEtud() {
		return MassarEtud;
	}

	public void setMassarEtud(String massarEtud) {
		MassarEtud = massarEtud;
	}

	public String getNomFr() {
		return NomFr;
	}

	public void setNomFr(String nomFr) {
		NomFr = nomFr;
	}

	public String getPrenomFr() {
		return PrenomFr;
	}

	public void setPrenomFr(String prenomFr) {
		PrenomFr = prenomFr;
	}

	public String getNomAr() {
		return NomAr;
	}

	public void setNomAr(String nomAr) {
		NomAr = nomAr;
	}

	public String getPrenomAr() {
		return PrenomAr;
	}

	public void setPrenomAr(String prenomAr) {
		PrenomAr = prenomAr;
	}

	public String getSexe() {
		return Sexe;
	}

	public void setSexe(String sexe) {
		Sexe = sexe;
	}

	public String getDateDeNaissance() {
		return DateDeNaissance;
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		DateDeNaissance = dateDeNaissance;
	}

	public String getLieuDeNaissance() {
		return LieuDeNaissance;
	}

	public void setLieuDeNaissance(String lieuDeNaissance) {
		LieuDeNaissance = lieuDeNaissance;
	}

	public String getLieuDeNaissanceAR() {
		return LieuDeNaissanceAR;
	}

	public void setLieuDeNaissanceAR(String lieuDeNaissanceAR) {
		LieuDeNaissanceAR = lieuDeNaissanceAR;
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cIN) {
		CIN = cIN;
	}

	public String getNationalite() {
		return Nationalite;
	}

	public void setNationalite(String nationalite) {
		Nationalite = nationalite;
	}

	public String getVille() {
		return Ville;
	}

	public void setVille(String Ville) {
		this.Ville = Ville;
	}

	public String getProvince() {
		return Province;
	}

	public void setProvince(String province) {
		Province = province;
	}

	public String getAnneeBac() {
		return AnneeBac;
	}

	public void setAnneeBac(String anneeBac) {
		AnneeBac = anneeBac;
	}

	public String getSerieBac() {
		return SerieBac;
	}

	public void setSerieBac(String serieBac) {
		SerieBac = serieBac;
	}

	public String getMentionBac() {
		return MentionBac;
	}

	public void setMentionBac(String mentionBac) {
		MentionBac = mentionBac;
	}

	public String getLyceeBac() {
		return LyceeBac;
	}

	public void setLyceeBac(String lyceeBac) {
		LyceeBac = lyceeBac;
	}

	public String getVilleBac() {
		return VilleBac;
	}

	public void setVilleBac(String villeBac) {
		VilleBac = villeBac;
	}

	public String getAcademie() {
		return Academie;
	}

	public void setAcademie(String academie) {
		Academie = academie;
	}

	public String getDate1ereInscription() {
		return Date1ereInscription;
	}

	public void setDate1ereInscription(String date1ereInscription) {
		Date1ereInscription = date1ereInscription;
	}
	
	
}
