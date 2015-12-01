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
			MementoMoteurEdition cloneEtatMoteur = new MementoMoteurEdition(etatMoteur);
			System.out.println("bufferClone : " + cloneEtatMoteur.getBuffer().getContenu().toString());
			// TODO aller à cet état
			etatMoteur.getMoteur().restaurer(etatMoteur);
			this.refaire.push(cloneEtatMoteur);
			System.out.println("bufferClone - refaire : " + this.refaire.get(0).getBuffer().getContenu().toString());
		}
	}
	
	public void refaire() {
		if(this.refaire.isEmpty()) {
			
		}
		else {
			MementoMoteurEdition etatMoteur = this.refaire.pop();
			System.out.println("buffer : " + etatMoteur.getBuffer().getContenu().toString());
			MementoMoteurEdition cloneEtatMoteur = new MementoMoteurEdition(etatMoteur);
			etatMoteur.getMoteur().restaurer(etatMoteur);
			this.defaire.push(cloneEtatMoteur);
		}
	}
	
}
