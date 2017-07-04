package es.unican.polaflix.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Factura implements Comparable<Factura>{
	
	@Id
	@GeneratedValue
	private int id;
	private int mes;
	private int year;
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	@JsonIgnore
	private Usuario usuario;
	@OneToMany(mappedBy="factura")
	private List<FacturaEpisodio> episodios;
	
	public Factura(){}
	public Factura(int mes, Usuario usuario){
		this.mes = mes;
		this.usuario = usuario;
		episodios = new ArrayList<FacturaEpisodio>();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getMes() {
		return mes;
	}
	
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public int getYear(){
		return year;
	}
	
	public void setYear(int year){
		this.year = year;
	}
	
	public Usuario getUsuario(){
		return usuario;
	}
	
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}
	
	public List<FacturaEpisodio> getEpisodios(){
		return episodios;
	}
	
	public void setEpisodios(List<FacturaEpisodio> episodios){
		this.episodios = episodios;
	}
	
	public boolean addEpisodio(FacturaEpisodio fe){
		return episodios.add(fe);
	}
	
	@Override
	public boolean equals(Object o){
		Factura f = (Factura)o;
		return f.getYear() == year && f.getMes()==mes && usuario.equals(f.getUsuario());
	}
	
	@Override
	public int compareTo(Factura f){
		//Por defecto se retorna un -1, es decir, el objeto actual es menor que el recibido
		int result = -1;
		
		//Si el a�o actual es mayor que el del objeto recibido se retorna un 1 (es mayor)
		if(year > f.getYear()){
			result = 1;
		}
		
		//En caso de ser el mismo a�o
		if(year==f.getYear()){
			//Si el mes es el mismo se retorna un 0 (son iguales)
			if(mes == f.getMes()){
				result = 0;
			//Si el mes es mayor se retorna un 1 (es mayor)
			} else if (mes > f.getMes()){
				result = 1;
			}
		}
		
		return result;
	}
}
