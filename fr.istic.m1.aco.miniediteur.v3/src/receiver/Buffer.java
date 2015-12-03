package receiver;


/**
 * Cette classe est un buffer qui contient le texte du mini éditeur
 * 
 * @author Clément G., Paul C.
 */
public class Buffer
{
	private StringBuffer contenu;
	
	private TestMoteurEdition testMoteurEdition;
	
	/**
	 * Retourne le contenu du buffer
	 * @return StringBuffer
	 */
	public StringBuffer getContenu() {
		return this.contenu;
	}

	/**
	 * Met à jour le contenu du buffer
	 * @param contenu
	 */
	public void setContenu(StringBuffer contenu) {
		this.contenu = contenu;
	}

	/**
	 * 
	 * @return TestMoteurEdition
	 */
	public TestMoteurEdition getMoteurEdition() {
		return this.testMoteurEdition;
	}

	/**
	 * 
	 * @param moteurEdition
	 */
	public void setMoteurEdition(TestMoteurEdition moteurEdition) {
		this.testMoteurEdition = moteurEdition;
	}

	/**
	 * Constructeur
	 */
	public Buffer(){
		this.contenu = new StringBuffer();
	}
	
	/**
	 * Constructeur
	 * @param sb
	 */
	public Buffer(StringBuffer sb) {
		this.contenu = sb;
	}
	
}

