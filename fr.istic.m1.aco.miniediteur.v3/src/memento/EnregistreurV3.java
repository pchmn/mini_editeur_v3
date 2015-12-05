package memento;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import command.Command;
import receiver.MoteurEditionEnregistrable;

/**
 * Cette classe permet d'enregistrer chaque état du moteur <br>
 * Ensuite elle permet de revenir à un état précédent ou d'aller à un état suivant
 * 
 * @author Clément G., Paul C.
 */
public class EnregistreurV3 {

	private Stack<MementoMoteurEdition> defaire;
	private Stack<MementoMoteurEdition> refaire;
	
	/**
	 * Constructeur
	 * @param defaire
	 * @param refaire
	 */
	public EnregistreurV3(Stack<MementoMoteurEdition> defaire, Stack<MementoMoteurEdition> refaire) {
		this.defaire = defaire;
		this.refaire = refaire;
	}
	
	/**
	 * Constructeur vide
	 */
	public EnregistreurV3() {
		this.defaire = new Stack<MementoMoteurEdition>();
		this.refaire = new Stack<MementoMoteurEdition>();
	}

	/**
	 * Ajoute le memento du Moteur à la pile défaire
	 * @param m
	 */
	public void enregistrer(MementoMoteurEdition m) {
		this.defaire.add(m);
	}
	
	/**
	 * Revient à l'état précédent
	 */
	public void defaire() {
		if(this.defaire.isEmpty()) {
			System.out.println("\nIl n'y a pas d'état précédent");
		}
		else {
			// on récupère l'état précédent
			MementoMoteurEdition etatMoteur = this.defaire.pop();
			
			// on envoie l'état actuel dans la pile refaire
			MementoMoteurEdition cloneEtatMoteur = etatMoteur.getMoteur().setMemento();
			this.refaire.push(cloneEtatMoteur);
			
			// on restaure l'état précédent
			etatMoteur.getMoteur().restaurer(etatMoteur);
		}
	}
	
	/**
	 * Va à l'état suivant
	 */
	public void refaire() {
		if(this.refaire.isEmpty()) {
			System.out.println("\nIl n'y a pas d'état suivant");
		}
		else {
			// on récupère l'état suivant
			MementoMoteurEdition etatMoteur = this.refaire.pop();
			
			// on envoit l'état actuel dans la pile defaire
			MementoMoteurEdition cloneEtatMoteur = etatMoteur.getMoteur().setMemento();
			this.defaire.push(cloneEtatMoteur);
			
			// on "restaure" l'état suivant
			etatMoteur.getMoteur().restaurer(etatMoteur);
		}
	}
	
}
