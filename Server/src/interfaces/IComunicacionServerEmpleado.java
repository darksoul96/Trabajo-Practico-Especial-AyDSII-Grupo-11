package interfaces;

import ordenes.Orden;
import paquetes.OrdenResponsePackage;

public interface IComunicacionServerEmpleado {

	public void recibirEmpleado();
	public void enviarBox(Orden orden, OrdenResponsePackage response);
}
