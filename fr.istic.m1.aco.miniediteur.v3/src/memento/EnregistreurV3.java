package memento;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import command.Command;
import receiver.MoteurEditionEnregistrable;

public class EnregistreurV3 {

	private Stack<MementoMoteurEdition> defaire;
	private Stack<MementoMoteurEdition> refaire;
	
	public EnregistreurV3(Stack<MementoMoteurEdition> defaire, Stack<MementoMoteurEdition> refaire) {
		this.defaire = defaire;
		this.refaire = refaire;
	}
	
	public EnregistreurV3() {
		this.defaire = new Stack<MementoMoteurEdition>();
		this.refaire = new Stack<MementoMoteurEdition>();
	}

	public void enregistrer(MementoMoteurEdition m) {
		this.defaire.add(m);
	}
	
	public void defaire() {
		if(this.defaire.isEmpty()) {
			
		}
		else {
			MementoMoteurEdition etatMoteur = this.defaire.pop();
			// on envoit l'état actuel dans la pile defaire
			MementoMoteurEdition cloneEtatMoteur = etatMoteur.getMoteur().setMemento();
			this.refaire.push(cloneEtatMoteur);
			// on restaure l'état
			etatMoteur.getMoteur().restaurer(etatMoteur);
			System.out.println("taille pile defaire : " + this.defaire.size());
			System.out.println("taille pile refaire : " + this.refaire.size());
		}
	}
	
	public void refaire() {
		if(this.refaire.isEmpty()) {
			
		}
		else {
			MementoMoteurEdition etatMoteur = this.refaire.pop();
			// on envoit l'état actuel dans refaire
			MementoMoteurEdition cloneEtatMoteur = etatMoteur.getMoteur().setMemento();
			this.defaire.push(cloneEtatMoteur);
			// on restaure l'état
			etatMoteur.getMoteur().restaurer(etatMoteur);
		}
	}
	
}
