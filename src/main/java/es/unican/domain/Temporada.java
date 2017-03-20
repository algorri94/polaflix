package es.unican.domain;

import java.util.Set;
import java.util.TreeSet;

public class Temporada implements Comparable<Temporada>{

	private int id;
	private Serie serie;
	private int numTemporada;
	private Set<Episodio> episodios;
	
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
	
	public void addEpisodio(Episodio ep){
		episodios.add(ep);
	}
	
	public boolean removeEpisodio(Episodio ep){
		return episodios.remove(ep);
	}
	
	public Set<Episodio> getEpisodios(){
		return episodios;
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
