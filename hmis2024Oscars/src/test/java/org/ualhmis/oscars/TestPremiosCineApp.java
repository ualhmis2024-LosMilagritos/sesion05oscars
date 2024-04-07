package org.ualhmis.oscars;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

class TestPremiosCineApp {

	@Test
	void testMainMethod() {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));

		// action
		PremiosCineApp p = new PremiosCineApp(); // Para llegar al 100%: creacion de objeto y llamada al constructor por defecto 
		PremiosCineApp.main(null);

		// assertion
		String salida = "La película ganadora del Oscar a la Mejor Película es: Inception";
		assertEquals(salida + System.lineSeparator(), bos.toString(), "La salida por consola no es exactamente igual a la esperada.");

		// undo the binding in System
		System.setOut(originalOut);
	}

	@Test
	void testPremios() {
		Pelicula pelicula1 = new Pelicula("Pelicula test1", new Director("Peter Jackson","Hombre","31/10/1961"));
		Pelicula pelicula2 = new Pelicula("Pelicula test2", new Director("Peter Jackson","Hombre","31/10/1961"));

		Premio p1 =  new Premio("Mejor Reparto");
		p1.addNominada(pelicula1);
		p1.addNominada(pelicula2);
		p1.setGanadora(pelicula1);


		assertEquals("Mejor Reparto", p1.getNombre());
		assertEquals(2, p1.getNominadas().size());
	}

	  @Test
	  public void testNominarPelicula_PremioNoExistente() {
	        // Configuración inicial
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(outputStream));
	        GestorPremios gestorPremios = new GestorPremios();

	        // Act: Intentar nominar una película a un premio que no existe
	        gestorPremios.nominarPelicula("Mejor Director", new Pelicula("Parasite", new Director("Bong Joon-ho", "Hombre", "14/09/1969")));

	        // Verificar que el premio no se agregó al mapa
	        assertFalse(gestorPremios.getPremios().containsKey("Mejor Director"));

	        // Verificar mensaje de error impreso
	        String expectedOutput = "El premio 'Mejor Director' no existe.";
	        String actualOutput = outputStream.toString().trim(); // Limpiar espacios en blanco alrededor
	        assertTrue(actualOutput.contains(expectedOutput), "El mensaje de error no coincide. Actual: " + actualOutput);
	    }

	    @Test
	    public void testAsignarGanadora_PremioNoExistente() {
	        // Configuración inicial
	    	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        System.setOut(new PrintStream(outputStream));
	        GestorPremios gestorPremios = new GestorPremios();

	        // Act: Intentar nominar una película a un premio que no existe
	        gestorPremios.asignarGanadora("Mejor Director", new Pelicula("Parasite", new Director("Bong Joon-ho", "Hombre", "14/09/1969")));

	        // Verificar que el premio no se agregó al mapa
	        assertFalse(gestorPremios.getPremios().containsKey("Mejor Director"));

	        // Verificar mensaje de error impreso
	        String expectedOutput = "El premio 'Mejor Director' no existe.";
	        String actualOutput = outputStream.toString().trim(); // Limpiar espacios en blanco alrededor
	        assertTrue(actualOutput.contains(expectedOutput), "El mensaje de error no coincide. Actual: " + actualOutput);
	    }

}
