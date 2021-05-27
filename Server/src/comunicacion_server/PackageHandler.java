package comunicacion_server;

import comunicacion_ingreso.Cliente;
import ordenes.Orden;
import repository.Servidor;

public class PackageHandler {

	public void handle(BackupPackage backup) { // Maneja lo recibido desde el server principal
		if (backup.getPackageType().equals("CLIENTE")) {
			handle(backup.getCliente());
		} else {
			if (backup.getPackageType().equals("ORDEN")) {
				handle(backup.getOrden());
			} else {
				if (backup.getPackageType().equals("SINCRONIZAR")) {
					Servidor.getInstance().sincronizar(backup.getLastCalledClient(), backup.getBoxes(),
							backup.getClientes());
				}
			}
		}
	}

	public void handle(Cliente cliente) { // Maneja lo recibido desde empleado
		Servidor.getInstance().registrarPedidoDeTurno(cliente);
	}

	public OrdenResponsePackage handle(Orden orden) { // Recibo del Box y creo el tipo de respuesta que el
														// servidor envia al Empleado
		String DNI;
		OrdenResponsePackage response = null;
		if (orden.executeOrder().equals("REGISTRAR")) {
			if (Servidor.getInstance().registrarBox(orden.getNroBox()) == true)
				response = new OrdenResponsePackage(true, "REGISTRAR", orden.getNroBox());
			else {
				response = new OrdenResponsePackage(false, "REGISTRAR", orden.getNroBox());
			}
		} else if (orden.executeOrder().equals("LLAMAR")) {
			Cliente nextClient = Servidor.getInstance().llamarSiguiente(orden.getNroBox());
			if (nextClient != null) {
				DNI = nextClient.getDNI();
			} else
				DNI = null;
			if (DNI != null)
				response = new OrdenResponsePackage(true, "LLAMAR", DNI);
			else
				response = new OrdenResponsePackage(false, "LLAMAR", DNI);
		} else if (orden.executeOrder().equals("CONSULTAR")) {
			response = new OrdenResponsePackage(true, "CONSULTAR",
					Integer.toString(Servidor.getInstance().consultarTurnosRestantes()));
			return response;
		} else if (orden.executeOrder().equals("BAJA")) {
			Servidor.getInstance().liberarBox(orden.getNroBox());
			response = new OrdenResponsePackage(true, "BAJA", "bajaBox");
		}
		return response;

	}
}
