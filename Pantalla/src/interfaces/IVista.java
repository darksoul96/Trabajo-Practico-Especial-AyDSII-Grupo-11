package interfaces;

import java.awt.event.ActionListener;

public interface IVista {

	
	public void setActionListener(ActionListener actionListener);
	public void setVisibleVentana();
	public void escribeTurno(String dni, String box);
}
