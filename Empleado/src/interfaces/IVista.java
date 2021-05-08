package interfaces;

import java.awt.event.ActionListener;

public interface IVista {
	

	void setActionListener(ActionListener actionListener);

	public void setVisibleVentana();

	public void popUpNotConnected();
	
	public String getNroBox();
}
