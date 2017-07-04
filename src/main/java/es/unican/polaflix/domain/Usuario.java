package es.unican.polaflix.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoUsuario", discriminatorType = DiscriminatorType.STRING)
public abstract class Usuario {

	@Id
	@GeneratedValue
	private int id;
	private String username;
	private String password;
	private String isban;
	@ManyToMany
	private Set<Serie> seriesTerminadas;
	@ManyToMany
	private Set<Serie> seriesPendientes;
	@OneToMany(mappedBy="usuario")
	private Set<Factura> facturas;
	@OneToMany(mappedBy="usuario")
	private Set<EpVisualizadoUsuario> seriesEmpezadas;
	
	public Usuario(){}
	public Usuario (String username, String password, String isban){
		this.username = username;
		this.password = password;
		this.isban = isban;
		seriesTerminadas = new HashSet<Serie>();
		seriesPendientes = new HashSet<Serie>();
		facturas = new TreeSet<Factura>();
		seriesEmpezadas = new HashSet<EpVisualizadoUsuario>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIsban() {
		return isban;
	}

	public void setIsban(String isban) {
		this.isban = isban;
	}
	
	public void addSerieTerminada(Serie serie){
		seriesTerminadas.add(serie);
	}
	
	public boolean removeSerieTerminada(Serie serie){
		return seriesTerminadas.remove(serie);
	}
	
	public Set<Serie> getSeriesTerminadas(){
		return seriesTerminadas;
	}
	
	public void setSeriesTerminadas(Set<Serie> seriesTerminadas){
		this.seriesTerminadas = seriesTerminadas;
	}
	
	public boolean addSeriePendiente(Serie serie){
		return seriesPendientes.add(serie);
	}
	
	public boolean removeSeriePendiente(Serie serie){
		return seriesPendientes.remove(serie);
	}
	
	public Set<Serie> getSeriesPendientes(){
		return seriesPendientes;
	}
	
	public void setSeriesPendientes(Set<Serie> seriesPendientes){
		this.seriesPendientes = seriesPendientes;
	}
	
	public boolean addFactura(Factura factura){
		return facturas.add(factura);
	}
	
	public boolean removeFactura(Factura factura){
		return facturas.remove(factura);
	}
	
	public Set<Factura> getFacturas(){
		return facturas;
	}
	
	public void setFacturas(Set<Factura> facturas){
		this.facturas = facturas;
	}
	
	public boolean addEpisodioVisualizado(EpVisualizadoUsuario evu){
		return seriesEmpezadas.add(evu);
	}
	
	public boolean removeEpisodioVisualizado(EpVisualizadoUsuario evu){
		return seriesEmpezadas.remove(evu);
	}
	
	public Set<EpVisualizadoUsuario> getSeriesEmpezadas(){
		return seriesEmpezadas;
	}
	
	public void setSeriesEmpezadas(Set<EpVisualizadoUsuario> seriesEmpezadas){
		this.seriesEmpezadas = seriesEmpezadas;
	}
	
	@Override
	public boolean equals(Object o){
		Usuario p = (Usuario)o;
		return username.equals(p.getUsername());
	}
}
