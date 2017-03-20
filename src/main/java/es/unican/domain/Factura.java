package es.unican.domain;

import java.util.HashSet;
import java.util.Set;

public class Factura implements Comparable<Factura>{
	
	private int id;
	private int mes;
	private int year;
	private Usuario usuario;
	private Set<FacturaEpisodio> episodios;
	
	public Factura(int mes, Usuario usuario){
		this.mes = mes;
		this.usuario = usuario;
		episodios = new HashSet<FacturaEpisodio>();
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
	
	public void addEpisodio(FacturaEpisodio ep){
		episodios.add(ep);
	}
	
	public boolean removeEpisodio(FacturaEpisodio ep){
		return episodios.remove(ep);
	}
	
	public Set<FacturaEpisodio> getEpisodios(){
		return episodios;
	}
	
	@Override
	public boolean equals(Object o){
		Factura f = (Factura)o;
		return f.getMes()==mes && usuario.equals(f.getUsuario());
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
