package modulo_comunicacion;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import consultas_empleado.Orden;
import gestion_ingreso.Cliente;
import gestion_turnos.Servidor;

public class Receptor_server {

	public void recibir() {
		new Thread() {
			public void run() {
				try {
					ServerSocket s = new ServerSocket(5005);
					while (true) {
						Socket soc = s.accept();
						InputStream inputStream = soc.getInputStream();
						ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
						Cliente client = (Cliente) objectInputStream.readObject();
						Servidor.getInstance().registrarPedidoDeTurno(client);
					}
				} catch (Exception e) {

				}
			}
		}.start();
		new Thread() {
			public void run() {
				try {
					ServerSocket s = new ServerSocket(5006);
					while (true) {
						Socket soc = s.accept();
						InputStream inputStream = soc.getInputStream();
						ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
						Orden client = (Orden) objectInputStream.readObject();
						System.out.println(client.executeOrder());
					}

				} catch (Exception e) {

				}
			}
		}.start();
	}
}
