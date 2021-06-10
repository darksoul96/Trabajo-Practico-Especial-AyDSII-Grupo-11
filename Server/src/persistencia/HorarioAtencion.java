package persistencia;

import java.io.Serializable;

public class HorarioAtencion implements Serializable {

	String dni;
	String horaDeAtencion;
	String boxAtencion;

	public HorarioAtencion() {
		super();
	}

	public HorarioAtencion(String horarioAtencion, String dni, String box) {
		this.dni = dni;
		this.horaDeAtencion=horarioAtencion;
		this.boxAtencion = box;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getHoraDeAtencion() {
		return horaDeAtencion;
	}

	public void setHoraDeAtencion(String horaDeAtencion) {
		this.horaDeAtencion = horaDeAtencion;
	}

	public String getBoxAtencion() {
		return boxAtencion;
	}

	public void setBoxAtencion(String boxAtencion) {
		this.boxAtencion = boxAtencion;
	}
	
	
	
}
