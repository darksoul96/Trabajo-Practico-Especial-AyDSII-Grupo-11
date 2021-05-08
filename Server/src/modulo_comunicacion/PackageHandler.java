package modulo_comunicacion;

import consultas_empleado.Orden;
import gestion_ingreso.Cliente;
import gestion_turnos.Servidor;

public class PackageHandler {

	public void handle(Cliente cliente) {
		Servidor.getInstance().registrarPedidoDeTurno(cliente);
	}

	public OrdenResponsePackage handle(Orden orden) { // Creo el tipo de respuesta que el servidor envia al Empleado
		String DNI;
		OrdenResponsePackage response = null;
		if (orden.executeOrder() == "REGISTRAR") {
			if (Servidor.getInstance().registrarBox(orden.getNroBox()) == true)
				response = new OrdenResponsePackage(true, "REGISTRAR", orden.getNroBox());
			else {
				response = new OrdenResponsePackage(false, "REGISTRAR", orden.getNroBox());
			}
		} else if (orden.executeOrder() == "LLAMAR") {
			DNI = Servidor.getInstance().llamarSiguiente(orden.getNroBox());
			if (DNI != null)
				response = new OrdenResponsePackage(true, "LLAMAR", DNI);
			else
				response = new OrdenResponsePackage(false, "LLAMAR", DNI);
		} else if (orden.executeOrder() == "CONSULTAR") {
			response = new OrdenResponsePackage(true, "CONSULTAR",
					Integer.toString(Servidor.getInstance().consultarTurnosRestantes()));
			return response;
		}
		return response;

	}
}
