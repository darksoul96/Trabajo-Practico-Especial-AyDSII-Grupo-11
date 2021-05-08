package ordenes;

public class Registrar extends Orden {

	public Registrar(String nroBox, String ip, int port) {
		super(nroBox, ip, port);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String executeOrder() {
		// TODO Auto-generated method stub
		return "REGISTRAR";
	}

}
