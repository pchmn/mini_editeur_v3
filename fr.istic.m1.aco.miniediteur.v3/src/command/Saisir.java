package command;

import receiver.MoteurEditionInterface;
import invoker.IHMInterface;

/**
 * Commande Saisir
 * 
 * @author Clément G., Paul C.
 */
public class Saisir implements Command
{
	public MoteurEditionInterface moteurEditionInterface;

	public IHMInterface ihm;
	
	/**
	 * Constructeur vide
	 */
	public Saisir(){
		super();
	}
	
	/**
	 * Constructeur
	 * @param moteurEdition
	 * @param ihm
	 */
	public Saisir(MoteurEditionInterface moteurEdition, IHMInterface ihm){
		this.moteurEditionInterface = moteurEdition;
		this.ihm = ihm;
	}

	/**
	 * Récupére le texte saisi dans l'ihm <br>
	 * Exécute ensuite la commande avec ce texte
	 */
	public void execute() {	
		StringBuffer texte = ihm.getTexte();
		moteurEditionInterface.saisir(texte);
	}
}

