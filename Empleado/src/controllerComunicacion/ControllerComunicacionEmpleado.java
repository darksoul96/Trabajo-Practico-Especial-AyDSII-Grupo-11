package controllerComunicacion;

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

import javax.swing.JButton;

import comunicacion.OrdenResponsePackage;
import interfaces.ComunicacionEmpleado;
import interfaces.IVistaEmpleado;
import ordenes.Orden;
import ordenes.OrdenFactory;
import vista_empleado.VentanaEmpleado;

public class ControllerComunicacionEmpleado implements ActionListener, ComunicacionEmpleado {

	private String nroBox;
	private IVistaEmpleado view;
	private String localip;
	private String serverip;
	private int serverport;
	private int localport;

	public ControllerComunicacionEmpleado(int serverport, String serverip, String localip, int localport) {
		super();
		this.serverport = serverport;
		this.serverip = serverip;
		this.localport = localport;
		this.localip = localip;
		
	}
	
	public void crearVentana() {
		this.view = new VentanaEmpleado();
		this.view.setVisibleVentana();
		this.view.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) { // Se crea la orden a enviar al server
		OrdenFactory factory = new OrdenFactory();
		Orden orden = null;
		String command = e.getActionCommand();
		if (command.equalsIgnoreCase("SeleccionBox")) {
			nroBox = this.view.getNroBox();
			orden = factory.createOrden("SeleccionBox", nroBox, localip, localport);
		} else if (command.equalsIgnoreCase("LLAMAR")) {
			orden = factory.createOrden("LLAMAR", nroBox, localip, localport);
		} else if (command.equalsIgnoreCase("CONSULTAR")) {
			orden = factory.createOrden("CONSULTAR", nroBox, localip, localport);
		} else if (command.equalsIgnoreCase("CerrarSesion")) {
			orden = factory.createOrden("BAJA", nroBox, localip, localport);
		}
		enviar(orden);
		OrdenResponsePackage respuesta = recibir();
		handle(respuesta);
	}
	
	@Override
	public void enviar(Orden orden) {
		try {// Se envia la orden al server
			Socket socket = new Socket(serverip, serverport);
			OutputStream outputStream = socket.getOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(orden);
			socket.close();

		} catch (Exception e1) {
			e1.printStackTrace();
			this.view.popUpNotConnected();
		}
	}

	@Override
	public OrdenResponsePackage recibir() {
		OrdenResponsePackage respuesta = null;
		try { // SE ABRE UN PUERTO SERVER PARA ESCUCHAR LA RESPUESTA
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
				this.view.popUpSuccessRegistro();
			} else
				this.view.popUpFailureRegistro();
		} else if (respuesta.getType().equals("LLAMAR")) {
			if (respuesta.getSucess() == true) {
				this.view.popUpLlamadaExitosa(respuesta.getInfo());
			} else
				this.view.popUpLlamadaVacia();

		} else if (respuesta.getType().equals("CONSULTAR")) {
			this.view.poUpConsultaExitosa(respuesta.getInfo());
		}
	}

}
