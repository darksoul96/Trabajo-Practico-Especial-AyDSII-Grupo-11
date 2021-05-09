package controllerComunicacion;

import comunicacion.OrdenResponsePackage;
import ordenes.Orden;

public interface ComunicacionEmpleado {

	public OrdenResponsePackage recibir();
	public void enviar(Orden orden);
}
