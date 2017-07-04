package es.unican.polaflix.domain;

public class EpisodioFacturaDTO {
	
	private int day;
	private String serie;
	private int numTemporada;
	private int numEpisodio;
	private double precio;
	
	public EpisodioFacturaDTO(){}
	
	public EpisodioFacturaDTO(FacturaEpisodio fe) {
		this.day = fe.getDay();
		this.serie = fe.getEpisodio().getTemporada().getSerie().getTitulo();
		this.numTemporada = fe.getEpisodio().getTemporada().getNumTemporada();
		this.numEpisodio = fe.getEpisodio().getNumEpisodio();
		this.precio = fe.getPrecio();
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public int getNumTemporada() {
		return numTemporada;
	}

	public void setNumTemporada(int numTemporada) {
		this.numTemporada = numTemporada;
	}

	public int getNumEpisodio() {
		return numEpisodio;
	}

	public void setNumEpisodio(int numEpisodio) {
		this.numEpisodio = numEpisodio;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
