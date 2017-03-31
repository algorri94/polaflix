package es.unican.polaflix.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Serie {

	@Id
	@GeneratedValue
	private int id;
	private String titulo;
	private String descripcion;
	@OneToMany(mappedBy ="serie")
	private Set<Temporada> temporadas;
	@ManyToMany
	private List<Persona> artistas;
	@ManyToOne
	private TipoSerie tipoSerie;
	
	public Serie(){}
	public Serie (String titulo, String descripcion, TipoSerie tipoSerie){
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.tipoSerie = tipoSerie;
		temporadas = new HashSet<Temporada>();
		artistas = new ArrayList<Persona>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoSerie getTipoSerie() {
		return tipoSerie;
	}

	public void setTipoSerie(TipoSerie tipoSerie) {
		this.tipoSerie = tipoSerie;
	}
	
	public void addTemporada(Temporada temporada){
		temporadas.add(temporada);
	}
	
	public boolean removeTemporada(Temporada temporada){
		return temporadas.remove(temporada);
	}
	
	public Set<Temporada> getTemporadas(){
		return temporadas;
	}
	
	public void addArtista(Persona persona){
		artistas.add(persona);
	}
	
	public boolean removeArtista(Persona persona){
		return artistas.remove(persona);
	}
	
	public List<Persona> getArtistas(){
		return artistas;
	}
	
	@Override
	public boolean equals(Object o){
		Serie s = (Serie)o;
		return titulo.equals(s.getTitulo());
	}
}
