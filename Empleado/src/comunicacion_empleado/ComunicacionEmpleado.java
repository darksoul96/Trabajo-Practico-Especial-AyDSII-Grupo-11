package comunicacion_empleado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;

import controller_empleado.ControllerEmpleado;
import interfaces.IComunicacionEmpleado;
import interfaces.IVistaEmpleado;
import ordenes.Orden;
import ordenes.OrdenFactory;
import paquetes.OrdenResponsePackage;
import ui_empleado.VentanaEmpleado;

public class ComunicacionEmpleado implements IComunicacionEmpleado {

	private String nroBox;
	private String localip;
	private String serverip1;
	private String serverip2;
	private String ipServerOnline;
	private int serverport;
	private int localport;
	private boolean serverOnline = true;
	private boolean registrado;
	private ControllerEmpleado controller;

	public ComunicacionEmpleado(int serverport, String serverip1, String serverip2, String localip, int localport) {
		super();
		this.serverport = serverport;
		this.serverip1 = serverip1;
		this.serverip2 = serverip2;
		this.localport = localport;
		this.localip = localip;
		this.registrado = false;
		this.ipServerOnline = serverip1;

	}

	@Override
	public void setController(ControllerEmpleado controller) {
		this.controller = controller;

	}

	@Override
	public synchronized void enviar(Orden orden) {
		boolean mostro = false;
		int reconnectTime = 2;
		int serversLeftToTest = 2;
		boolean noPudoConectar = true;
		while (serversLeftToTest != 0 && noPudoConectar) {
			try { // Se envia la orden al server
				Socket socket = new Socket(ipServerOnline, serverport);
				OutputStream outputStream = socket.getOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
				objectOutputStream.writeObject(orden);
				noPudoConectar = false;
				serverOnline = true;
				socket.close();

			} catch (Exception e1) {
				System.out.println("Reintentando");
				reconnectTime += 2;
				if (reconnectTime >= 8) {
					if (ipServerOnline.equals(serverip1)) {
						ipServerOnline = serverip2;
						reconnectTime = 2;
					} else {
						if (ipServerOnline.equals(serverip2)) {
							ipServerOnline = serverip1;
							reconnectTime = 2;
						}
					}
					serversLeftToTest--;
				}
			}

		}
		if (noPudoConectar) {
			System.out.println(" NO PUDO CONECTAR");
			serverOnline = false;
			controller.setServerOffline();
			controller.popUpNotConnected();
		}

	}

	@Override
	public OrdenResponsePackage recibir() {
		OrdenResponsePackage respuesta = null;
		try { // SE ABRE UN PUERTO PARA ESCUCHAR LA RESPUESTA DEL SERVER
			ServerSocket s = new ServerSocket(localport);
			while (true) {
				Socket soc = s.accept();
				InputStream inputStream = soc.getInputStream();
				ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
				respuesta = (OrdenResponsePackage) objectInputStream.readObject();
				s.close();

			}
		} catch (Exception e2) {
			e2.getStackTrace(); 
		}
		return respuesta;
	}

	public void handle(OrdenResponsePackage respuesta) {
		if (respuesta.getType().equals("REGISTRAR")) {
			if (respuesta.getSucess() == true) {
				this.nroBox = respuesta.getInfo();
				this.registrado = true;
				controller.popUpSuccessRegistro();
			} else
				controller.popUpFailureRegistro();
		} else if (respuesta.getType().equals("LLAMAR")) {
			if (respuesta.getSucess() == true) {
				controller.popUpLlamadaExitosa(
						respuesta.getCliente().getNombre() + "\nDNI: " + respuesta.getCliente().getDNI());
			} else
				controller.popUpLlamadaVacia();

		} else if (respuesta.getType().equals("CONSULTAR")) {
			controller.poUpConsultaExitosa(respuesta.getInfo());
		}
	}

	public String getNroBox() {
		return nroBox;
	}

	public String getLocalip() {
		return localip;
	}

	public String getServerip1() {
		return serverip1;
	}

	public String getServerip2() {
		return serverip2;
	}

	public String getIpServerOnline() {
		return ipServerOnline;
	}

	public int getServerport() {
		return serverport;
	}

	public int getLocalport() {
		return localport;
	}

	public boolean isServerOnline() {
		return serverOnline;
	}

	public boolean isRegistrado() {
		return registrado;
	}

	public void setRegistrado(boolean b) {
		this.registrado = b;
	}

}
