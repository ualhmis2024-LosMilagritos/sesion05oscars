package org.ualhmis.oscars;

public class PremiosCineApp {
	public static void main(String[] args) {
		// Crear gestor de premios
		GestorPremios gestorPremios = new GestorPremios();

		// Crear premios
		gestorPremios.crearPremio("Mejor Película");
		gestorPremios.crearPremio("Mejor Director");
		gestorPremios.crearPremio("Mejor Actor");
		gestorPremios.crearPremio("Mejor Actriz");
		// Añadir más premios si es necesario

		// Crear premios
        gestorPremios.crearPremio("Mejor Película");
        gestorPremios.crearPremio("Mejor Director");
        gestorPremios.crearPremio("Mejor Actor");
        gestorPremios.crearPremio("Mejor Actriz");
        // Añadir más premios si es necesario

        // Crear películas, actores, actrices y directores
        Director director1 = new Director("Christopher Nolan", "Masculino", "30/07/1970");
        Actor actor1 = new Actor("Leonardo DiCaprio", "Masculino", "11/11/1974");
        Actriz actriz1 = new Actriz("Scarlett Johansson", "Femenino", "22/11/1984");

        Pelicula pelicula1 = new Pelicula("Inception", director1);
        pelicula1.setActorProtagonista(actor1);
        pelicula1.setActrizProtagonista(actriz1);

        Director director2 = new Director("Quentin Tarantino", "Masculino", "27/03/1963");
        Actor actor2 = new Actor("Brad Pitt", "Masculino", "18/12/1963");
        Actriz actriz2 = new Actriz("Margot Robbie", "Femenino", "02/07/1990");

        Pelicula pelicula2 = new Pelicula("Once Upon a Time in Hollywood", director2);
        pelicula2.setActorProtagonista(actor2);
        pelicula2.setActrizProtagonista(actriz2);

        Director director3 = new Director("Greta Gerwig", "Femenino", "04/08/1983");
        Actor actor3 = new Actor("Saoirse Ronan", "Femenino", "12/04/1994");
        Actriz actriz3 = new Actriz("Emma Watson", "Femenino", "15/04/1990");

        Pelicula pelicula3 = new Pelicula("Little Women", director3);
        pelicula3.setActorProtagonista(actor3);
        pelicula3.setActrizProtagonista(actriz3);

        // Nominar películas
        gestorPremios.nominarPelicula("Mejor Película", pelicula1);
        gestorPremios.nominarPelicula("Mejor Película", pelicula2);
        gestorPremios.nominarPelicula("Mejor Película", pelicula3);

        // Asignar ganadoras
        gestorPremios.asignarGanadora("Mejor Película", pelicula1);

        // Obtener ganadora del premio
        Pelicula ganadoraMejorPelicula = gestorPremios.getPremios().get("Mejor Película").getGanadora();
        System.out.println("La película ganadora del Oscar a la Mejor Película es: " + ganadoraMejorPelicula.getTitulo());
    }
}
