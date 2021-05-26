package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import comunicacion_ingreso.ControllerComunicacionCliente;

public class MainCliente {

	private static String ip;
	private static int port;

	public static void main(String[] args) {
		try {
			File myObj = new File("NetConfigCliente.txt");
			Scanner myReader = new Scanner(myObj);
			ip = myReader.nextLine();
			port = Integer.parseInt(myReader.nextLine());
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("NetConfigCliente.txt not found.");
			e.printStackTrace();
		}
		ControllerComunicacionCliente emisor = new ControllerComunicacionCliente(ip, port);
		emisor.crearVentana();

		
	}

}
