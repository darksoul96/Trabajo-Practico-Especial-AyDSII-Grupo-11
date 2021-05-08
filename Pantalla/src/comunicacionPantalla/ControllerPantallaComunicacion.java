package comunicacionPantalla;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ControllerPantallaComunicacion implements ActionListener {

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
