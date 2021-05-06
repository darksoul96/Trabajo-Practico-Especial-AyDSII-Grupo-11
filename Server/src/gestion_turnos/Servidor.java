package gestion_turnos;

import java.util.Queue;

import gestion_ingreso.Cliente;

public class Servidor {
	static Queue <Cliente> clientes;
	private static Servidor instance = null;
	
	private Servidor() {
		
	}
	
	public static Servidor getInstance() {
		if(instance == null) {
			instance = new Servidor();
		}
		return instance;
	}
	
	public static int getRestantes() {
		return clientes.size();
	}
	
	public static void registrarPedidoDeTurno(Cliente cliente) {
		clientes.add(cliente);
		System.out.println(cliente.getDNI());
	}
	
	
	public static Cliente llamarSiguiente(String box) {
		Cliente nextClient = clientes.remove();
		nextClient.setBox(box);
		return nextClient;
	}
}
