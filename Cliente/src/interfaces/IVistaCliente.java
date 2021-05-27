package interfaces;

import java.awt.event.ActionListener;

public interface IVistaCliente {

	public String getTextoDNI();

	void setActionListener(ActionListener actionListener);

	public void setVisibleVentana();

	public void popUpNotConnected();
	
	public void MuestraPopUpReintentar();
}
