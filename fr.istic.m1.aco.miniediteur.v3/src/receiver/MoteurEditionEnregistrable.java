package receiver;

import memento.EnregistreurV3;
import memento.MementoMoteurEdition;

public class MoteurEditionEnregistrable extends MoteurEdition {
	
	private EnregistreurV3 enregistreur;

	public MoteurEditionEnregistrable(EnregistreurV3 enregistreur) {
		super();
		this.enregistreur = enregistreur;
	}

	public MoteurEditionEnregistrable(Buffer buffer, PressePapier pressePapier, Selection selection, EnregistreurV3 enregistreur) {
		super(buffer, pressePapier, selection);
		this.enregistreur = enregistreur;
	}
	
	public MoteurEditionEnregistrable(MoteurEditionEnregistrable moteur) {
		StringBuffer sb = new StringBuffer(moteur.buffer.getContenu().toString());
		this.buffer = new Buffer(sb);
		this.pressePapier = new PressePapier(moteur.pressePapier.getContenu());
		this.selection = new Selection(moteur.selection.getDebut(), moteur.selection.getLongueur(), moteur.getContent());
		this.enregistreur = moteur.getEnregistreur();
	}
	
	public EnregistreurV3 getEnregistreur() {
		return enregistreur;
	}

	public void enregistrer() {
		MementoMoteurEdition m = setMemento();
		this.enregistreur.enregistrer(m);
	}
	
	public MementoMoteurEdition setMemento() {
		String bufferTexte = this.buffer.getContenu().toString();
		String pressePapierTexte = this.pressePapier.getContenu();
		int debutSelection = this.selection.getDebut();
		int longueurSelection = this.selection.getLongueur();
		String contenuSelection = this.selection.getContenu();
		return new MementoMoteurEdition(bufferTexte, pressePapierTexte, debutSelection, longueurSelection, contenuSelection, this);
	}

	public void restaurer(MementoMoteurEdition m) {
		this.buffer = m.getBuffer();
		this.pressePapier = m.getPressePapier();
		this.selection = m.getSelection();
	}
	
	@Override
	public void copier() {
		this.enregistrer();
		super.copier();
		// enregistre l'état du moteur
		
	}
	
	@Override
	public void saisir(StringBuffer texte) {
		this.enregistrer();
		super.saisir(texte);
		// enregistre l'état du moteur
		
	}
	
	@Override
	public void coller() {
		this.enregistrer();
		super.coller();
		// enregistre l'état du moteur
		
	}
	
	@Override
	public void selectionner(int debut, int longueur) {
		this.enregistrer();
		super.selectionner(debut, longueur);
		// enregistre l'état du moteur
		
	}
	
	@Override
	public void couper() {
		this.enregistrer();
		super.couper();
		// enregistre l'état du moteur
		
	}
}
