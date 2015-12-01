package command;

import receiver.MoteurEditionInterface;

/**
 * Commande Coller
 * 
 * @author Clément G., Paul C.
 */
public class Coller implements Command{

	public MoteurEditionInterface moteurEditionInterface;
	
	/**
	 * Constructeur
	 * @param moteurEditionInterface
	 */
	public Coller(MoteurEditionInterface moteurEditionInterface){
		this.moteurEditionInterface = moteurEditionInterface;
	}

	/**
	 * Exécute la commande
	 */
	public void execute() {
		moteurEditionInterface.coller();
	}
}
