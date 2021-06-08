package repository;

import java.util.ArrayList;

import comunicacion_ingreso.Cliente;
import interfaces.IOrdenamientoStrategy;

public class OrdenamientoLlegadaStrategy implements IOrdenamientoStrategy {

	@Override
	public void agregarCliente(Cliente cliente, ArrayList<Cliente> lista) {
		lista.add(cliente);

	}

}
