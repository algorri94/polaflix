package es.unican.polaflix.domain;

import java.util.ArrayList;
import java.util.List;

public class FacturaDTO {
	private int id;
	private int mes;
	private int year;
	private List<EpisodioFacturaDTO> episodios;
	
	public FacturaDTO(){}
	
	public FacturaDTO(Factura f) {
		this.id = f.getId();
		this.mes = f.getMes();
		this.year = f.getYear();
		episodios = new ArrayList<EpisodioFacturaDTO>();
		for(FacturaEpisodio fe: f.getEpisodios()){
			episodios.add(new EpisodioFacturaDTO(fe));
		}
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<EpisodioFacturaDTO> getEpisodios() {
		return episodios;
	}

	public void setEpisodios(List<EpisodioFacturaDTO> episodios) {
		this.episodios = episodios;
	}
}
