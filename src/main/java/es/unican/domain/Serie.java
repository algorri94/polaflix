package es.unican.domain;

import java.util.Set;

public class Serie {

	private int id;
	private String titulo;
	private String descripcion;
	private Set<Temporada> temporadas;
	private TipoSerie tipoSerie;
	
	public Serie (String titulo, String descripcion, TipoSerie tipoSerie){
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.tipoSerie = tipoSerie;
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
	
	@Override
	public boolean equals(Object o){
		Serie s = (Serie)o;
		return titulo.equals(s.getTitulo());
	}
}
