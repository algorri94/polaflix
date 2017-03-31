package es.unican.polaflix.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CREADOR")
public class Creador extends Persona{

	public Creador(){}
	public Creador(String nombre, String apellido) {
		super(nombre, apellido);
	}

}
