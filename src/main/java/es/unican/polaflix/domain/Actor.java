package es.unican.polaflix.domain;

import javax.persistence.Entity;

@Entity
public class Actor extends Persona{

	public Actor(String nombre, String apellido) {
		super(nombre, apellido);
	}

}
