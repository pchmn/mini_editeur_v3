package command;

import receiver.MoteurEditionInterface;
import invoker.IHMInterface;

/**
 * Commande Sélectionner
 * 
 * @author Clément G., Paul C.
 */
public class Selectionner implements Command{

	public MoteurEditionInterface moteurEditionInterface;
	
	public IHMInterface ihm;

	/**
	 * Constructeur vide
	 */
	public Selectionner(){
		super();
	}
	
	/**
	 * Constructeur
	 * @param moteur
	 * @param ihm
	 */
	public Selectionner(MoteurEditionInterface moteur, IHMInterface ihm){
		this.moteurEditionInterface = moteur;
		this.ihm = ihm;
	}
	
	/**
	 * Récupère le début et la longueur de la sélection saisis dans l'ihm
	 * Exécute ensuite la commande avec ces paramètres
	 */
	public void execute(){
		
		int debut = ihm.getDebut();
		int longueur = ihm.getLongueur();
		
		moteurEditionInterface.selectionner(debut, longueur);
		
	}
}
