package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import comunicacion_empleado.ComunicacionEmpleado;
import controller_empleado.ControllerEmpleado;

public class MainEmpleado {

	private static String localip;
	private static int localport;
	private static String serverip1;
	private static String serverip2;
	private static int serverport;

	public static void main(String[] args) {
		try {
			File myObj = new File("NetConfigEmpleado.txt");
			Scanner myReader = new Scanner(myObj);
			serverip1 = myReader.nextLine();
			serverip2 = myReader.nextLine();
			serverport = Integer.parseInt(myReader.nextLine());
			localip = myReader.nextLine();
			localport = Integer.parseInt(myReader.nextLine());
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("NetConfigEmpleado.txt not found.");
			e.printStackTrace();
		}
		
		ComunicacionEmpleado comunicacionEmpleado = new ComunicacionEmpleado(serverport,serverip1,serverip2,localip,localport);
		ControllerEmpleado controllerEmpleado = new ControllerEmpleado(comunicacionEmpleado);
		controllerEmpleado.crearVentana();
		
	}
}

/*
 * TXT: ip server puerto server ip local puerto local
 */