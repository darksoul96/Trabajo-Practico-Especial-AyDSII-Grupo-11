package interfaces;

import ordenes.Orden;
import paquetes.OrdenResponsePackage;

public interface ComunicacionEmpleado {

	public OrdenResponsePackage recibir();
	public void enviar(Orden orden);
}
