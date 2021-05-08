package consultas_empleado;

public class Registrar extends Orden {

	public Registrar(String nroBox) {
		super(nroBox);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String executeOrder() {
		// TODO Auto-generated method stub
		return "REGISTRAR";
	}

}
