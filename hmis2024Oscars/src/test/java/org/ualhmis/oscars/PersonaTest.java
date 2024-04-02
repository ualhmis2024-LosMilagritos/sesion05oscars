package org.ualhmis.oscars;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonaTest {

	@Test
	void testEqualsObject() {
		Persona p1 = new Persona ("Pepe", "h", "01/01/2000");
		Persona p2 = new Persona ("Pepe", "h", "01/01/2000");
		Persona p3 = p1; 
		Persona p4 = null; 
		Director d1 = new Director ("Dire", "m", "01/01/2000");
		Pelicula peli1 = new Pelicula("Maven mola !!!", d1);
		
		assertTrue(p1.equals(p2));
		assertTrue(p1.equals(p3));
		assertFalse(p1.equals(p4));
		assertEquals(false, p1.equals(p4), "El parametro no es null.");
		
		assertFalse (p1.equals(peli1));
		
	}

}
