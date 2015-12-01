package receiver;



/**
 * Cette classe est le presse papier du mini éditeur
 * 
 * @author Clément G., Paul C.
 */
public class PressePapier
{
	private String contenu;	

	private TestMoteurEdition moteurEdition;
	
	/**
	 * Retourne le contenu du presse papier
	 * @return String
	 */
	public String getContenu() {
		return contenu;
	}

	/**
	 * Met à jour le contenu du presse papier
	 * @param contenu
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	/**
	 * 
	 * @return TestMoteurEdition
	 */
	public TestMoteurEdition getMoteurEdition() {
		return moteurEdition;
	}

	/**
	 * 
	 * @param moteurEdition
	 */
	public void setMoteurEdition(TestMoteurEdition moteurEdition) {
		this.moteurEdition = moteurEdition;
	}

	/**
	 * Constructeur
	 */
	public PressePapier(){
		this.contenu = "";
	}
	
	/**
	 * Constructeur
	 * @param contenu
	 */
	public PressePapier(String contenu){
		this.contenu = contenu;
	}
}

