package gestion_turnos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import gestion_ingreso.Cliente;

public class Servidor {
	Queue<Cliente> clientes = new LinkedList<Cliente>();
	Set<String> boxes = new HashSet<>();
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

	public String llamarSiguiente(String box) {
		Cliente nextClient = null;
		if (!clientes.isEmpty()) {
			nextClient = clientes.remove();
			nextClient.setBox(box);
		}
		return nextClient.getDNI();
	}

	public boolean registrarBox(String box) {
		boolean exito;
		System.out.println("ENTRE AL METODO DE REGISTRARBOX");
		if (!boxes.contains(box)) {
			boxes.add(box);
			exito = true;
		} else {
			exito = false;
		}
		return exito;

	}

}
