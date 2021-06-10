package interfaces;

import comunicacion_ingreso.Cliente;
import controller_cliente.ControllerCliente;

public interface IComunicacionCliente {

	public void enviarCliente(Cliente cliente);
	
	public void setController(ControllerCliente controller);
}
