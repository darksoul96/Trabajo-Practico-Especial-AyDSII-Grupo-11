package gestion_turnos;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import gestion_ingreso.Cliente;

public class Servidor {
	Queue<Cliente> clientes = new LinkedList<Cliente>();
	private static Servidor instance = null;

	private Servidor() {

	}

	public static Servidor getInstance() {
		if (instance == null) {
			Lock lock;
			if (instance == null) {
				instance = new Servidor();
			}

		}
		return instance;
	}

	public int getRestantes() {
		return clientes.size();
	}

	public void registrarPedidoDeTurno(Cliente cliente) {
		if(!clientes.contains(cliente)) {
			clientes.add(cliente);
		}
		else {
			System.out.println("YA LO CONTENIA");
		}
		
	}

	public Cliente llamarSiguiente(String box) {
		Cliente nextClient = clientes.remove();
		nextClient.setBox(box);
		return nextClient;
	}

}
