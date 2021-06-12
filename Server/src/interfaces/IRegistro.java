package interfaces;

import comunicacion_ingreso.Cliente;

public interface IRegistro {

	public int consultarTurnosRestantes();

	public void registrarPedidoDeTurno(Cliente cliente);

	public Cliente llamarSiguiente(String box);

	public boolean registrarBox(String box);

	public void liberarBox(String box);
	
}
