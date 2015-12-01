package memento;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import command.Command;
import receiver.MoteurEditionEnregistrable;

public class EnregistreurV3 {

	private Stack<MoteurEditionEnregistrable> defaire;
	private Stack<MoteurEditionEnregistrable> refaire;
	
	public EnregistreurV3(Stack<MoteurEditionEnregistrable> defaire, Stack<MoteurEditionEnregistrable> refaire) {
		this.defaire = defaire;
		this.refaire = refaire;
	}
	
	public EnregistreurV3() {
		this.defaire = new Stack<MoteurEditionEnregistrable>();
		this.refaire = new Stack<MoteurEditionEnregistrable>();
	}

	public void enregistrer(MoteurEditionEnregistrable m) {
		this.defaire.add(m);
	}
	
	public void defaire() {
		if(this.defaire.isEmpty()) {
			
		}
		else {
			MoteurEditionEnregistrable etatMoteur = this.defaire.pop();
			// TODO aller à cet état
			etatMoteur.restaurer();
			this.refaire.push(etatMoteur);
		}
	}
	
	public void refaire() {
		if(this.defaire.isEmpty()) {
			
		}
		else {
			MoteurEditionEnregistrable etatMoteur = this.defaire.pop();
			etatMoteur.restaurer();
			this.defaire.push(etatMoteur);
		}
	}
	
}
