package comunicacionPantalla;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import vista_pantalla.VentanaPantalla;

public class ControllerPantallaComunicacion implements ActionListener {

	private VentanaPantalla view;
	
	public ControllerPantallaComunicacion() {
		this.view = new VentanaPantalla();
		this.view.setActionListener(this);
		this.view.setVisibleVentana();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			ServerSocket s = new ServerSocket(5200);
			while (true) {
				Socket soc = s.accept();
				InputStream inputStream = soc.getInputStream();
				ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

			}
		} catch (Exception e2) {
			e2.getStackTrace();
		}
	}
}
