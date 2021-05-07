package gestion_ingreso;

import java.io.Serializable;

public class Cliente implements Serializable{
	String DNI;
	String box;
	
	public Cliente(String dNI) {
		super();
		DNI = dNI;
	}

	public String getDNI() {
		return DNI;
	}
	
	public void setBox(String box2) {
		this.box = box2;
	}
	
	public String getBox() {
		return this.box;
	}
	
	@Override
	public String toString() {
		return this.DNI;
	}

	@Override
	public int hashCode() {
		return this.DNI.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(this.hashCode() == obj.hashCode()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	
}
