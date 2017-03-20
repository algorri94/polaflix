package es.unican.domain;

import java.util.HashSet;
import java.util.Set;

public class EpVisualizadoUsuario {

	private int id;
	private Serie serie;
	private Set<Episodio> episodiosVisualizados;
	private Usuario usuario;
	
	public EpVisualizadoUsuario(int id, Serie serie){
		this.id = id;
		this.serie = serie;
		episodiosVisualizados = new HashSet<Episodio>();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Serie getSerie() {
		return serie;
	}
	
	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	
	public Usuario getUsuario(){
		return usuario;
	}
	
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}
	
	public void addEpisodio(Episodio episodio){
		episodiosVisualizados.add(episodio);
	}
	
	public boolean eliminarEpisodio(Episodio episodio){
		return episodiosVisualizados.remove(episodio);
	}
	
	public Set<Episodio> getEpisodiosVisualizados(){
		return episodiosVisualizados;
	}
	
	@Override
	public boolean equals(Object o){
		EpVisualizadoUsuario evu = (EpVisualizadoUsuario)o;
		return serie.equals(evu.getSerie()) && usuario.equals(evu.getUsuario());
	}
}
