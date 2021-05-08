package consultas_empleado;

public class Consultar extends Orden {
	
	public Consultar(int nroBox) {
		super(nroBox);
	}

	@Override
	public String executeOrder() {
		return "Consultar";
	}

}
