package interfaces;

import comunicacion_ingreso.Cliente;
import comunicacion_server.OrdenResponsePackage;
import ordenes.Orden;

public interface ComunicacionServer {

	public void recibir();

	public void enviarBox(Orden orden, OrdenResponsePackage response);

	public void enviarPantalla(Cliente cliente);
	
	public boolean conectarServers();
}
