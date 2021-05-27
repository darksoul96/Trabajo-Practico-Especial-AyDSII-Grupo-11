package comunicacion_server;

import java.io.Serializable;

import comunicacion_ingreso.Cliente;
import ordenes.Orden;

public class BackupPackage implements Serializable {
	Orden orden = null;
	Cliente cliente = null;

	public Orden getOrden() {
		return orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getPackageType() {
		if (orden != null) {
			return "ORDEN";
		} else {
			if (cliente != null)
				return "CLIENTE";
			else
				return null;
		}
	}

}
