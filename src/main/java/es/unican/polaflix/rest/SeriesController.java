package es.unican.polaflix.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import es.unican.polaflix.domain.*;
import es.unican.polaflix.service.SerieService;


@RestController
public class SeriesController {
	
	@Autowired
	private SerieService se;
	
	@RequestMapping(value = "/series", method = RequestMethod.GET)
	public List<Serie> getSeries(@RequestParam(value="name", defaultValue="")String name){
		return se.getSeries(name);
	}
	
	
	@RequestMapping(value="/series/{nombre}", method = RequestMethod.GET)
	public Serie getSerie(@PathVariable String nombre){
		return se.getSerie(nombre);
	}
}
