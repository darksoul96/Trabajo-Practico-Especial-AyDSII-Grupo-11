package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import comunicacion_server.ComunicacionServer;
import controller_server.ControllerServer;
import repository.OrdenamientoPrioridadStrategy;
import repository.Servidor;

public class MainServidor {

	public static void main(String[] args) {
		int portReceptorCliente = 0;
		int portReceptorEmpleado = 0;
		int portEmisorPantalla = 0;
		String ipPantalla = null;
		String ipMonitor = null;
		String ipLocalServer = null;
		String ipServer2 = null;
		int portMonitor = 0;
		int portMonitor2 = 0;
		try {
			File myObj = new File("NetConfigServidor.txt");
			Scanner myReader = new Scanner(myObj);
			portReceptorCliente = Integer.parseInt(myReader.nextLine());
			portReceptorEmpleado = Integer.parseInt(myReader.nextLine());
			portEmisorPantalla = Integer.parseInt(myReader.nextLine());
			ipPantalla = myReader.nextLine();
			ipMonitor = myReader.nextLine();
			portMonitor = Integer.parseInt(myReader.nextLine());
			portMonitor2 = Integer.parseInt(myReader.nextLine());
			ipLocalServer = myReader.nextLine();
			ipServer2 = myReader.nextLine();
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("NetConfigServidor.txt not found.");
			e.printStackTrace();
		}
		ComunicacionServer comunicador = new ComunicacionServer(portReceptorCliente,
				portReceptorEmpleado, portEmisorPantalla, ipPantalla, ipMonitor, portMonitor, portMonitor2, ipLocalServer, ipServer2);
		ControllerServer controller = new ControllerServer(comunicador);
		controller.ejecutarVentana();
		comunicador.conectarServers();
		Servidor.getInstance().setOrdenadorStrategy(new OrdenamientoPrioridadStrategy());

		System.out.println("SERVIDOR ANDANDO");

	}
}
