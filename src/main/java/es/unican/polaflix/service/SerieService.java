package es.unican.polaflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.unican.polaflix.domain.Serie;
import es.unican.polaflix.repo.SerieRepository;

@Service
public class SerieService{

	@Autowired
	private SerieRepository sr;
	
	public List<Serie> getSeries (String name) {
		return sr.findWithTitulo(name);
	}
	
	public Serie getSerie (String nombre){
		Serie s;
		try {
		      int id = Integer.parseInt(nombre);
		      s = sr.findById(id);
		} catch(NumberFormatException e) {
		      s = sr.findByTitulo(nombre);
		}
		return s;
	}
}
