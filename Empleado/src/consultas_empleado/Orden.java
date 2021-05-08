package consultas_empleado;

import java.io.Serializable;

public abstract class Orden implements Serializable {

	int nroBox;

	public Orden(int nroBox) {
		super();
		this.nroBox = nroBox;
	}

	public int getNroBox() {
		return nroBox;
	}

	public void setNroBox(int nroBox) {
		this.nroBox = nroBox;
	}

	public abstract String executeOrder();
}
