package consultas_empleado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import interfaces.IVista;
import vista_cliente.VentanaCliente;
import vista_empleado.VentanaEmpleado;

public class Controller_Emisor_Empleado implements ActionListener {

	private String strBox;
	private IVista view;
	
	

	public Controller_Emisor_Empleado() {
		super();		
		this.view = new VentanaEmpleado();
		this.view.setActionListener(this);
		this.view.setVisibleVentana();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if (command.equalsIgnoreCase("SeleccionBox")) {
			strBox = e.getClass().getName();
			int i = Integer.parseInt(strBox);
			try {
				Socket socket = new Socket("localhost", 5006);
				OutputStream outputStream = socket.getOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
				objectOutputStream.writeObject(i);
				socket.close();

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (command.equalsIgnoreCase("LLAMAR")) {
			try {
				Socket socket = new Socket("localhost", 5006);
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out.println(strBox);
				out.close();
				socket.close();

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (command.equalsIgnoreCase("CONSULTAR")) {
			try {
				Socket socket = new Socket("localhost", 5006);
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
