package comunicacionServer;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import consultas_empleado.Orden;
import gestion_ingreso.Cliente;
import gestion_turnos.Servidor;

public class Receptor_server {
	int portReceptorCliente;
	int portReceptorEmpleado;
	int portEmisorPantalla;
	String ipPantalla;

	public Receptor_server(int portReceptorCliente, int portReceptorEmpleado, int portEmisorPantalla,
			String ipPantalla) {
		super();
		this.portReceptorCliente = portReceptorCliente;
		this.portReceptorEmpleado = portReceptorEmpleado;
		this.portEmisorPantalla = portEmisorPantalla;
		this.ipPantalla = ipPantalla;
	}

	public void recibir() { // Abro el server para recibir
		PackageHandler packageHandler = new PackageHandler();
		new Thread() {
			public void run() { // Puerto para recibir peticiones desde la Estacion Cliente
				try {
					ServerSocket s = new ServerSocket(5005);
					while (true) {
						Socket soc = s.accept();
						InputStream inputStream = soc.getInputStream();
						ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
						Cliente client = (Cliente) objectInputStream.readObject();
						packageHandler.handle(client);
					}
				} catch (Exception e) {

				}
			}
		}.start();
		new Thread() {
			public void run() { // Abro puerto para recibir peticiones desde los Boxes
				try {
					ServerSocket s = new ServerSocket(5006);
					while (true) {
						Socket soc = s.accept();
						InputStream inputStream = soc.getInputStream();
						ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
						Orden orden = (Orden) objectInputStream.readObject();
						OrdenResponsePackage response = packageHandler.handle(orden);
						enviarBox(orden, response);
						if (response.type.equals("LLAMAR")) {
							enviarPantalla(Servidor.getInstance().getLastCalledClient());
						}

					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	public void enviarBox(Orden orden, OrdenResponsePackage response) { // Me intento comunicar con el box
		try {
			Socket socket = new Socket(orden.getIp(), orden.getPort());
			OutputStream outputStream = socket.getOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(response);
			socket.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void enviarPantalla(Cliente cliente) {
		try {
			Socket socket = new Socket("localhost", 5200);
			OutputStream outputStream = socket.getOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(cliente);
			socket.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}
