package ordenes;

public class Baja extends Orden {

	public Baja(String nroBox, String ip, int port) {
		super(nroBox, ip, port);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String executeOrder() {
		// TODO Auto-generated method stub
		return "BAJA";
	}

}
