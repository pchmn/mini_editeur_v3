package memento;

import receiver.Buffer;
import receiver.MoteurEditionEnregistrable;
import receiver.PressePapier;
import receiver.Selection;

/**
 * Memento MoteurEdition
 * 
 * @author Clément G., Paul C.
 */
public class MementoMoteurEdition implements Memento {

	private Buffer buffer;
	private PressePapier pressePapier;
	private Selection selection;
	
	public MoteurEditionEnregistrable getMoteur() {
		return moteur;
	}

	private MoteurEditionEnregistrable moteur;
	
	public MementoMoteurEdition(Buffer buffer, PressePapier pressePapier, Selection selection, MoteurEditionEnregistrable moteur) {
		this.buffer = buffer;
		this.pressePapier = pressePapier;
		this.selection = selection;
		this.moteur = moteur;
	}
	
	public MementoMoteurEdition(String bufferTexte, String pressePapierTexte, int debutSelection, int longueurSelection, String contenuSelection, MoteurEditionEnregistrable moteur) {
		StringBuffer sb = new StringBuffer(bufferTexte);
		this.buffer = new Buffer(sb);
		this.pressePapier = new PressePapier(pressePapierTexte);
		this.selection = new Selection(debutSelection, longueurSelection, contenuSelection);
		this.moteur = moteur;
	}
	
	public MementoMoteurEdition(MementoMoteurEdition m) {
		StringBuffer sb = new StringBuffer(m.getBuffer().getContenu().toString());
		this.buffer = new Buffer(sb);
		this.pressePapier = new PressePapier(m.getPressePapier().getContenu());
		this.selection = new Selection(m.getSelection().getDebut(), m.getSelection().getLongueur(), m.getSelection().getContenu());
		this.moteur = m.getMoteur();
	}

	public Buffer getBuffer() {
		return this.buffer;
	}

	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}

	public PressePapier getPressePapier() {
		return this.pressePapier;
	}

	public void setPressePapier(PressePapier pressePapier) {
		this.pressePapier = pressePapier;
	}

	public Selection getSelection() {
		return this.selection;
	}

	public void setSelection(Selection selection) {
		this.selection = selection;
	}
	
	
}
