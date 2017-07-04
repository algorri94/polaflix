package es.unican.polaflix.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import es.unican.polaflix.domain.Serie;

public interface SerieRepository extends Repository<Serie, Integer>{
	
	@Query("SELECT s FROM Serie s where s.titulo LIKE CONCAT(:letter,'%')")
	List<Serie> findByTituloFirstLetter(@Param("letter") String letter);
	
	@Query("SELECT s FROM Serie s where s.titulo LIKE CONCAT('%',:name,'%')")
	List<Serie> findWithTitulo(@Param("name") String name);
	
	Serie findByTitulo(String name);
	
	Serie findById(int id);
	
	boolean save(Serie s);
}
