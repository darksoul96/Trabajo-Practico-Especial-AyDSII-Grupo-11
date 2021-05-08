package consultas_empleado;

public class Llamar extends Orden {


	public Llamar(String nroBox, String ip, int port) {
		super(nroBox, ip, port);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String executeOrder() {
		return "LLAMAR";
	}

}
