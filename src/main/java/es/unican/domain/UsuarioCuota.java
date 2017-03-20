package es.unican.domain;

public class UsuarioCuota extends Usuario{
	
	private double cuota;

	public UsuarioCuota(String username, String password, String isban, double cuota) {
		super(username, password, isban);
		this.cuota = cuota;
	}

	public double getCuota() {
		return cuota;
	}

	public void setCuota(double cuota) {
		this.cuota = cuota;
	}
}
