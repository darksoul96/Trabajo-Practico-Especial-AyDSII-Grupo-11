package repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import comunicacion_ingreso.Cliente;
import interfaces.IOrdenamientoStrategy;

public class OrdenamientoDNIStrategy implements IOrdenamientoStrategy, Serializable {

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
			while (it.hasNext() && !menor && !asignado) {
				clienteActual = (Cliente) it.next();
				if (clienteActual.getDNI().compareTo(cliente.getDNI()) > 0) {
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
