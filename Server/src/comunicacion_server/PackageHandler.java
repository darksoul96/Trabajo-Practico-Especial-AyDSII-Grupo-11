package comunicacion_server;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import comunicacion_ingreso.Cliente;
import ordenes.Orden;
import paquetes.BackupPackage;
import paquetes.OrdenResponsePackage;
import repository.Servidor;

public class PackageHandler {

	public void handle(BackupPackage backup) { // Maneja lo recibido desde el server principal
		if (backup.getPackageType() != null) {
			if (backup.getPackageType().equals("CLIENTE")) {
				handle(backup.getCliente());
			} else {
				if (backup.getPackageType().equals("ORDEN")) {
					handle(backup.getOrden());
				} else {
					if (backup.getPackageType().equals("SINCRONIZAR")) {
						Servidor.getInstance().sincronizar(backup.getLastCalledClient(), backup.getBoxes(),
								backup.getClientes(), backup.getOrdenadorStrategy());
					}
				}
			}
		}
	}

	public void handle(Cliente cliente) { // Maneja lo recibido desde Cliente
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
				nextClient.setHorarioAtencion(ZonedDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE) + " "
						+ ZonedDateTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_LOCAL_TIME));
				response = new OrdenResponsePackage(true, "LLAMAR", nextClient);
			} else
				response = new OrdenResponsePackage(false, "LLAMAR", nextClient);
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
