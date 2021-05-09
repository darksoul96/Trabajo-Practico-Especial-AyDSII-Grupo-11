package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import comunicacion.ServerCommunication;
import repository.Servidor;

public class MainServidor {

	public static void main(String[] args) {
		int portReceptorCliente = 0;
		int portReceptorEmpleado = 0;
		int portEmisorPantalla = 0;
		String ipPantalla = null;
		try {
			File myObj = new File("NetConfig.txt");
			Scanner myReader = new Scanner(myObj);
			portReceptorCliente = Integer.parseInt(myReader.nextLine());
			portReceptorEmpleado = Integer.parseInt(myReader.nextLine());
			portEmisorPantalla = Integer.parseInt(myReader.nextLine());
			ipPantalla = myReader.nextLine();
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("NetConfig.txt not found.");
			e.printStackTrace();
		}
		ServerCommunication receptor = new ServerCommunication(portReceptorCliente, portReceptorEmpleado, portEmisorPantalla,
				ipPantalla);
		receptor.recibir();
		System.out.println("SERVIDOR ANDANDO");
	}
}
