package interfaces;

import comunicacion_server.OrdenResponsePackage;
import ordenes.Orden;

public interface ComunicacionEmpleado {

	public OrdenResponsePackage recibir();
	public void enviar(Orden orden);
}
