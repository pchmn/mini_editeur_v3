package receiver;

import memento.EnregistreurV3;
import memento.MementoMoteurEdition;

public class MoteurEditionEnregistrable extends MoteurEdition {
	
	private EnregistreurV3 enregistreur;
	private MementoMoteurEdition m;

	public MoteurEditionEnregistrable(EnregistreurV3 enregistreur) {
		super();
		this.enregistreur = enregistreur;
	}
	
	public MoteurEditionEnregistrable(Buffer buffer, PressePapier pressePapier, Selection selection, EnregistreurV3 enregistreur) {
		super(buffer, pressePapier, selection);
		this.enregistreur = enregistreur;
	}
	
	public void enregistrer() {
		this.setMemento();
		this.enregistreur.enregistrer(this);
	}
	
	public void setMemento() {
		String bufferTexte = this.buffer.getContenu().toString();
		String pressePapierTexte = this.pressePapier.getContenu();
		int debutSelection = this.selection.getDebut();
		int longueurSelection = this.selection.getLongueur();
		String contenuSelection = this.selection.getContenu();
		this.m = new MementoMoteurEdition(bufferTexte, pressePapierTexte, debutSelection, longueurSelection, contenuSelection);
	}

	public void restaurer() {
		this.buffer = this.m.getBuffer();
		this.pressePapier = this.m.getPressePapier();
		this.selection = this.m.getSelection();
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
