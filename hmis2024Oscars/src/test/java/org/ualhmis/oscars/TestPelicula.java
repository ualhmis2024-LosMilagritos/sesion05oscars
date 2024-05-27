package org.ualhmis.oscars;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestPelicula {
	
	@Test
	void testGetDirector() {
		Director d1 = new Director("Quentin Tarantino", "h", "27/03/1963");
		Pelicula peli1 = new Pelicula("Pulp Fiction", d1);
		assertEquals(peli1.getDirector().getNombre(), "Quentin Tarantino");
	}
	
	@Test
	void testGetActorProtagonista() {
		Actor ap1 = new Actor("Leonardo DiCaprio", "h", "11/11/1974");
		Director d1 = new Director("Martin Scorsese", "h", "17/11/1942");
		Pelicula peli1 = new Pelicula("The Wolf of Wall Street", d1);
		peli1.setActorProtagonista(ap1);
		assertEquals(peli1.getActorProtagonista().getNombre(), "Leonardo DiCaprio");
	}
	
	@Test
	void testGetActrizProtagonista() {
		Actriz ap1 = new Actriz("Scarlett Johansson", "m", "22/11/1984");
		Director d1 = new Director("Woody Allen", "h", "01/12/1935");
		Pelicula peli1 = new Pelicula("Match Point", d1);
		peli1.setActrizProtagonista(ap1);
		assertEquals(peli1.getActrizProtagonista().getNombre(), "Scarlett Johansson");
	}
	
	@Test
	void testGetActoresSecundarios() {
		Actor as1 = new Actor("Brad Pitt", "h", "18/12/1963");
		Actor as2 = new Actor("Edward Norton", "h", "18/08/1969");
		Director d1 = new Director("David Fincher", "h", "28/08/1962");
		Pelicula peli1 = new Pelicula("Fight Club", d1);
		peli1.addActorSecundario(as1);
		peli1.addActorSecundario(as2);
		
		Actor as3 = new Actor("Hugh Jackman", "h", "12/10/1968");
		Director d2 = new Director("Christopher Nolan", "h", "30/07/1970");
		Pelicula peli2 = new Pelicula("The Prestige", d2);
	    peli2.addActorSecundario(as3);
	    
		assertEquals(peli1.getActoresSecundarios().get(0).getNombre(), "Brad Pitt");
		assertEquals(peli1.getActoresSecundarios().get(1).getNombre(), "Edward Norton");
		assertEquals(peli2.getActoresSecundarios().get(0).getNombre(), "Hugh Jackman");
	}
	
	@Test
	void testGetActricesSecundarias() {
		Actriz as1 = new Actriz("Margot Robbie", "m", "02/07/1990");
		Director d1 = new Director("Quentin Tarantino", "h", "27/03/1963");
		Pelicula peli1 = new Pelicula("Once Upon a Time in Hollywood", d1);
		peli1.addActrizSecundaria(as1);
		
		Actriz as2 = new Actriz("Nicole Kidman", "m", "20/06/1967");
		Director d2 = new Director("Baz Luhrmann", "h", "17/09/1962");
		Pelicula peli2 = new Pelicula("Moulin Rouge!", d2);
	    peli2.addActrizSecundaria(as2);
	    
		assertEquals(peli1.getActricesSecundarias().get(0).getNombre(), "Margot Robbie");
		assertEquals(peli2.getActricesSecundarias().get(0).getNombre(), "Nicole Kidman");
	}
}
