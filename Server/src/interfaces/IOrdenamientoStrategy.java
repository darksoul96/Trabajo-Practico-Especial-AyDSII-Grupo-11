package interfaces;

import java.util.ArrayList;

import comunicacion_ingreso.Cliente;

public interface IOrdenamientoStrategy{
	public void agregarCliente(Cliente cliente, ArrayList<Cliente> lista);
}
