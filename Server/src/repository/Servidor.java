package repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;

import comunicacion_ingreso.Cliente;
import interfaces.IOrdenamientoStrategy;
import interfaces.IRegistro;
import interfaces.IResincronizacion;

public class Servidor implements IRegistro, IResincronizacion {
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
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

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public Set<String> getBoxes() {
		return boxes;
	}

	public int consultarTurnosRestantes() {
		return clientes.size();
	}

	public void registrarPedidoDeTurno(Cliente cliente) {
		if (!this.clientes.contains(cliente))
			this.ordenadorStrategy.agregarCliente(cliente, this.clientes);
	}

	public Cliente llamarSiguiente(String box) {
		if (this.clientes.size() != 0) {
			this.lastCalledClient = this.clientes.remove(0);
			this.lastCalledClient.setBox(box);
			return this.lastCalledClient;
		} else {
			return null;
		}

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

	public IOrdenamientoStrategy getOrdenadorStrategy() {
		return ordenadorStrategy;
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
	public void sincronizar(Cliente lastCalledClient, Set<String> boxes, ArrayList<Cliente> clientes,
			IOrdenamientoStrategy strategy) {
		this.lastCalledClient = lastCalledClient;
		this.boxes = boxes;
		this.clientes = clientes;
		this.ordenadorStrategy = strategy;

	}

}
