package receiver;

/**
 * Cette classe représente la sélection du contenu du buffer
 * 
 * @author Clément G., Paul C.
 */
public class Selection {
	
	private String contenu;
	
	private int debut;
	
	private int longueur;

	private TestMoteurEdition moteurEdition;
	
	/**
	 * Retourne le début de la sélection
	 * @return Integer
	 */
	public int getDebut() {
		return debut;
	}

	/**
	 * Met à jour le début de la sélection
	 * @param debut
	 */
	public void setDebut(int debut) {
		this.debut = debut;
	}

	/**
	 * Retourne la longueur de la sélection
	 * @return Integer
	 */
	public int getLongueur() {
		return longueur;
	}

	/**
	 * Met à jour la longueur de la sélection
	 * @param longueur
	 */
	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	/**
	 * Retourne le contenu de la sélection
	 * @return String
	 */
	public String getContenu() {
		return contenu;
	}

	/**
	 * Met à jour le contenu de la sélecion
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
	public Selection(){
		super();
	}
	
	/**
	 * Constructeur
	 * @param debut
	 */
	public Selection(int debut){
		this.debut = debut;
		this.longueur = 0;
		this.contenu = "";
	}
	
	/**
	 * Constructeur
	 * @param debut
	 * @param longueur
	 * @param contenu
	 */
	public Selection(int debut, int longueur, String contenu){
		this.debut = debut;
		this.longueur = longueur;
		this.contenu = contenu;
	}
}
