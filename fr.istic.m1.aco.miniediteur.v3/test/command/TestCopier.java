package command;

import junit.framework.TestCase;
import receiver.MoteurEdition;

public class TestCopier extends TestCase {

	public void testCopier() {
		fail("Not yet implemented");
	}

	public void testExecute() {

		MoteurEdition moteur = new MoteurEdition();
		moteur.selection.setContenu("Bonjour");
		
		Copier copier = new Copier(moteur);	
		copier.execute();
		
		assertEquals(moteur.selection.getContenu(), moteur.pressePapier.getContenu());
	}

}
