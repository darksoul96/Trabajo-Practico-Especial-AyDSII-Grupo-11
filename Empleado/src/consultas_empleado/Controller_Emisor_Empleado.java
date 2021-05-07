package consultas_empleado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Controller_Emisor_Empleado implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if (command.equalsIgnoreCase("INGRESAR")) {
			try {
				Socket socket = new Socket("localhost", 5005);
				OutputStream outputStream = socket.getOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
				objectOutputStream.writeObject(new Empleado(1));
				socket.close();

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}
}
