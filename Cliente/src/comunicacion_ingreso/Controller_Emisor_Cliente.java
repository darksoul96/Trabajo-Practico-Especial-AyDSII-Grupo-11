package comunicacion_ingreso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;

import interfaces.ComunicacionCliente;
import interfaces.IVistaCliente;
import ui_cliente.VentanaCliente;

public class Controller_Emisor_Cliente implements ActionListener,ComunicacionCliente {

	private IVistaCliente view;
	private String DNI;
	private String ip;
	private int port;

	public Controller_Emisor_Cliente(String ip, int port) {
		this.ip = ip;
		this.port = port;

	}

	public void crearVentana() {
		this.view = new VentanaCliente();
		this.view.setVisibleVentana();
		this.view.setActionListener(this);
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
			enviarCliente(new Cliente(DNI));
		}

	}

	public void enviarCliente(Cliente cliente) {
		try {
			Socket socket = new Socket("localhost", 5005);
			OutputStream outputStream = socket.getOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(new Cliente(DNI));
			socket.close();

		} catch (Exception e1) {
			view.popUpNotConnected();
		}
	}

}