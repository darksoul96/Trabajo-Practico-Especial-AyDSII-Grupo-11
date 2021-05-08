package consultas_empleado;

public class Consultar extends Orden {
	
	public Consultar(String nroBox) {
		super(nroBox);
	}

	@Override
	public String executeOrder() {
		return "CONSULTAR";
	}

}
