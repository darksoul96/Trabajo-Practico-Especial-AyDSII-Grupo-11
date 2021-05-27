package interfaces;

import java.awt.event.ActionListener;

public interface IVistaEmpleado {
	

	void setActionListener(ActionListener actionListener);

	public void setVisibleVentana();

	public void popUpNotConnected();
	
	public String getNroBox();
	
	public void popUpSuccessRegistro();
	
	public void popUpFailureRegistro();
	
	public void popUpLlamadaVacia();
	
	public void popUpLlamadaExitosa(String dni);
	
	public void poUpConsultaExitosa(String cantidad);
	
	public void setServerOffline();
	
}
