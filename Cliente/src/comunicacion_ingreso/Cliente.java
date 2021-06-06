package comunicacion_ingreso;

import java.io.Serializable;

public class Cliente implements Serializable{
	String DNI;
	String box;
	String nombre;
	int prioridad;
	
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
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
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
