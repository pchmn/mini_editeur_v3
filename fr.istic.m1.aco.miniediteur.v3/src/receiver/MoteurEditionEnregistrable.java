package receiver;

import memento.EnregistreurV3;
import memento.MementoMoteurEdition;

public class MoteurEditionEnregistrable extends MoteurEdition {
	
	private EnregistreurV3 enregistreur;

	/**
	 * Constructeur
	 * @param enregistreur
	 */
	public MoteurEditionEnregistrable(EnregistreurV3 enregistreur) {
		super();
		this.enregistreur = enregistreur;
	}

	/**
	 * Constructeur
	 * @param buffer
	 * @param pressePapier
	 * @param selection
	 * @param enregistreur
	 */
	public MoteurEditionEnregistrable(Buffer buffer, PressePapier pressePapier, Selection selection, EnregistreurV3 enregistreur) {
		super(buffer, pressePapier, selection);
		this.enregistreur = enregistreur;
	}
	
	/**
	 * Constructeur permettant de créer un clone d'un MoteurEditionEnregistrable
	 * @param moteur
	 */
	public MoteurEditionEnregistrable(MoteurEditionEnregistrable moteur) {
		StringBuffer sb = new StringBuffer(moteur.buffer.getContenu().toString());
		this.buffer = new Buffer(sb);
		this.pressePapier = new PressePapier(moteur.pressePapier.getContenu());
		this.selection = new Selection(moteur.selection.getDebut(), moteur.selection.getLongueur(), moteur.getContent());
		this.enregistreur = moteur.getEnregistreur();
	}
	
	/**
	 * 
	 * @return EnregistreurV3
	 */
	public EnregistreurV3 getEnregistreur() {
		return enregistreur;
	}

	/**
	 * Enregistre l'état actuel du moteur 
	 * grâce à un MementoMoteurEdition
	 */
	public void enregistrer() {
		MementoMoteurEdition m = setMemento();
		this.enregistreur.enregistrer(m);
	}
	
	/**
	 * Crée le MementoMoteurEdition <br>
	 * En y enregistrant le buffer, le presse papier, et la sélection actuels
	 * @return MementoMoteurEdition
	 */
	public MementoMoteurEdition setMemento() {
		String bufferTexte = this.buffer.getContenu().toString();
		String pressePapierTexte = this.pressePapier.getContenu();
		int debutSelection = this.selection.getDebut();
		int longueurSelection = this.selection.getLongueur();
		String contenuSelection = this.selection.getContenu();
		return new MementoMoteurEdition(bufferTexte, pressePapierTexte, debutSelection, longueurSelection, contenuSelection, this);
	}

	/**
	 * Restaure un état selon un MementoMoteurEdition donné
	 * @param m
	 */
	public void restaurer(MementoMoteurEdition m) {
		this.buffer = m.getBuffer();
		this.pressePapier = m.getPressePapier();
		this.selection = m.getSelection();
	}
	
	@Override
	public void copier() {
		// enregistre l'état du moteur
		this.enregistrer();
		// exécute la commande
		super.copier();
	}
	
	@Override
	public void saisir(StringBuffer texte) {
		// enregistre l'état du moteur
		this.enregistrer();
		// exécute la commande
		super.saisir(texte);
	}
	
	@Override
	public void coller() {
		// enregistre l'état du moteur
		this.enregistrer();
		//exécute la commande
		super.coller();	
	}
	
	@Override
	public void selectionner(int debut, int longueur) {
		// enregistre l'état du moteur
		this.enregistrer();
		// exécute la commande
		super.selectionner(debut, longueur);
	}
	
	@Override
	public void couper() {
		// enregistre l'état du moteur
		this.enregistrer();
		// exécute la commande
		super.couper();
	}
}
