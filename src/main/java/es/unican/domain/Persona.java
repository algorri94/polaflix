package es.unican.domain;

public class Persona {

	private int id;
	private String nombre;
	private String apellido;
	
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
