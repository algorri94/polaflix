package es.unican.domain;

public class TipoSerie {

	private String id;
	private String tipo;
	private double precio;
	
	public TipoSerie(String tipo, double precio){
		this.tipo = tipo;
		this.precio = precio;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
