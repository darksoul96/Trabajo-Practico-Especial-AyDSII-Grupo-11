package interfaces;

import controller_pantalla.ControllerPantalla;

public interface IComunicacionPantalla {

	public void recibir();
	public String getUltimoClienteLlamado();
	public void setUltimoClienteLlamado(String clienteDni);
	public void setController(ControllerPantalla controller);
}
