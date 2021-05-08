package consultas_empleado;

public class LLamar extends Orden {

	public LLamar(int nroBox) {
		super(nroBox);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String executeOrder() {
		return "Llamar";
	}

}
