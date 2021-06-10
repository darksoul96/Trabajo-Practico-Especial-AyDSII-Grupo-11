package main;

import java.io.File;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import comunicacion_ingreso.ComunicacionCliente;
import controller_cliente.ControllerCliente;

public class MainCliente {

	private static String ip1;
	private static String ip2;
	private static int port;

	public static void main(String[] args) {
		try {
			File myObj = new File("NetConfigCliente.txt");
			Scanner myReader = new Scanner(myObj);
			ip1 = myReader.nextLine();
			ip2 = myReader.nextLine();
			port = Integer.parseInt(myReader.nextLine());
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("NetConfigCliente.txt not found.");
			e.printStackTrace();
		}
		ComunicacionCliente emisor = new ComunicacionCliente(ip1, ip2, port);
		ControllerCliente controller = new ControllerCliente(emisor);
		controller.crearVentana();
	}

}
