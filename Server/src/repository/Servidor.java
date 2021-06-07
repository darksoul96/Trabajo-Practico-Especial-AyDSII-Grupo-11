package repository;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Lock;

import comunicacion_ingreso.Cliente;
import interfaces.INotificacion;
import interfaces.IOrdenamientoStrategy;
import interfaces.IRegistro;
import interfaces.IResincronizacion;

public class Servidor implements IRegistro, INotificacion, IResincronizacion {
	Queue<Cliente> clientes = new LinkedList<Cliente>();
	Set<String> boxes = new HashSet<>();
	Cliente lastCalledClient;
	boolean primary = false;
	private static Servidor instance = null;
	IOrdenamientoStrategy ordenadorStrategy;

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

	public void setOrdenadorStrategy(IOrdenamientoStrategy ordenadorStrategy) {
		this.ordenadorStrategy = ordenadorStrategy;
	}

	public Queue<Cliente> getClientes() {
		return clientes;
	}

	public Set<String> getBoxes() {
		return boxes;
	}

	public int consultarTurnosRestantes() {
		return clientes.size();
	}

	public void registrarPedidoDeTurno(Cliente cliente) {
		if (!clientes.contains(cliente)) {
			clientes.add(cliente);
		}
	}

	public Cliente llamarSiguiente(String box) {
		Cliente nextClient = null;
		if (!clientes.isEmpty()) {
			nextClient = clientes.remove();
			nextClient.setBox(box);
			this.lastCalledClient = nextClient;
		}
		return nextClient;
	}

	public Cliente getLastCalledClient() {
		return lastCalledClient;
	}

	public void setLastCalledClient(Cliente lastCalledClient) {
		this.lastCalledClient = lastCalledClient;
	}

	public boolean registrarBox(String box) {
		boolean exito;
		if (!boxes.contains(box)) {
			boxes.add(box);
			exito = true;
		} else {
			exito = false;
		}
		return exito;
	}

	public void liberarBox(String box) {
		if (boxes.contains(box))
			boxes.remove(box);
	}

	@Override
	public boolean isPrimary() {
		return primary;
	}

	@Override
	public void setPrimary() {
		this.primary = true;

	}

	@Override
	public void setSecondary() {
		this.primary = false;

	}

	@Override
	public void sincronizar(Cliente lastCalledClient, Set<String> boxes, Queue<Cliente> clientes) {
		this.lastCalledClient = lastCalledClient;
		this.boxes = boxes;
		this.clientes = clientes;

	}

}
