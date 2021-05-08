package ordenes;

public class Consultar extends Orden {
	


	public Consultar(String nroBox, String ip, int port) {
		super(nroBox, ip, port);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String executeOrder() {
		return "CONSULTAR";
	}

}
