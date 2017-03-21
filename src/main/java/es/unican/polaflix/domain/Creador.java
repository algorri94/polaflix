package es.unican.polaflix.domain;

import javax.persistence.Entity;

@Entity
public class Creador extends Persona{

	public Creador(String nombre, String apellido) {
		super(nombre, apellido);
	}

}
