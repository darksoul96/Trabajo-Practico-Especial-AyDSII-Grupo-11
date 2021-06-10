package interfaces;

import controller_empleado.ControllerEmpleado;
import ordenes.Orden;
import paquetes.OrdenResponsePackage;

public interface IComunicacionEmpleado {

	public OrdenResponsePackage recibir();

	public void enviar(Orden orden);

	public void handle(OrdenResponsePackage respuesta);
	
	public void setController(ControllerEmpleado controller);

	public String getNroBox();

	public String getLocalip();

	public String getServerip1();

	public String getServerip2();

	public String getIpServerOnline();

	public int getServerport();

	public int getLocalport();

	public boolean isServerOnline();

	public boolean isRegistrado();

	public void setRegistrado(boolean b);
}
