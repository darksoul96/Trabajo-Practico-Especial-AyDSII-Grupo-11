package paquetes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import comunicacion_ingreso.Cliente;
import interfaces.IOrdenamientoStrategy;
import ordenes.Orden;
import repository.Servidor;

public class BackupPackage implements Serializable {
	Orden orden = null;
	Cliente cliente = null;
	ArrayList<Cliente> clientes = null;
	Set<String> boxes = null;
	Cliente lastCalledClient = null;
	String packageType = null;
	IOrdenamientoStrategy ordenadorStrategy;

	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.packageType = "ORDEN";
		this.orden = orden;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.packageType = "CLIENTE";
		this.cliente = cliente;
	}

	public void sincronizarServer(ArrayList<Cliente> clientes, Set<String> boxes, Cliente lastCalledClient, IOrdenamientoStrategy strategy) {
		this.packageType = "SINCRONIZAR";
		this.clientes = Servidor.getInstance().getClientes();
		this.boxes = Servidor.getInstance().getBoxes();
		this.lastCalledClient = Servidor.getInstance().getLastCalledClient();
		this.ordenadorStrategy = strategy;
	}

	public String getPackageType() {
		return this.packageType;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public Set<String> getBoxes() {
		return boxes;
	}

	public Cliente getLastCalledClient() {
		return lastCalledClient;
	}

	public IOrdenamientoStrategy getOrdenadorStrategy() {
		return ordenadorStrategy;
	}

	public void setOrdenadorStrategy(IOrdenamientoStrategy ordenadorStrategy) {
		this.ordenadorStrategy = ordenadorStrategy;
	}
	
	

}
