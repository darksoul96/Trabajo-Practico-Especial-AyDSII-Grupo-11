package consultas_empleado;

import java.io.Serializable;

public abstract class Orden implements Serializable {

	String nroBox;

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

	public abstract String executeOrder();
}
