package es.unican.polaflix.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import es.unican.polaflix.domain.*;
import es.unican.polaflix.service.UserService;

@RestController
public class UsuarioController {

	@Autowired
	private UserService us;
	
	@RequestMapping(value="/usuarios/{username}", method = RequestMethod.GET)
	public Usuario getUsuario(@PathVariable String username){
		return us.getUsuario(username);
	}
	
	@RequestMapping(value="/usuarios/{username}/pendientes/{id}", method = RequestMethod.POST)
	public ResponseEntity addPendiente(@PathVariable String username, @PathVariable int id){
		ResponseEntity re;
		if (us.addPendienteToUsuario(username, id)){
			re = new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			re = new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return re;
	}
	
	@RequestMapping(value="/usuarios/{username}/empezadas/{id}", method = RequestMethod.POST)
	public ResponseEntity addEmpezada(@PathVariable String username, @PathVariable int id, 
			@RequestParam(value="temporada", defaultValue="-1") int temporada,
			@RequestParam(value="episodio", defaultValue="-1") int episodio){
		ResponseEntity re;
		if (us.addEpisodioVistoToUsuario(username, id, temporada, episodio)){
			re = new ResponseEntity<>(HttpStatus.CREATED);
		} else if (temporada < 0 && episodio < 0) {
			re = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			re = new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return re;
	}
	
	@RequestMapping(value="/usuarios/{username}/empezadas/{id}", method = RequestMethod.GET)
	public EpVisualizadoUsuario getSerieEmpezada(@PathVariable String username, @PathVariable int id){
		return us.getSerieEmpezada(username, id);
	}
	
	@RequestMapping(value="/usuarios/{username}/facturas", method = RequestMethod.GET)
	public List<FacturaDTO> getFacturasUsuario(@PathVariable String username){
		return us.getFacturasUsuario(username);
	}
}
