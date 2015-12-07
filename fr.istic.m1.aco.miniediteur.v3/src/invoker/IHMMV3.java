package invoker;

import client.EditeurV3;
import command.Command;

/**
 * Classe IHM pour la version 3
 * 
 * @author Clément G., Paul C.
 */
public class IHMMV3 implements IHMInterface {
	
	public Command commande;
	
	public EditeurV3 editeur;
	
	/**
	 * Constructeur
	 */
	public IHMMV3() {
		this.editeur = new EditeurV3();
	}
	
	/**
	 * Impression des commandes possibles
	 */
	public void menu(){
		System.out.println("Sélectionner l'action désirée : ");
		System.out.println(" - Saisir (W)");
		System.out.println(" - Copier (C)");
		System.out.println(" - Coller (P)");
		System.out.println(" - Couper (X)");
		System.out.println(" - Sélectionner (S)");
		System.out.println(" - Défaire (D)");
		System.out.println(" - Refaire (R)");
		System.out.println(" - Quitter (Q) ");		
	}
	
	/**
	 * Retourne le texte saisi
	 * @return StringBuffer
	 */
	public StringBuffer getTexte(){
		StringBuffer texte = editeur.getTexte();
		return texte;		
	}
	
	/**
	 * Retourne le début de la sélection saisi
	 * @return Integer
	 */
	public int getDebut(){
		return editeur.getDebut();
	}
	
	/**
	 * Retourne la longueur de la sélection saisie
	 * @return Integer
	 */
	public int getLongueur(){
		return editeur.getLongueur();
	}	
}
