package interfaces;

import comunicacion_ingreso.Cliente;
import ordenes.Orden;
import paquetes.OrdenResponsePackage;

public interface Notificacion {

	public int consultarTurnosRestantes();

	public void registrarPedidoDeTurno(Cliente cliente);

	public Cliente llamarSiguiente(String box);

	public boolean registrarBox(String box);

	public void liberarBox(String box);
}
