package org.ualhmis.oscars;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

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

}
