package receiver;

import junit.framework.TestCase;

public class TestPressePapier extends TestCase {

	public void testGetContenu() {
		PressePapier pressePapier = new PressePapier("Bonjour");
		assertEquals("Bonjour", pressePapier.getContenu());
	}

	public void testSetContenu() {
		PressePapier pressePapier = new PressePapier();
		pressePapier.setContenu("Bonjour");
		assertEquals("Bonjour", pressePapier.getContenu());
	}

	public void testGetMoteurEdition() {
		fail("Not yet implemented");
	}

	public void testSetMoteurEdition() {
		fail("Not yet implemented");
	}

	public void testPressePapier() {
		PressePapier pressePapier = new PressePapier();
		assertEquals("", pressePapier.getContenu());
	}

}
