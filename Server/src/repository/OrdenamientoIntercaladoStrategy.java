package repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import comunicacion_ingreso.Cliente;
import interfaces.IOrdenamientoStrategy;

public class OrdenamientoIntercaladoStrategy implements IOrdenamientoStrategy, Serializable {

	private int contador = 0;

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
			this.contador++;
		} else {
			while (it.hasNext() && !menor) {
				clienteActual = (Cliente) it.next();
				if (cliente.getPrioridad() < clienteActual.getPrioridad()) {
					lista.add(index, cliente);
					menor = true;
					asignado = true;
					this.contador++;
				}
				index++;
			}
			if (!asignado) {
				lista.add(index, cliente);
				asignado = true;
				this.contador++;
			}
			if (this.contador == 3) {
				aux = lista.remove(lista.size()-1);
				lista.add(0, aux);
				this.contador = 0;
			}
		}
	}

}
