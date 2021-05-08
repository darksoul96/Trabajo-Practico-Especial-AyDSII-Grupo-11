package modulo_comunicacion;

import consultas_empleado.Orden;
import gestion_ingreso.Cliente;
import gestion_turnos.Servidor;

public class PackageHandler {

	public void handle(Cliente cliente) {
		Servidor.getInstance().registrarPedidoDeTurno(cliente);
	}
	
	public void handle(Orden orden) {
		
	}
	
}
