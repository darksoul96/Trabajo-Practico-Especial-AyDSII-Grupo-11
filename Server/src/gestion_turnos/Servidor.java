package gestion_turnos;

import java.util.Queue;
import java.util.concurrent.locks.Lock;

import gestion_ingreso.Cliente;

public class Servidor {
	static Queue<Cliente> clientes;
	private static Servidor instance = null;

	private Servidor() {

	}

	public static Servidor getInstance() {
		if (instance == null) {
			Lock lock;
			if(instance == null) {
				instance = new Servidor();
			}
			
		}
		return instance;
	}

	public int getRestantes() {
		return clientes.size();
	}

	public void registrarPedidoDeTurno(String cliente) {
		//clientes.add(cliente);
		System.out.println(cliente);
	}

	public Cliente llamarSiguiente(String box) {
		Cliente nextClient = clientes.remove();
		nextClient.setBox(box);
		return nextClient;
	}
	
	public void siso() {
		System.out.println("Hola.");
	}
}
