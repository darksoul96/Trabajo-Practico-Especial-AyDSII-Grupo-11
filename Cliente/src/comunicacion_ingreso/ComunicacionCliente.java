package comunicacion_ingreso;

import java.io.InputStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import java.net.*;

import controller_cliente.ControllerCliente;
import interfaces.IComunicacionCliente;

public class ComunicacionCliente implements IComunicacionCliente {

	private ControllerCliente controller;

	private String ip1;
	private String ip2;
	private String ipServerOnline;
	private int port;

	public ComunicacionCliente(String ip1, String ip2, int port) {
		this.ip1 = ip1;
		this.ip2 = ip2;
		this.port = port;
		this.ipServerOnline = ip1;

	}

	public ControllerCliente getController() {
		return controller;
	}

	public void setController(ControllerCliente controller) {
		this.controller = controller;
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

	public void enviarCliente(Cliente cliente) {
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
				InputStream inputStream = socket.getInputStream();
				ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
				Cliente client = (Cliente) objectInputStream.readObject();
				if (client == null) {
					controller.popUpNoRegistrado();
				} else {
					controller.popUpExitoRegistro(client.getNombre());
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
			controller.popUpNotConnected();
		}

	}

}