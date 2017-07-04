package es.unican.polaflix.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class EpVisualizadoUsuario {

	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	private Serie serie;
	@ManyToMany
	@JoinTable(name="episodios_visualizados",
		      joinColumns=@JoinColumn(name="ep_visualizado_usuario_id", referencedColumnName="id"),
		      inverseJoinColumns=@JoinColumn(name="episodio_id", referencedColumnName="id"))
	private Set<Episodio> episodiosVisualizados;
	@ManyToOne
	@JoinColumn(name="usuario_id")
	@JsonIgnore
	private Usuario usuario;
	
	public EpVisualizadoUsuario(){}
	public EpVisualizadoUsuario(Usuario usuario, Serie serie){
		this.usuario = usuario;
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
	
	public Set<Episodio> getEpisodiosVisualizados(){
		return episodiosVisualizados;
	}
	
	public void setEpisodiosVisualizados(Set<Episodio> eps){
		episodiosVisualizados = eps;
	}
	
	public boolean addEpisodioVisualizado(Episodio ep){
		return episodiosVisualizados.add(ep);
	}
	
	@Override
	public boolean equals(Object o){
		EpVisualizadoUsuario evu = (EpVisualizadoUsuario)o;
		return serie.equals(evu.getSerie()) && usuario.equals(evu.getUsuario());
	}
}
