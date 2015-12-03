package receiver;

import junit.framework.TestCase;

public class TestMoteurEdition extends TestCase {

	public void testMoteurEdition() {
		MoteurEdition moteurEdition = new MoteurEdition();

		assertEquals(moteurEdition.buffer instanceof Buffer, true);
		assertEquals(moteurEdition.pressePapier instanceof PressePapier, true);
		assertEquals(moteurEdition.selection instanceof Selection, true);
	}

	public void testCopier() {
		MoteurEdition moteurEdition = new MoteurEdition();
		moteurEdition.selection.setContenu("Bonjour");
		
		moteurEdition.copier();
		
		assertEquals("Bonjour", moteurEdition.pressePapier.getContenu());
	}

	/**
	 * Pour une premiere saisie
	 */
	public void testSaisir1() {
		MoteurEdition moteurEdition = new MoteurEdition();
		StringBuffer texte = new StringBuffer("Bonjour");
		moteurEdition.saisir(texte);
		
		assertEquals(texte.toString(), moteurEdition.buffer.getContenu().toString());
	}
	
	/**
	 * Deux saisies à la suite
	 */
	public void testSaisir2() {
		MoteurEdition moteurEdition = new MoteurEdition();
		StringBuffer texte = new StringBuffer("Bonjour");
		moteurEdition.saisir(texte);
		
		moteurEdition.saisir(texte);
		
		assertEquals("BonjourBonjour", moteurEdition.buffer.getContenu().toString());
	}

	/**
	 * Test d'un coller normal
	 */
	public void testColler1() {
		MoteurEdition moteurEdition = new MoteurEdition();
		moteurEdition.pressePapier.setContenu("Bonjour");
		
		moteurEdition.coller();
		StringBuffer expected = new StringBuffer("Bonjour");
		
		assertEquals(expected.toString(), moteurEdition.buffer.getContenu().toString());
	}
	
	/**
	 * Test la selection apres coller
	 */
	public void testColler2() {
		MoteurEdition moteurEdition = new MoteurEdition();
		moteurEdition.pressePapier.setContenu("Bonjour");
		
		moteurEdition.coller();
		
		assertEquals("", moteurEdition.selection.getContenu().toString());
		assertEquals(7, moteurEdition.selection.getDebut());
	}

	/**
	 * Test une selection normal
	 */
	public void testSelectionner1() {
		MoteurEdition moteurEdition = new MoteurEdition();
		StringBuffer texte = new StringBuffer("Bonjour");
		moteurEdition.buffer.setContenu(texte);
		
		moteurEdition.selectionner(0, 3);
		
		assertEquals("Bon", moteurEdition.selection.getContenu());
	}
	
	/**
	 * Test selection at the start of the buffer
	 */
	public void testSelectionner2() {
		MoteurEdition moteurEdition = new MoteurEdition();
		StringBuffer texte = new StringBuffer("Bonjour");
		moteurEdition.buffer.setContenu(texte);
		
		moteurEdition.selectionner(0, 0);
		
		assertEquals("", moteurEdition.selection.getContenu());
	}
	
	/**
	 * Test selection on null
	 */
	public void testSelectionner3() {
		MoteurEdition moteurEdition = new MoteurEdition();
		StringBuffer texte = new StringBuffer("Bonjour");
		moteurEdition.buffer.setContenu(texte);
		
		moteurEdition.selectionner(9, 2);
		
		assertEquals("", moteurEdition.selection.getContenu());
	}

	/**
	 * Test if the pressPapier is well set with the Couper
	 */
	public void testCouper1() {
		MoteurEdition moteurEdition = new MoteurEdition();
		moteurEdition.selection.setContenu("Bonjour");
		
		moteurEdition.couper();
		
		assertEquals("", moteurEdition.buffer.getContenu().toString());
		assertEquals("Bonjour", moteurEdition.pressePapier.getContenu());
	}
	
	
	/**
	 * Test if the selection is well set after a Couper
	 */
	public void testCouper2(){
		MoteurEdition moteurEdition = new MoteurEdition();
		StringBuffer texte = new StringBuffer("Bonjour toto");
		
		moteurEdition.buffer.setContenu(texte);
		
		moteurEdition.selection.setContenu(" toto");
		moteurEdition.selection.setDebut(7);
		moteurEdition.selection.setLongueur(5);
		
		moteurEdition.couper();
		
		assertEquals("Bonjour", moteurEdition.buffer.getContenu().toString());
		assertEquals(0, moteurEdition.selection.getLongueur());
	}

}
