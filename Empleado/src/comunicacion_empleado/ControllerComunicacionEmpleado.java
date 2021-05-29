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

import comunicacion_server.OrdenResponsePackage;
import interfaces.ComunicacionEmpleado;
import interfaces.IVistaEmpleado;
import ordenes.Orden;
import ordenes.OrdenFactory;
import ui_empleado.VentanaEmpleado;

public class ControllerComunicacionEmpleado implements ActionListener, ComunicacionEmpleado {

	private String nroBox;
	private IVistaEmpleado view;
	private String localip;
	private String serverip1;
	private String serverip2;
	private String ipServerOnline;
	private int serverport;
	private int localport;
	private boolean serverOnline = true;
	private boolean registrado;

	public ControllerComunicacionEmpleado(int serverport, String serverip1, String serverip2, String localip,
			int localport) {
		super();
		this.serverport = serverport;
		this.serverip1 = serverip1;
		this.serverip2 = serverip2;
		this.localport = localport;
		this.localip = localip;
		this.registrado = false;
		this.ipServerOnline = serverip1;

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
			orden = factory.createOrden("SeleccionBox", view.getNroBox(), localip, localport);
		} else if (this.registrado) {
			if (command.equalsIgnoreCase("LLAMAR")) {
				orden = factory.createOrden("LLAMAR", nroBox, localip, localport);
			} else if (command.equalsIgnoreCase("CONSULTAR")) {
				orden = factory.createOrden("CONSULTAR", nroBox, localip, localport);
			} else if (command.equalsIgnoreCase("CerrarSesion")) {
				orden = factory.createOrden("BAJA", nroBox, localip, localport);
				this.registrado = false;
			}
		}
		if (orden != null)
			enviar(orden);
		if (this.serverOnline && orden != null) {
			OrdenResponsePackage respuesta = recibir();
			handle(respuesta);
		}

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
				System.out.println("Le mando mensajito al servidor");
				socket.close();

			} catch (Exception e1) {

				if (!mostro) {
					// view.muestraBarraReintentar();
					mostro = true;
				}
				try {
					System.out.println("Reintentando");
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

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
			System.out.println("SYSO DE NO PUDO CONECTAR");
			serverOnline = false;
			// view.setServerOffline();
			// view.popUpNotConnected();
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
