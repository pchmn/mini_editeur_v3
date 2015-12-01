package command;

import receiver.MoteurEditionInterface;


/**
 * Commande Couper
 * 
 * @author Clément G., Paul C.
 */
public class Couper implements Command
{	
	public MoteurEditionInterface moteurEditionInterface;
	
	/**
	 * Constructeur
	 * @param moteurEditionInterface
	 */
	public Couper(MoteurEditionInterface moteurEditionInterface){
		this.moteurEditionInterface = moteurEditionInterface;
	}

	/**
	 * Exécute la commande
	 */
	public void execute() {
		moteurEditionInterface.couper();
	}
}

