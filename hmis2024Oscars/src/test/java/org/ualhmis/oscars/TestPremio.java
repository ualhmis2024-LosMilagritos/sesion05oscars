package org.ualhmis.oscars;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestPremio {
	@Test
	void testGetNombre() {
		Premio p1 = new Premio("Mejor Película");
		assertEquals(p1.getNombre(), "Mejor Película");
	}
	
	@Test
	void testGetNominadas() {
		Premio p1 = new Premio("Mejor Director");
		p1.addNominada(new Pelicula("Inception", null));
	    p1.addNominada(new Pelicula("The Dark Knight", null));
	    
		Premio p2 = new Premio("Mejor Actriz");
		p2.addNominada(new Pelicula("Black Swan", null));
	    p2.addNominada(new Pelicula("La La Land", null));
		assertEquals(p1.getNominadas().get(0).getTitulo(), "Inception");
		assertEquals(p1.getNominadas().get(1).getTitulo(), "The Dark Knight");
		assertEquals(p2.getNominadas().get(0).getTitulo(), "Black Swan");
		assertEquals(p2.getNominadas().get(1).getTitulo(), "La La Land");
	}
}
