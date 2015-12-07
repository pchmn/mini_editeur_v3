package memento;

import command.Command;
import command.Defaire;
import command.Refaire;
import junit.framework.TestCase;
import receiver.MoteurEditionEnregistrable;

public class TestEnregistreurV3 extends TestCase {

	/**
	 * --- Enregistrer ---
	 */
	// Test si le memento est bien ajouté à la pile défaire
	// Et que l'état du moteur a bien été enregistré
	public void testEnregistrer() {
		EnregistreurV3 enregistreur = new EnregistreurV3();
		MoteurEditionEnregistrable moteur = new MoteurEditionEnregistrable(enregistreur);
		
		moteur.enregistrer();
		
		MementoMoteurEdition m = enregistreur.getDefaire().peek();
		
		assertEquals(m.getMoteur(), moteur);
	}

	/**
	 * --- Defaire ---
	 */
	// Test si la commande defaire revient bien à l'état précédent
	public void testDefaire() {
		EnregistreurV3 enregistreur = new EnregistreurV3();
		MoteurEditionEnregistrable moteur = new MoteurEditionEnregistrable(enregistreur);
		
		StringBuffer sb = new StringBuffer("Bonjour");
		moteur.saisir(sb);
		moteur.selectionner(0, 3);
		
		Command cmd = new Defaire(enregistreur);
		
		assertEquals(moteur.selection.getContenu(), "Bon");
		// 1er defaire
		cmd.execute();
		assertEquals(moteur.selection.getContenu(), "");
		// 2e defaire
		cmd.execute();
		assertEquals(moteur.buffer.getContenu().toString(), "");
	}
	
	// Test si le memento est bien transféré de la pile defaire à la pile refaire
	public void testDefaire2() {
		EnregistreurV3 enregistreur = new EnregistreurV3();
		MoteurEditionEnregistrable moteur = new MoteurEditionEnregistrable(enregistreur);
		
		StringBuffer sb = new StringBuffer("Bonjour");
		moteur.saisir(sb);
		
		MementoMoteurEdition m1 = enregistreur.getDefaire().peek().getMoteur().setMemento();
		MementoMoteurEdition m2;
		
		Command cmd = new Defaire(enregistreur);
		// defaire
		cmd.execute();
		m2 = enregistreur.getRefaire().peek();
		assertTrue(mementoEquals(m1, m2));
	}

	/**
	 * --- Refaire ---
	 */
	// Test si la commande defaire va bien à l'état suivant
	public void testRefaire() {
		EnregistreurV3 enregistreur = new EnregistreurV3();
		MoteurEditionEnregistrable moteur = new MoteurEditionEnregistrable(enregistreur);
		
		StringBuffer sb = new StringBuffer("Bonjour");
		moteur.saisir(sb);
		
		Command cmdD = new Defaire(enregistreur);
		Command cmdR = new Refaire(enregistreur);
		
		// defaire
		cmdD.execute();
		assertEquals(moteur.buffer.getContenu().toString(), "");
		// refaire
		cmdR.execute();
		assertEquals(moteur.buffer.getContenu().toString(), "Bonjour");
		
	}
	
	// Test si le memento est bien transféré de la pile refaire à la pile defaire
	public void testRefaire2() {
		EnregistreurV3 enregistreur = new EnregistreurV3();
		MoteurEditionEnregistrable moteur = new MoteurEditionEnregistrable(enregistreur);
		
		StringBuffer sb = new StringBuffer("Bonjour");
		moteur.saisir(sb);
		
		MementoMoteurEdition m1;
		MementoMoteurEdition m2;
		
		Command cmdD = new Defaire(enregistreur);
		Command cmdR = new Refaire(enregistreur);
		
		// defaire
		cmdD.execute();
		m1 = enregistreur.getRefaire().peek().getMoteur().setMemento();
		// refaire
		cmdR.execute();
		m2 = enregistreur.getDefaire().peek();
		assertTrue(mementoEquals(m1, m2));
		
		
	}
	
	// teste si deux mementos sont égaux.
	public boolean mementoEquals(MementoMoteurEdition m1, MementoMoteurEdition m2) {
		if(!m1.getBuffer().getContenu().toString().equals(m2.getBuffer().getContenu().toString())) {
			return false;
		}
		if(!m1.getPressePapier().getContenu().equals(m2.getPressePapier().getContenu())) {
			return false;
		}
		if(m1.getSelection().getDebut() != m2.getSelection().getDebut() ||
		   m1.getSelection().getLongueur() != m2.getSelection().getLongueur() ||
		   m1.getSelection().getContenu() != (m2.getSelection().getContenu())		
		) {
			return false;
		}
		return true;
	}
	

}
