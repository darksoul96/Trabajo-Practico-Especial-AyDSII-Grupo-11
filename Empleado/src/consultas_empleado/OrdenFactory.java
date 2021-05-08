package consultas_empleado;

public class OrdenFactory {

	public Orden createOrden(String OrdenType, String nroBox) {
		Orden orden = null;
		if (OrdenType == "SeleccionBox") {
			orden = new Registrar(nroBox);
		} else if (OrdenType == "LLAMAR") {
			orden = new Llamar(nroBox);
		} else if (OrdenType == "CONSULTAR") {
			orden = new Registrar(nroBox);
		}
		return orden;
	}
}
