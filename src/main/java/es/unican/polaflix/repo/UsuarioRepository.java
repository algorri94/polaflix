package es.unican.polaflix.repo;

import org.springframework.data.repository.Repository;
import es.unican.polaflix.domain.EpVisualizadoUsuario;
import es.unican.polaflix.domain.Factura;
import es.unican.polaflix.domain.FacturaEpisodio;
import es.unican.polaflix.domain.Usuario;

public interface UsuarioRepository extends Repository<Usuario, Integer>{

	Usuario findByUsername(String username);
	
	Usuario save(Usuario u);
	
	Factura save(Factura f);
	
	EpVisualizadoUsuario save(EpVisualizadoUsuario evu);
	
	FacturaEpisodio save(FacturaEpisodio fe);
}
