package interfaces;

import ordenes.Orden;
import paquetes.OrdenResponsePackage;

public interface IComunicacionEmpleado {

	public OrdenResponsePackage recibir();
	public void enviar(Orden orden);
}
