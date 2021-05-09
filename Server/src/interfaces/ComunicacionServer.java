package interfaces;

import comunicacion.OrdenResponsePackage;
import ingreso.Cliente;
import ordenes.Orden;

public interface ComunicacionServer {

	public void recibir();

	public void enviarBox(Orden orden, OrdenResponsePackage response);

	public void enviarPantalla(Cliente cliente);
}
