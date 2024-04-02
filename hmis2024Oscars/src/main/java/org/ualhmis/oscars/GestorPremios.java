package org.ualhmis.oscars;

import java.util.HashMap;
import java.util.Map;

//Clase para gestionar los premios
class GestorPremios {
	private Map<String, Premio> premios;

	public GestorPremios() {
		this.premios = new HashMap<>();
	}
	
	
	public Map<String, Premio> getPremios() {
		return premios;
	}


	public void crearPremio(String nombre) {
		premios.put(nombre, new Premio(nombre));
	}

	public void nominarPelicula(String nombrePremio, Pelicula pelicula) {
		if (premios.containsKey(nombrePremio)) {
			premios.get(nombrePremio).addNominada(pelicula);
		} else {
			System.out.println("El premio '" + nombrePremio + "' no existe.");
		}
	}

	public void asignarGanadora(String nombrePremio, Pelicula pelicula) {
		if (premios.containsKey(nombrePremio)) {
			premios.get(nombrePremio).setGanadora(pelicula);
		} else {
			System.out.println("El premio '" + nombrePremio + "' no existe.");
		}
	}
}
