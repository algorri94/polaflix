package es.unican.domain;

public class Episodio implements Comparable<Episodio>{

	private int id;
	private String titulo;
	private String descripcion;
	private int numEpisodio;
	private Temporada temporada;
	
	public Episodio(int id, String titulo, String descripcion, int numEpisodio){
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.numEpisodio = numEpisodio;
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
	
	public int getNumEpisodio() {
		return numEpisodio;
	}
	
	public void setNumEpisodio(int numEpisodio) {
		this.numEpisodio = numEpisodio;
	}
	
	public Temporada getTemporada(){
		return temporada;
	}
	
	public void setTemporada(Temporada temporada){
		this.temporada = temporada;
	}
	
	@Override
	public boolean equals(Object o){
		Episodio ep = (Episodio)o;
		return temporada.equals(ep.getTemporada()) && numEpisodio == ep.getNumEpisodio();
	}

	@Override
	public int compareTo(Episodio ep) {
		//Por defecto el episodio actual es menor al recibido
		int resultado = -1;
		
		//Si los episodios pertenecen a la misma temporada
		if(temporada.equals(ep.getTemporada())){
			//Se retorna un 1 si el n�mero del episodio actual es mayor al recibido
			if(numEpisodio > ep.getNumEpisodio()){
				resultado = 1;
			//Se retorna un 0 si es el mismo episodio (es el mismo)
			} else if (numEpisodio == ep.getNumEpisodio()){
				resultado = 0;
			}
		//Sino se comparan por orden alfab�tico en funci�n de su titulo
		} else {
			resultado = titulo.compareTo(ep.getTitulo());
		}
		return resultado;
	}
}
