package persistencia;

import java.io.Serializable;

public class HorarioRegistro implements Serializable {
	private String horaDeRegistro;
	private String Dni;

	public HorarioRegistro() {
		super();
	}

	public HorarioRegistro(String horaDeRegistro, String dni) {
		super();
		this.horaDeRegistro = horaDeRegistro;
		Dni = dni;
	}

	public String getHoraDeRegistro() {
		return horaDeRegistro;
	}

	public void setHoraDeRegistro(String horaDeRegistro) {
		this.horaDeRegistro = horaDeRegistro;
	}

	public String getDni() {
		return Dni;
	}

	public void setDni(String dni) {
		Dni = dni;
	}

}
