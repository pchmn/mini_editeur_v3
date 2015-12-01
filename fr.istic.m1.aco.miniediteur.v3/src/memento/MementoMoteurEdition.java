package memento;

import receiver.Buffer;
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
	
	public MementoMoteurEdition(Buffer buffer, PressePapier pressePapier, Selection selection) {
		this.buffer = buffer;
		this.pressePapier = pressePapier;
		this.selection = selection;
	}
	
	public MementoMoteurEdition(String bufferTexte, String pressePapierTexte, int debutSelection, int longueurSelection, String contenuSelection) {
		StringBuffer sb = new StringBuffer(bufferTexte);
		this.buffer = new Buffer(sb);
		this.pressePapier = new PressePapier(pressePapierTexte);
		this.selection = new Selection(debutSelection, longueurSelection, contenuSelection);
	}

	public Buffer getBuffer() {
		return buffer;
	}

	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}

	public PressePapier getPressePapier() {
		return pressePapier;
	}

	public void setPressePapier(PressePapier pressePapier) {
		this.pressePapier = pressePapier;
	}

	public Selection getSelection() {
		return selection;
	}

	public void setSelection(Selection selection) {
		this.selection = selection;
	}
	
	
}
