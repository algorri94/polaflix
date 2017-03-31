package es.unican.polaflix.domain;

import javax.persistence.*;

@Entity
public class TipoSerie {

	@Id
	@GeneratedValue
	private int id;
	private String tipo;
	private double precio;
	
	public TipoSerie(){}
	public TipoSerie(String tipo, double precio){
		this.tipo = tipo;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public boolean equals(Object o){
		TipoSerie ts = (TipoSerie)o;
		return tipo.equals(ts.getTipo());
	}
}
