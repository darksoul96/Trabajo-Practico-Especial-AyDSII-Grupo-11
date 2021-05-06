package gestion_ingreso;

public class Cliente {
	String DNI;
	
	public Cliente(String dNI) {
		super();
		DNI = dNI;
	}

	public String getDNI() {
		return DNI;
	}
	
	@Override
	public String toString() {
		return this.DNI;
	}
}
