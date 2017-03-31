package es.unican.polaflix.domain;

import javax.persistence.*;

@Entity
@DiscriminatorValue("NORMAL")
public class UsuarioNormal extends Usuario{

	public UsuarioNormal(){}
	public UsuarioNormal(String username, String password, String isban) {
		super(username, password, isban);
	}

}
