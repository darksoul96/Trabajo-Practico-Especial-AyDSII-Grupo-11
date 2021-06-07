package comunicacion_pantalla;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import comunicacion_ingreso.Cliente;
import interfaces.IComunicacionPantalla;
import interfaces.IExhibicion;
import vista_pantalla.VentanaPantalla;

public class ControllerComunicacionPantalla implements IComunicacionPantalla, IExhibicion {
	int pantallaSocket;
	String ultimoClienteLlamado = "";
	private VentanaPantalla view;

	public ControllerComunicacionPantalla(int pantallaSocket) {
		this.pantallaSocket = pantallaSocket;
	}

	public void crearVentana() {
		this.view = new VentanaPantalla();
		this.view.setVisibleVentana();
	}

	@Override
	public void recibir() {
		new Thread() {
			public void run() {
				try {
					ServerSocket s = new ServerSocket(pantallaSocket);
					while (true) {
						Socket soc = s.accept();
						InputStream inputStream = soc.getInputStream();
						ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
						Cliente client = (Cliente) objectInputStream.readObject();
						mostrarPantalla(client);
					}

				} catch (Exception e) {

				}
			}
		}.start();
	}

	@Override
	public void mostrarPantalla(Cliente cliente) {
		if (!ultimoClienteLlamado.equals(cliente.getDNI())) {
			this.view.escribeTurno(cliente.getDNI(), cliente.getBox());
			this.ultimoClienteLlamado = cliente.getDNI();
		}
	}

}
