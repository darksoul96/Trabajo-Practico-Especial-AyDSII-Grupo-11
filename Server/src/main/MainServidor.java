package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import comunicacion_server.ControllerComunicacionServer;
import repository.Servidor;

public class MainServidor {

	public static void main(String[] args) {
		int portReceptorCliente = 0;
		int portReceptorEmpleado = 0;
		int portEmisorPantalla = 0;
		String ipPantalla = null;
		try {
			File myObj = new File("NetConfigServidor.txt");
			Scanner myReader = new Scanner(myObj);
			portReceptorCliente = Integer.parseInt(myReader.nextLine());
			portReceptorEmpleado = Integer.parseInt(myReader.nextLine());
			portEmisorPantalla = Integer.parseInt(myReader.nextLine());
			ipPantalla = myReader.nextLine();
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("NetConfigServidor.txt not found.");
			e.printStackTrace();
		}
		ControllerComunicacionServer receptor = new ControllerComunicacionServer(portReceptorCliente, portReceptorEmpleado, portEmisorPantalla,
				ipPantalla);
		receptor.conectarServers();
		receptor.ejecutarVentana();
		
		System.out.println("SERVIDOR ANDANDO");
		
		
	}
}
