package interfaces;

import comunicacion_ingreso.Cliente;

public interface IAccesoBaseDatos {
	
	public Cliente completaCliente(Cliente cliente);
	
	public void persistirHorarioRegistro();
	
	public void persistirHorarioDeAtencion();
}
