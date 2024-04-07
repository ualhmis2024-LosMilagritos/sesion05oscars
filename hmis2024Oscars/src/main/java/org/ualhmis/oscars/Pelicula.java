package org.ualhmis.oscars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Clase Pelicula
class Pelicula {
	private String titulo;
	private Director director;
	private Actor actorProtagonista;
	private Actriz actrizProtagonista;
	private List<Actor> actoresSecundarios;
	private List<Actriz> actricesSecundarias;

	public Pelicula(String titulo, Director director) {
		this.titulo = titulo;
		this.director = director;
		this.actoresSecundarios = new ArrayList<>();
		this.actricesSecundarias = new ArrayList<>();
	}

	public String getTitulo() {
		return titulo;
	}

	public Director getDirector() {
		return director;
	}

	public Actor getActorProtagonista() {
		return actorProtagonista;
	}

	public void setActorProtagonista(Actor actorProtagonista) {
		this.actorProtagonista = actorProtagonista;
	}

	public Actriz getActrizProtagonista() {
		return actrizProtagonista;
	}

	public void setActrizProtagonista(Actriz actrizProtagonista) {
		this.actrizProtagonista = actrizProtagonista;
	}

	public List<Actor> getActoresSecundarios() {
		return actoresSecundarios;
	}

	public List<Actriz> getActricesSecundarias() {
		return actricesSecundarias;
	}

	public void addActorSecundario(Actor actorSecundario) {
		actoresSecundarios.add(actorSecundario);
	}

	public void addActrizSecundaria(Actriz actrizSecundaria) {
		actricesSecundarias.add(actrizSecundaria);
	}
}


