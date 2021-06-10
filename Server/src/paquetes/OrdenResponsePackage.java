package paquetes;

import java.io.Serializable;

import comunicacion_ingreso.Cliente;

public class OrdenResponsePackage implements Serializable {
	Boolean success;
	public String type;
	String info;
	Cliente cliente = null;

	public OrdenResponsePackage(Boolean sucess, String type, String info) {
		super();
		this.success = sucess;
		this.type = type;
		this.info = info;
	}

	public OrdenResponsePackage(Boolean sucess, String type, Cliente cliente) {
		super();
		this.success = sucess;
		this.type = type;
		this.cliente = cliente;
	}

	public Boolean getSucess() {
		return success;
	}

	public void setSucess(Boolean sucess) {
		this.success = sucess;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
