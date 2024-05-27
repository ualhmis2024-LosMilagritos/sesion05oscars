package org.ualhmis.oscars;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonaTest {

	@Test
	void testEqualsObject() {
		Persona p1 = new Persona("Lucia", "f", "02/02/1990");
		Persona p2 = new Persona("Lucia", "f", "02/02/1990");
		Persona p3 = p1; 
		Persona p4 = null; 
		Persona p5 = new Persona(null, null, null);
		Persona p6 = new Persona("Carlos", "m", "15/07/1985");
		Persona p7 = new Persona("Paula", null, null);
		Persona p8 = new Persona("Paula", "f", null);
		Persona p9 = new Persona(null, "f", "15/07/1985");
		Persona p10 = new Persona(null, "f", "15/07/1985");
		Persona p11 = new Persona("Manuel", "m", "02/02/1990");
		Persona p12 = new Persona("Manuel", null, "02/02/1990");
		Director d1 = new Director("Director", "m", "02/02/1990");
		Pelicula peli1 = new Pelicula("Pelicula1", d1);
		Persona p13 = new Persona("Paula", "m", null);
		Persona p14 = new Persona("Paula", null, null);
		Persona p15 = new Persona("Paula", null, "15/07/1985");
		Persona p16 = new Persona("Paula", "m", "15/07/1985");
		Persona p17 = new Persona("Paula", null, "15/07/1985");
		Persona p18 = new Persona("Paula", null, "15/07/1985");

		assertFalse(p1.equals(p11));
		assertFalse(p1.equals(p4));
		assertFalse(p8.equals(p1));
		assertFalse(p11.equals(p12));
		assertFalse(p1.equals(p8));
		assertFalse(p6.equals(p1));
		
		assertFalse(p1.equals(p9));
		assertFalse(p5.equals(p1));
		assertTrue(p1.equals(p2));
		assertFalse(p5.equals(p8));
		assertFalse(p7.equals(p1));
		assertFalse(p1.equals(p7));
		assertFalse(p1.equals(p5));
		
		assertFalse(p16.equals(p15)); // Caso inverso
		assertFalse(p5.equals(p7));
		assertFalse(p12.equals(p11));
		
		assertFalse(p15.equals(p16)); // Sexo es null en uno y no en otro
		assertFalse(p14.equals(p13)); // Caso inverso
		assertFalse(p13.equals(p14)); // Caso en el que sexo de uno es null y el otro no
		
		assertFalse(p9.equals(p1));
		assertTrue(p9.equals(p10));
		assertFalse(p1.equals(peli1));
		assertFalse(p6.equals(p1));
		assertEquals(false, p1.equals(p4), "El parametro no es null.");
		
		assertTrue(p1.equals(p3));
		assertTrue(p17.equals(p18)); // Ambos sexos son null
	}
	
	@Test
	void testGetNombre() {
		Persona p1 = new Persona("Lucia", "f", "02/02/1990");
		assertEquals(p1.getNombre(), "Lucia");
	}
	
	@Test
	void testGetSexo() {
		Persona p1 = new Persona("Lucia", "f", "02/02/1990");
		assertEquals(p1.getSexo(), "f");
	}
	
	@Test
	void testGetNacimiento() {
		Persona p1 = new Persona("Lucia", "f", "02/02/1990");
		assertEquals(p1.getFechaNacimiento(), "02/02/1990");
	}
	
	@Test
	void testHash() {
		Persona p1 = new Persona("Lucia", "f", "02/02/1990");
		Persona p2 = new Persona("Lucia", "f", "02/02/1990");
		Persona p3 = new Persona(null, null, null);
		assertEquals(p1.hashCode(), p2.hashCode());
		assertNotEquals(p1.hashCode(), p3.hashCode());
	}
}
