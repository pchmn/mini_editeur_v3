package command;

import receiver.MoteurEditionInterface;

/**
 * Commande Copier
 * 
 * @author Clément G., Paul C.
 */
public class Copier implements Command{

	public MoteurEditionInterface moteurEditionInterface;
	
	/**
	 * Constructeur
	 * @param moteurEditionInterface
	 */
	public Copier(MoteurEditionInterface moteurEditionInterface){
		this.moteurEditionInterface = moteurEditionInterface;
	}

	/**
	 * Exécute la commande
	 */
	public void execute() {
		moteurEditionInterface.copier();
	}
}
