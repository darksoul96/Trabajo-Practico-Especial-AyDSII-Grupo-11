package consultas_empleado;

public class Empleado {
	int box;

	public Empleado(int box) {
		this.box = box;
	}

	public int getBox() {
		return box;
	}

	public void setBox(int box) {
		this.box = box;
	}

	@Override
	public int hashCode() {
		return this.box;
	}

	@Override
	public boolean equals(Object obj) {
		if (this.hashCode() == obj.hashCode()) {
			return true;
		} else {
			return false;
		}
	}

}
