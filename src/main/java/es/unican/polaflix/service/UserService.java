package es.unican.polaflix.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.unican.polaflix.domain.EpVisualizadoUsuario;
import es.unican.polaflix.domain.Episodio;
import es.unican.polaflix.domain.Factura;
import es.unican.polaflix.domain.FacturaDTO;
import es.unican.polaflix.domain.FacturaEpisodio;
import es.unican.polaflix.domain.Serie;
import es.unican.polaflix.domain.Temporada;
import es.unican.polaflix.domain.Usuario;
import es.unican.polaflix.repo.SerieRepository;
import es.unican.polaflix.repo.UsuarioRepository;

@Service
public class UserService {

	@Autowired
	private UsuarioRepository ur;
	@Autowired
	private SerieRepository sr;
	
	public Usuario getUsuario(String username){
		return ur.findByUsername(username);
	}
	
	public boolean addPendienteToUsuario(String username, int id){
		boolean added;		
		Usuario u = ur.findByUsername(username);
		Serie s = sr.findById(id);
		added = u.addSeriePendiente(s);
		ur.save(u);
		return added;
	}
	
	public boolean addEpisodioVistoToUsuario(String username, int id, int temporada, int episodio){
		boolean added = false;
		Usuario u = ur.findByUsername(username);	
		Serie s = sr.findById(id);
		Temporada tmp = null;
		Episodio ep = null;
		FacturaEpisodio fe = null;
		Calendar c = Calendar.getInstance();
		EpVisualizadoUsuario evu = new EpVisualizadoUsuario(u, s);
		Factura f = new Factura(c.get(Calendar.MONTH)+1, u);
		f.setYear(c.get(Calendar.YEAR));
		f.setUsuario(u);
		System.out.println("Usuario: "+u.getUsername());
		System.out.println("Serie: "+s.getTitulo());
		if(temporada >= 0 && episodio >= 0) {
			for (EpVisualizadoUsuario epvu: u.getSeriesEmpezadas()) {
				if(epvu.getSerie().equals(s)){
					System.out.println("Serie empezada encontrada");
					evu = epvu;
				}
			}
			for(Temporada t: s.getTemporadas())
				if(t.getNumTemporada()==temporada){
					System.out.println("Temporada encontrada");
					tmp = t;
				}
			if(tmp != null)
				
				for(Episodio e: tmp.getEpisodios())
					if(e.getNumEpisodio() == episodio) {
						System.out.println("Episodio encontrado");
						ep = e;
					}
			if(tmp!=null && ep !=null){
				added = true;
				evu.addEpisodioVisualizado(ep);
				System.out.println("Episodio añadido, epVisualizadoSize: "+evu.getEpisodiosVisualizados().size());
				u.removeEpisodioVisualizado(evu);
				u.addEpisodioVisualizado(evu);
				for(Factura fact: u.getFacturas()){
					if (fact.equals(f)){
						System.out.println("Factura encontrada");
						f = fact;
					}
				}
				fe = new FacturaEpisodio();
				fe.setEpisodio(ep);
				fe.setPrecio(ep.getTemporada().getSerie().getTipoSerie().getPrecio());
				fe.setDay(c.get(Calendar.DAY_OF_MONTH));
				fe.setFactura(f);
				f.addEpisodio(fe);
				System.out.println(f.getEpisodios().size());
				u.removeFactura(f);
				added = added && f.addEpisodio(fe);
				added = added && u.addFactura(f);
			}
		}
		if(u.getSeriesPendientes().contains(s)){
			u.removeSeriePendiente(s);
		}
		if(haFinalizadoSerie(evu,s)){
			u.removeEpisodioVisualizado(evu);
			evu.setUsuario(null);
			u.addSerieTerminada(s);
		}
		if(added){
			ur.save(fe);
			ur.save(f);
			ur.save(evu);
			ur.save(u);
		}
		return added;
	}
	
	public EpVisualizadoUsuario getSerieEmpezada(String username, int serieId){
		EpVisualizadoUsuario epvu = null;
		for(EpVisualizadoUsuario evu: ur.findByUsername(username).getSeriesEmpezadas()){
			if(evu.getSerie().getId()==serieId){
				epvu = evu;
			}
		}
		return epvu;
	}
	
	public List<FacturaDTO> getFacturasUsuario(String username){
		List<FacturaDTO> facturas = new ArrayList<FacturaDTO>();
		for(Factura f: ur.findByUsername(username).getFacturas()) {
			facturas.add(new FacturaDTO(f));
		}
		return facturas;
	}
	
	private boolean haFinalizadoSerie (EpVisualizadoUsuario evu, Serie s){
		int numEpisodes = 0;
		for (Temporada t: s.getTemporadas()){
			numEpisodes += t.getEpisodios().size();
		}
		return evu.getEpisodiosVisualizados().size() >= numEpisodes;
	}
}
