package consultas_empleado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import interfaces.IVista;
import modulo_comunicacion.OrdenResponsePackage;
import vista_empleado.VentanaEmpleado;

public class Controller_Emisor_Empleado implements ActionListener {

	private String nroBox;
	private IVista view;
	private String ip;

	public Controller_Emisor_Empleado(String ip) {
		super();
		this.ip = ip;
		this.view = new VentanaEmpleado();
		this.view.setActionListener(this);
		this.view.setVisibleVentana();
	}

	@Override
	public void actionPerformed(ActionEvent e) { // Se crea la orden a enviar al server
		OrdenFactory factory = new OrdenFactory();
		Orden orden = null;
		String command = e.getActionCommand();
		if (command.equalsIgnoreCase("SeleccionBox")) {
			JButton a = (JButton) e.getSource();
			nroBox = this.view.getNroBox();
			orden = factory.createOrden("SeleccionBox", nroBox);
		} else if (command.equalsIgnoreCase("LLAMAR")) {
			orden = factory.createOrden("LLAMAR", nroBox);
		} else if (command.equalsIgnoreCase("CONSULTAR")) {
			orden = factory.createOrden("CONSULTAR", nroBox);
		}
		try {// Se envia la orden al server
			Socket socket = new Socket("localhost", 5006);
			OutputStream outputStream = socket.getOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(orden);
			socket.close();

			try { // SE ABRE UN PUERTO SERVER PARA ESCUCHAR LA RESPUESTA
				ServerSocket s = new ServerSocket(5100);
				while (true) {
					Socket soc = s.accept();
					InputStream inputStream = soc.getInputStream();
					ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
					OrdenResponsePackage respuesta = (OrdenResponsePackage) objectInputStream.readObject();

				}
			} catch (Exception e2) {
				this.view.popUpNotConnected();
			}

		} catch (Exception e1) {
			e1.printStackTrace();
			this.view.popUpNotConnected();
		}

	}

	public void handle(OrdenResponsePackage respuesta) {
		if (respuesta.getType() == "REGISTRAR") {
			if (respuesta.getSucess() == true) {
				this.view.popUpSuccessRegistro();
			} else
				this.view.popUpFailureRegistro();
		} else if (respuesta.getType() == "LLAMAR") {
			if (respuesta.getSucess() == true) {
				this.view.popUpLlamadaExitosa(respuesta.getInfo());
			} else
				this.view.popUpLlamadaVacia();

		} else if (respuesta.getType() == "CONSULTAR") {
			this.view.poUpConsultaExitosa(respuesta.getInfo());
		}
	}
}
