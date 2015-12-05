package memento;

import receiver.Buffer;
import receiver.MoteurEditionEnregistrable;
import receiver.PressePapier;
import receiver.Selection;

/**
 * Memento MoteurEdition <br>
 * Il enregistre le buffer, le presse papier, la sélection
 * 
 * @author Clément G., Paul C.
 */
public class MementoMoteurEdition implements Memento {

	private Buffer buffer;
	private PressePapier pressePapier;
	private Selection selection;
	private MoteurEditionEnregistrable moteur;
	
	/**
	 * Constructeur
	 * @param buffer
	 * @param pressePapier
	 * @param selection
	 * @param moteur
	 */
	public MementoMoteurEdition(Buffer buffer, PressePapier pressePapier, Selection selection, MoteurEditionEnregistrable moteur) {
		this.buffer = buffer;
		this.pressePapier = pressePapier;
		this.selection = selection;
		this.moteur = moteur;
	}
	
	/**
	 * Constructeur permettant d'éviter les références
	 * @param bufferTexte
	 * @param pressePapierTexte
	 * @param debutSelection
	 * @param longueurSelection
	 * @param contenuSelection
	 * @param moteur
	 */
	public MementoMoteurEdition(String bufferTexte, String pressePapierTexte, int debutSelection, int longueurSelection, String contenuSelection, MoteurEditionEnregistrable moteur) {
		StringBuffer sb = new StringBuffer(bufferTexte);
		this.buffer = new Buffer(sb);
		this.pressePapier = new PressePapier(pressePapierTexte);
		this.selection = new Selection(debutSelection, longueurSelection, contenuSelection);
		this.moteur = moteur;
	}
	
	/**
	 * Constructeur permettant de créer un clone d'un MementoMoteurEdition
	 * @param m
	 */
	public MementoMoteurEdition(MementoMoteurEdition m) {
		StringBuffer sb = new StringBuffer(m.getBuffer().getContenu().toString());
		this.buffer = new Buffer(sb);
		this.pressePapier = new PressePapier(m.getPressePapier().getContenu());
		this.selection = new Selection(m.getSelection().getDebut(), m.getSelection().getLongueur(), m.getSelection().getContenu());
		this.moteur = m.getMoteur();
	}

	/**
	 * 
	 * @return Buffer
	 */
	public Buffer getBuffer() {
		return this.buffer;
	}

	/**
	 * 
	 * @param buffer
	 */
	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}

	/**
	 * 
	 * @return PressePapier
	 */
	public PressePapier getPressePapier() {
		return this.pressePapier;
	}

	/**
	 * 
	 * @param pressePapier
	 */
	public void setPressePapier(PressePapier pressePapier) {
		this.pressePapier = pressePapier;
	}

	/**
	 * 
	 * @return Selection
	 */
	public Selection getSelection() {
		return this.selection;
	}

	/**
	 * 
	 * @param selection
	 */
	public void setSelection(Selection selection) {
		this.selection = selection;
	}
	
	/**
	 * Retourne le moteur
	 * @return MoteurEditionEnregistrable
	 */
	public MoteurEditionEnregistrable getMoteur() {
		return moteur;
	}
	
}
