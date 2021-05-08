package consultas_empleado;

import java.io.Serializable;

public abstract class Orden implements Serializable {

	String nroBox;
	String ip;

	public Orden(String nroBox) {
		super();
		this.nroBox = nroBox;
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

	public abstract String executeOrder();
}
