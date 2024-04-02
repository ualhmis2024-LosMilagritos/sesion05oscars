package org.ualhmis.oscars;

import java.util.ArrayList;
import java.util.List;

//Clase Premio
class Premio {
private String nombre;
private List<Pelicula> nominadas;
private Pelicula ganadora;

public Premio(String nombre) {
   this.nombre = nombre;
   this.nominadas = new ArrayList<>();
}

public String getNombre() {
   return nombre;
}

public List<Pelicula> getNominadas() {
   return nominadas;
}

public Pelicula getGanadora() {
   return ganadora;
}

public void addNominada(Pelicula pelicula) {
   nominadas.add(pelicula);
}

public void setGanadora(Pelicula pelicula) {
   ganadora = pelicula;
}
}

