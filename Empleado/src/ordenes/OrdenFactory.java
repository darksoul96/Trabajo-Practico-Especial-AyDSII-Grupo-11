package ordenes;

public class OrdenFactory {

	public Orden createOrden(String OrdenType, String nroBox, String ip, int port) {
		Orden orden = null;
		if (OrdenType.equals("SeleccionBox")) {
			orden = new Registrar(nroBox, ip, port);
		} else if (OrdenType.equals("LLAMAR")) {
			orden = new Llamar(nroBox, ip, port);
		} else if (OrdenType.equals("CONSULTAR")) {
			orden = new Consultar(nroBox, ip, port);
		} else if (OrdenType.equals("BAJA"))
			orden = new Baja(nroBox, ip, port);
		return orden;
	}
}
