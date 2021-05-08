package interfaces;

import java.awt.event.ActionListener;

public interface IVista {
	

	void setActionListener(ActionListener actionListener);

	public void setVisibleVentana();

	public void popUpNotConnected();
	
	public String getNroBox();
	
	public void popUpSuccessRegistro();
	
	public void popUpFailureRegistro();
	
	public void popUpLlamadaVacia();
	
	public void popUpLlamadaExitosa();
	
	public void poUpConsultaExitosa();
	
}
