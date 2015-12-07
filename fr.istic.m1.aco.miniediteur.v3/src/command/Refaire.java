package command;

import memento.EnregistreurV3;

/**
 * Commande permettant d'aller à l'état suivant
 * 
 * @author Clément G., Paul C.
 */
public class Refaire implements Command {

	private EnregistreurV3 enregistreur;
	
	/**
	 * Constructeur
	 * @param enregistreur
	 */
	public Refaire(EnregistreurV3 enregistreur) {
		this.enregistreur = enregistreur;
	}

	/**
	 * Exécute la commande
	 */
	public void execute() {
		this.enregistreur.refaire();
	}
}
