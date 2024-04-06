package org.ualhmis.oscars;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PeliculaTest {
    Pelicula pelicula = new Pelicula("Pelicula test",
            new Director("Peter Jackson","Hombre","31/10/1961"));

    @Test
    void getDirector(){


        Director director = new Director("Peter Jackson","Hombre","31/10/1961");

        assertEquals(director,pelicula.getDirector());
    }

    @Test
    void  getProtagonistaTest(){
        Actriz actriz = new Actriz("Jennifer Lawrence","Mujer","15/8/1990");
        Actor actor = new Actor("Josh Hutcherson","Hombre"," 12/10/1992");
        pelicula.setActrizProtagonista(actriz);
        pelicula.setActorProtagonista(actor);

        assertEquals(actriz,pelicula.getActrizProtagonista());
    }

    @Test
    void getActoresSecundariosTest(){
        Actor actor = new Actor("Dominic Monaghan","Hombre","8/12/1976");
        Actriz actriz = new Actriz("Liv Tyler","Mujer","1/7/1977");
        List<Actor> actoresSecundarios = new ArrayList<>();
        actoresSecundarios.add(actor);

        pelicula.addActorSecundario(actor);
        pelicula.addActrizSecundaria(actriz);

        assertEquals(actoresSecundarios,pelicula.getActoresSecundarios());
    }

    @Test
    void getActricesSecundariasTest(){
        Actor actor = new Actor("Dominic Monaghan","Hombre","8/12/1976");
        Actriz actriz = new Actriz("Liv Tyler","Mujer","1/7/1977");
        List<Actriz> actricesSecundarias = new ArrayList<>();
        actricesSecundarias.add(actriz);

        pelicula.addActorSecundario(actor);
        pelicula.addActrizSecundaria(actriz);

        assertEquals(actricesSecundarias,pelicula.getActricesSecundarias());
    }

}
