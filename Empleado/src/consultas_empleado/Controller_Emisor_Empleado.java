package consultas_empleado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Controller_Emisor_Empleado implements ActionListener {

	private String strBox;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if (command.equalsIgnoreCase("SeleccionBox")) {
			strBox=e.getClass().getName();
			int i=Integer.parseInt(strBox);
			try {
				Socket socket = new Socket("localhost", 5005);
				OutputStream outputStream = socket.getOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
				objectOutputStream.writeObject(new Empleado(i));
				socket.close();

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		else
			if (command.equalsIgnoreCase("LLAMAR")) {
				try {
					Socket socket = new Socket("localhost", 5005);
					PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		            out.println(strBox);
					out.close();
					socket.close();

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			else
				if (command.equalsIgnoreCase("CONSULTAR")) {
					try {
						Socket socket = new Socket("localhost", 5005);
						PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			            out.println("Consultar");
						out.close();
						socket.close();

					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
		

	}
}
