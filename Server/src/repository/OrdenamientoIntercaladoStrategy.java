package repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import comunicacion_ingreso.Cliente;
import interfaces.IOrdenamientoStrategy;

public class OrdenamientoIntercaladoStrategy implements IOrdenamientoStrategy, Serializable {

	private static int contador=0;
	
	@Override
	public void agregarCliente(Cliente cliente, ArrayList<Cliente> lista) {
		// TODO Auto-generated method stub
		boolean menor = false;
		boolean asignado = false;
		int index = 0;
		Cliente clienteActual, aux;
		Iterator it = lista.iterator();
		if (!it.hasNext()) {
			lista.add(index, cliente);
			asignado = true;
			contador++;
		} else {
			if ((lista.size() % 2) == 0) {
				aux=lista.remove(lista.size());
				lista.add(0,aux);
			}
			while (it.hasNext() && !menor) {
				clienteActual = (Cliente) it.next();
				if (contador == 2) {
					aux=lista.remove(lista.size());
					lista.add(0,aux);
					contador=0;
				}
				if (cliente.getPrioridad() < clienteActual.getPrioridad()) {
					lista.add(index, cliente);
					menor = true;
					asignado = true;
					contador++;
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
