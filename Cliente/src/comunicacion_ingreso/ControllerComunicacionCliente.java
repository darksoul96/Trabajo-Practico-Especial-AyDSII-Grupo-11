package comunicacion_ingreso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import interfaces.IComunicacionCliente;
import interfaces.IVistaCliente;
import ui_cliente.PopUpReintentar;
import ui_cliente.VentanaCliente;

public class ControllerComunicacionCliente implements ActionListener, IComunicacionCliente {

	private IVistaCliente view;
	private String DNI;
	private String ip1;
	private String ip2;
	private String ipServerOnline;
	private int port;

	public ControllerComunicacionCliente(String ip1, String ip2, int port) {
		this.ip1 = ip1;
		this.ip2 = ip2;
		this.port = port;
		this.ipServerOnline = ip1;

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
			this.DNI = DNI.replaceAll("[^0-9]", "");
			Cliente client = new Cliente(DNI);
			client.setHorarioRegistro(ZonedDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE) + " "
					+ ZonedDateTime.now().truncatedTo(ChronoUnit.MINUTES).format(DateTimeFormatter.ISO_LOCAL_TIME));
			enviarCliente(client);
		}

	}

	public void enviarCliente(Cliente cliente) {
		boolean mostro = false;
		int reconnectTime = 2;
		int serversLeftToTest = 2;
		boolean noPudoConectar = true;
		while (serversLeftToTest != 0 && noPudoConectar) {
			try {
				SocketAddress sa = new InetSocketAddress(ipServerOnline, 5005);
				Socket socket = new Socket();
				socket.connect(sa);
				OutputStream outputStream = socket.getOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
				objectOutputStream.writeObject(cliente);
				System.out.println("Envie el objeto");
				InputStream inputStream = socket.getInputStream();
				ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
				Cliente client = (Cliente) objectInputStream.readObject();
				if (client == null) {
					view.popUpNoRegistrado();
				} else {
					view.popUpExitoRegistro(client.getNombre());
				}
				noPudoConectar = false;
				socket.close();

			} catch (Exception e1) {

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				reconnectTime += 2;
				if (reconnectTime >= 4) {
					if (ipServerOnline.equals(ip1)) {
						ipServerOnline = ip2;
						reconnectTime = 2;
					} else {
						if (ipServerOnline.equals(ip2)) {
							ipServerOnline = ip1;
							reconnectTime = 2;
						}
					}
					serversLeftToTest--;
				}
			}

		}

		if (noPudoConectar) {
			view.popUpNotConnected();
		}

	}

}