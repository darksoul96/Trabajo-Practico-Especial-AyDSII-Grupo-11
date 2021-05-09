package interfaces;

import comunicacion.OrdenResponsePackage;
import ingreso.Cliente;
import ordenes.Orden;

public interface Notificacion {

	public int consultarTurnosRestantes();

	public void registrarPedidoDeTurno(Cliente cliente);

	public Cliente llamarSiguiente(String box);

	public boolean registrarBox(String box);

	public void liberarBox(String box);
}
