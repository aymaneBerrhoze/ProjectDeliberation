package beans;

//import java.io.InputStream;
import java.sql.Blob;

public class User {

	private int idUser;
	private String nomU;
	private String prenomU;
	private String natureUser;
	private String emailU;
	private String mdpU;
	private Blob imageU;
	private String EncodedPhoto;
	
	public User() {
		super();
	}

	public User(int idUser, String nomU, String prenomU, String natureUser) {
		super();
		this.idUser = idUser;
		this.nomU = nomU;
		this.prenomU = prenomU;
		this.natureUser = natureUser;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getNomU() {
		return nomU;
	}

	public void setNomU(String nomU) {
		this.nomU = nomU;
	}

	public String getPrenomU() {
		return prenomU;
	}

	public void setPrenomU(String prenomU) {
		this.prenomU = prenomU;
	}

	public String getNatureUser() {
		return natureUser;
	}

	public void setNatureUser(String natureUser) {
		this.natureUser = natureUser;
	}

	public String getEmailU() {
		return emailU;
	}

	public void setEmailU(String emailU) {
		this.emailU = emailU;
	}

	public String getMdpU() {
		return mdpU;
	}

	public void setMdpU(String mdpU) {
		this.mdpU = mdpU;
	}

	public Blob getImage() {
		return imageU;
	}

	public void setImage(Blob imageU) {
		this.imageU = imageU;
	}

	public String getEncodedPhoto() {
		return EncodedPhoto;
	}

	public void setEncodedPhoto(String encodedPhoto) {
		EncodedPhoto = encodedPhoto;
	}

	public Blob getImageU() {
		return imageU;
	}

	public void setImageU(Blob imageU) {
		this.imageU = imageU;
	}
	
	
	
}
