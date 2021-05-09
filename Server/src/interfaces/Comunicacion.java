package interfaces;

import comunicacion.OrdenResponsePackage;
import ingreso.Cliente;
import ordenes.Orden;

public interface Comunicacion {

	public void recibir();

	public void enviarBox(Orden orden, OrdenResponsePackage response);

	public void enviarPantalla(Cliente cliente);
}
