package command;

import memento.EnregistreurV3;

/**
 * Commande permettant de revenir à l'état précédent
 * 
 * @author Clément G., Paul C.
 */
public class Defaire implements Command {

	private EnregistreurV3 enregistreur;
	
	/**
	 * Constructeur
	 * @param enregistreur
	 */
	public Defaire(EnregistreurV3 enregistreur) {
		this.enregistreur = enregistreur;
	}

	/**
	 * Exécute la commande
	 */
	public void execute() {
		this.enregistreur.defaire();
	}

}
