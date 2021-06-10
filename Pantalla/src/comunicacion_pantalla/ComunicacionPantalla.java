package comunicacion_pantalla;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import comunicacion_ingreso.Cliente;
import controller_pantalla.ControllerPantalla;
import interfaces.IComunicacionPantalla;
import interfaces.IExhibicion;
import vista_pantalla.VentanaPantalla;

public class ComunicacionPantalla implements IComunicacionPantalla{
	int pantallaSocket;
	String ultimoClienteLlamado = "";
	private ControllerPantalla controller;

	public ComunicacionPantalla(int pantallaSocket) {
		this.pantallaSocket = pantallaSocket;
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
						controller.mostrarPantalla(client);
					}

				} catch (Exception e) {

				}
			}
		}.start();
	}

	@Override
	public String getUltimoClienteLlamado() {
		return this.ultimoClienteLlamado;
	}

	@Override
	public void setUltimoClienteLlamado(String clienteDni) {
		this.ultimoClienteLlamado = clienteDni;
		
	}



	@Override
	public void setController(ControllerPantalla controller) {
		this.controller = controller;
		
	}

}
