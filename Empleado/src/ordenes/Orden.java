package ordenes;

import java.io.Serializable;

import interfaces.OrdenEmpleado;

public abstract class Orden implements Serializable, OrdenEmpleado {

	String nroBox;
	String ip;
	int port;

	public Orden(String nroBox, String ip, int port) {
		super();
		this.nroBox = nroBox;
		this.ip = ip;
		this.port = port;
	}

	public String getNroBox() {
		return nroBox;
	}

	public void setNroBox(String nroBox) {
		this.nroBox = nroBox;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public abstract String executeOrder();
}
