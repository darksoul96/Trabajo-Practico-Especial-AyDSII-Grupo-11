package interfaces;

import comunicacion_ingreso.Cliente;

public interface IAccesoBaseDatos {
	
	public Cliente completaCliente(Cliente cliente);
	
	public void persistirHorarioRegistro(Cliente cliente);
	
	public void persistirHorarioDeAtencion(Cliente cliente);
	
	public void generaLista();
}
