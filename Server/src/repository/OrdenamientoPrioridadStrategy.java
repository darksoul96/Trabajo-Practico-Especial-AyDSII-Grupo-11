 package repository;

import java.util.ArrayList;
import java.util.Iterator;

import comunicacion_ingreso.Cliente;
import interfaces.IOrdenamientoStrategy;

public class OrdenamientoPrioridadStrategy implements IOrdenamientoStrategy {

	@Override
	public void agregarCliente(Cliente cliente, ArrayList<Cliente> lista) {
		boolean menor = false;
		boolean asignado = false;
		int index = 0;
		Cliente clienteActual;
		Iterator it = lista.iterator();
		if (!it.hasNext()) {
			lista.add(index, cliente);
			asignado = true;
		} else {
			while (it.hasNext() && !menor) {
				clienteActual = (Cliente) it.next();
				if (cliente.getPrioridad() < clienteActual.getPrioridad()) {
					lista.add(index, cliente);
					menor = true;
					asignado = true;
				}
				index++;
			}
			if (!asignado) {
				lista.add(index, cliente);
				asignado = true;
			}
		}
	}
}
