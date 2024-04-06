package org.ualhmis.oscars;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GestorPremiosTest {

    private final static Director director = new Director("Peter Jackson","Hombre","31/10/1961");
    private final static Pelicula pelicula = new Pelicula("El Señor de los Anillos: el retorno del Rey",director);
    private final static String premio = "Mejor Banda sonora";
    private final static PrintStream originalOut = System.out;
    private final static ByteArrayOutputStream bos = new ByteArrayOutputStream();
    private final static GestorPremios gP = new GestorPremios();

    @BeforeAll
    static void setUp(){
        System.setOut(new PrintStream(bos));
        gP.crearPremio("Mejor Película");
    }

    @AfterEach
    void  cleanSyso(){
        // undo the binding in System
        System.setOut(originalOut);
    }

    @Test
    void testNominarPelicula() {
        // action
        gP.nominarPelicula(premio,pelicula);

        // assertion
        String salida = "El premio '" + premio + "' no existe.";
        assertEquals(salida + System.lineSeparator(), bos.toString(), "La salida por consola no es exactamente igual a la esperada.");

    }
    @Test
    void  testAsignarGanadora(){
        gP.asignarGanadora(premio,pelicula);

        // assertion
        String salida = "El premio '" + premio + "' no existe.";
        assertEquals(salida + System.lineSeparator(), bos.toString(), "La salida por consola no es exactamente igual a la esperada.");
    }
}
