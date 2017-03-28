package es.unican.polaflix.repo;

import org.springframework.data.repository.Repository;

import es.unican.polaflix.domain.Usuario;

public interface UsuarioRepository extends Repository<Usuario, Integer>{

	Usuario findByUsername(String username);
	
}
