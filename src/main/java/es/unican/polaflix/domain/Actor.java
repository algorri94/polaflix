package es.unican.polaflix.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ACTOR")
public class Actor extends Persona{

	public Actor(){}
	public Actor(String nombre, String apellido) {
		super(nombre, apellido);
	}

}
