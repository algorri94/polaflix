package es.unican.polaflix.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dtype", discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "class")
public abstract class Persona {

	@Id
	@GeneratedValue
	private int id;
	private String nombre;
	private String apellido;
	
	public Persona(){}
	public Persona (String nombre, String apellido){
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	@Override
	public boolean equals(Object o){
		Persona p = (Persona)o;
		return nombre.equals(p.nombre) && apellido.equals(p.apellido);
	}
}
