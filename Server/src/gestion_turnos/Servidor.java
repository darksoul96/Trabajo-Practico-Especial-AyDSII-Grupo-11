package gestion_turnos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import gestion_ingreso.Cliente;

public class Servidor {
	Queue<Cliente> clientes = new LinkedList<Cliente>();
	ArrayList<Integer> boxes = new ArrayList<Integer>();
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

	public int consultarTurnosRestantes() {
		return clientes.size();
	}

	public void registrarPedidoDeTurno(Cliente cliente) {
		if (!clientes.contains(cliente)) {
			clientes.add(cliente);
		} else {
			System.out.println("YA LO CONTENIA");
		}

	}

	public Cliente llamarSiguiente(String box) {
		Cliente nextClient = null;
		if (!clientes.isEmpty()) {
			nextClient = clientes.remove();
			nextClient.setBox(box);
		}
		return nextClient;
	}

	public boolean registrarBox(int box) {
		boolean exito;
		if (!boxes.contains(box)) {
			boxes.add(box);
			exito = true;
		} else {
			exito = false;
		}
		return exito;

	}

}
