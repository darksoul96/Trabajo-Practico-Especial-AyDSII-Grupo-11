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

public class ControllerComunicacionCliente implements ActionListener, ComunicacionCliente {

	private IVistaCliente view;
	private String DNI;
	private String ip1;
	private String ip2;
	private int port;

	public ControllerComunicacionCliente(String ip1, String ip2, int port) {
		this.ip1 = ip1;
		this.ip2 = ip2;
		this.port = port;

	}

	public void crearVentana() {
		this.view = new VentanaCliente();
		this.view.setVisibleVentana();
		this.view.setActionListener(this);
	}

	public String getIp1() {
		return ip1;
	}

	public String getIp2() {
		return ip2;
	}

	public void setIp2(String ip2) {
		this.ip2 = ip2;
	}

	public void setIp(String ip1) {
		this.ip1 = ip1;
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