package es.unican.polaflix.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class FacturaEpisodio implements Comparable<FacturaEpisodio>{

	@Id
	@GeneratedValue
	private int id;
	private double precio;
	@OneToOne
	@JoinColumn(name="episodio_id")
	private Episodio episodio;
	@ManyToOne
	@JoinColumn(name="factura_id")
	@JsonIgnore
	private Factura factura;
	private int day;
	
	public FacturaEpisodio(){}
	public FacturaEpisodio(double precio, Episodio episodio){
		this.precio = precio;
		this.episodio = episodio;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public Episodio getEpisodio() {
		return episodio;
	}
	
	public void setEpisodio(Episodio episodio) {
		this.episodio = episodio;
	}
	
	public Factura getFactura(){
		return factura;
	}
	
	public void setFactura(Factura factura){
		this.factura = factura;
	}
	
	public int getDay(){
		return day;
	}
	
	public void setDay(int day){
		this.day = day;
	}
	
	@Override
	public boolean equals(Object o){
		FacturaEpisodio fe = (FacturaEpisodio)o;
		return episodio.equals(fe.getEpisodio()) && factura.equals(fe.getFactura());
	}

	@Override
	public int compareTo(FacturaEpisodio fe) {
		return episodio.compareTo(fe.getEpisodio());
	}
}
