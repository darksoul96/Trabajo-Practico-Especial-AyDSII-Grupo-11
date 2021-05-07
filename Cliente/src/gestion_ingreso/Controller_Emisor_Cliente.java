package gestion_ingreso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;

import interfaces.IVista;
import vista_cliente.VentanaCliente;

public class Controller_Emisor_Cliente implements ActionListener {

	private IVista view;
	private String DNI;
	private String ip;
	private int port;

	public Controller_Emisor_Cliente(String ip, int port) {
		this.ip = ip;
		this.port = port;
		this.view = new VentanaCliente();
		this.view.setActionListener(this);
		this.view.setVisibleVentana();
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if (command.equalsIgnoreCase("INGRESAR")) {
			this.DNI = (view.getTextoDNI());
			try {
				Socket socket = new Socket("localhost", 5005);
				// PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				// BufferedReader in = new BufferedReader(new
				// InputStreamReader(socket.getInputStream()));
				OutputStream outputStream = socket.getOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
				objectOutputStream.writeObject(new Cliente(DNI));
				socket.close();

			} catch (Exception e1) {
				view.popUpNotConnected();
			}
		}

	}

}