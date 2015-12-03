package receiver;


/**
 * Cette classe gère le mini éditeur
 * Elle gère les modifications apportées au buffer et au presse papier
 * 
 * @author Clément G., Paul C.
 */
public class MoteurEdition implements MoteurEditionInterface
{
	public Buffer buffer;
	
	public PressePapier pressePapier;
	
	public Selection selection;
	
	/**
	 * Constructeur 
	 */
	public MoteurEdition(){
		this.buffer = new Buffer();
		this.pressePapier = new PressePapier();
		this.selection = new Selection();
	}
	
	/**
	 * Constructeur
	 * @param buffer
	 * @param pressePapier
	 * @param selection
	 */
	public MoteurEdition(Buffer buffer, PressePapier pressePapier, Selection selection) {
		this.buffer = buffer;
		this.pressePapier = pressePapier;
		this.selection = selection;
	}
	
	/**
	 * Retourne le contenu du buffer sous forme plus lisible
	 * @return String
	 */
	public String getContent(){
		return this.buffer.getContenu().toString() + " (longueur : " + this.buffer.getContenu().toString().length() + ")";
	}
	
	
	public String getSelection() {
		int debut = this.selection.getDebut();
		int fin = this.selection.getLongueur() + debut + 1;
		
		StringBuffer newText = new StringBuffer();
		newText.append(this.buffer.getContenu().toString());
		try {
			newText.insert(debut, "[");
			newText.insert(fin, "]");
		} catch (Exception e) {
			System.out.println(e + "\n");
			newText.append(this.buffer.getContenu().toString());
			newText.insert(newText.toString().length(), "[");
			newText.insert(newText.toString().length(), "]");
		}
		
		return newText.toString() + " (longueur : " + this.buffer.getContenu().toString().length() + ")";
		//return this.selection.getContenu();
	}
	
	
	/**
	 * Exécute la commande copier
	 * La sélection est mise dans le presse papier
	 */
	public void copier() {
		this.pressePapier.setContenu(this.selection.getContenu());
	}
	
	/**
	 * Exécute la commande Saisir
	 * Le texte saisi est mis dans le buffer en prenant en compte la sélection actuelle
	 * La sélection est ensuite réinitalisée, et mise à la fin du contenu du buffer
	 */
	public void saisir(StringBuffer texte) {
		int debut = 0;
		int longueur = 0;
		StringBuffer newText = new StringBuffer();
		
		if(this.buffer.getContenu().toString() == "") {
			this.buffer.setContenu(texte);
		}
		else {
			debut = this.selection.getDebut();
			longueur = this.selection.getLongueur();
			
			if(longueur == 0) {
				newText = this.buffer.getContenu().insert(debut, texte.toString());
				this.buffer.setContenu(newText);
			}
			else {
				newText = this.buffer.getContenu().replace(debut, debut + longueur, texte.toString());
				this.buffer.setContenu(newText);
				
			}
			
		}
		
		this.selection.setDebut(debut + texte.toString().length());
		this.selection.setLongueur(0);
		this.selection.setContenu("");
	}
	
	/**
	 * Exécute la commande Coller
	 * Le contenu du presse papier est coller dans le contenu fu buffer
	 * en prenant en compte la sélection actuelle
	 * La sélection est ensuite mise à la suite du texte collé
	 */
	public void coller() {
		int debut = this.selection.getDebut();
		int fin = this.selection.getLongueur() + debut;
		String pressPapier = this.pressePapier.getContenu();
		
		
		StringBuffer newBuffer = this.buffer.getContenu().replace(debut, fin, pressPapier);
		
		this.buffer.setContenu(newBuffer);
		
		this.selection = new Selection(debut + pressPapier.length());
	}
	
	/**
	 * Exécute la commande Selectionner
	 * Met à jour le début, la longueur et le contenu de la sélection
	 */
	public void selectionner(int debut, int longueur) {	
		try {
			this.selection.setDebut(debut);
			this.selection.setLongueur(longueur);
			this.selection.setContenu(this.buffer.getContenu().substring(debut, debut + longueur));
		} catch (Exception e) {
			System.out.println("\nVotre sélection dépasse la longueur du texte.\nLa sélection est mise à la fin du texte.");
			this.selection.setDebut(this.buffer.getContenu().toString().length());
			this.selection.setLongueur(0);
			this.selection.setContenu("");
		}
	}
	
	/**
	 * Exécute la commande Couper
	 * La sélection est mise dans le presse papier
	 * La sélection est supprimée du contenu du buffer
	 * La sélection est réinitalisée
	 */
	public void couper() {
		this.pressePapier.setContenu(this.selection.getContenu());
		
		int debut = this.selection.getDebut();
		int fin = this.selection.getLongueur() + debut;
		
		StringBuffer newBuffer = this.buffer.getContenu().delete(debut, fin);
		
		this.selection.setLongueur(0);
		this.selection.setContenu("");
		
		this.buffer.setContenu(newBuffer);
	}
}

