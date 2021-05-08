package consultas_empleado;

public class Llamar extends Orden {

	public Llamar(String nroBox) {
		super(nroBox);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String executeOrder() {
		return "Llamar";
	}

}
