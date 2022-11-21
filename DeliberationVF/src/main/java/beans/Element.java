package beans;

public class Element {

	private int idElement;
	private String LibelleElement;
	private String CodeElement;
	private int idModule;
	
	public Element() {
		super();
	}

	public Element(int idElement, String libelleElement, String codeElement) {
		super();
		this.idElement = idElement;
		LibelleElement = libelleElement;
		CodeElement = codeElement;
	}

	public int getIdElement() {
		return idElement;
	}

	public void setIdElement(int idElement) {
		this.idElement = idElement;
	}

	public String getLibelleElement() {
		return LibelleElement;
	}

	public void setLibelleElement(String libelleElement) {
		LibelleElement = libelleElement;
	}

	public String getCodeElement() {
		return CodeElement;
	}

	public void setCodeElement(String codeElement) {
		CodeElement = codeElement;
	}

	public int getIdModule() {
		return idModule;
	}

	public void setIdModule(int idModule) {
		this.idModule = idModule;
	}
	
	
	
}
