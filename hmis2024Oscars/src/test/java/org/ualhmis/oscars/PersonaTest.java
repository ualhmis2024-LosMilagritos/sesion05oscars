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
	
	@Test
	void testEqualsPersona() {
		Persona p1 = new Persona (null, null, null);
		Persona p2 = new Persona ("Pepe", "h", "01/01/2000");
		Persona p3 = new Persona ("Laura", "m", null);
		Persona p4 = new Persona (null, "m", null);
		
		assertFalse(p1.equals(p2));
		assertFalse(p2.equals(p1));
		
		assertFalse(p1.equals(p3));
		assertFalse(p3.equals(p1));
		
		assertFalse(p1.equals(p4));
		assertFalse(p4.equals(p1));
	}
	
	@Test
	void testHashCode() {
		 // Crear objetos con mismos valores deben tener el mismo hashCode
        Persona persona1 = new Persona("Juan", "M", "01-01-1990");
        Persona persona2 = new Persona("Juan", "M", "01-01-1990");
        
        assertEquals(persona1.hashCode(), persona2.hashCode());

        // Crear objetos con valores diferentes deben tener hashCode diferente
        Persona persona3 = new Persona("Maria", "F", "15-03-1985");
        assertNotEquals(persona1.hashCode(), persona3.hashCode());

        // Crear objetos con campos nulos deben tener hashCode válido
        Persona persona4 = new Persona(null, null, null);
        Persona persona5 = new Persona(null,  null, null);
        
        assertEquals(persona4.hashCode(), persona5.hashCode());
	}
	
	@Test
	void testPersonas() {
		Persona p1 = new Persona ("Pepe", "h", "01/01/2000");
		assertEquals("Pepe", p1.getNombre());
		assertEquals("h", p1.getSexo());
		assertEquals("01/01/2000",p1.getFechaNacimiento());
	}
	
	
	
	@Test
	void testPersonasCine() {
		Actriz actriz1 = new Actriz(null,null,null);
		Actor actor1 = new Actor(null,null,null);
		ActorOActriz aoa1 = new ActorOActriz(null,null,null);
		Director d1 = new Director(null,null,null);
		
		assertEquals(null, actriz1.getNombre());
		assertEquals(null, actor1.getNombre());
		assertEquals(null, aoa1.getNombre());
		assertEquals(null, d1.getNombre());
	}
}
