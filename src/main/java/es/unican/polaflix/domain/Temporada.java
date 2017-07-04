package es.unican.polaflix.domain;

import java.util.Set;
import java.util.TreeSet;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Temporada implements Comparable<Temporada>{

	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	@JoinColumn(name = "serie_id")
	@JsonIgnore
	private Serie serie;
	private int numTemporada;
	@OneToMany(mappedBy ="temporada")
	private Set<Episodio> episodios;
	
	public Temporada(){}
	public Temporada(Serie serie, int numTemporada){
		this.serie = serie;
		this.numTemporada = numTemporada;
		episodios = new TreeSet<Episodio>();
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

	public int getNumTemporada() {
		return numTemporada;
	}

	public void setNumTemporada(int numTemporada) {
		this.numTemporada = numTemporada;
	}
	
	public Set<Episodio> getEpisodios(){
		return episodios;
	}
	
	public void setEpisodios(Set<Episodio> episodios){
		this.episodios = episodios;
	}
	
	@Override
	public boolean equals(Object o){
		Temporada t = (Temporada)o;
		return serie.equals(t.getSerie()) && numTemporada == t.getNumTemporada();
	}

	@Override
	public int compareTo(Temporada t) {
		int result = 0;
		if(serie.equals(t.getSerie())){
			if(numTemporada>t.getNumTemporada()){
				result = 1;
			} else if (numTemporada<t.getNumTemporada()){
				result = -1;
			}
		}
		return result;
	}
}
