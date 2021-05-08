package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import controllerComunicacion.ControllerComunicacionEmpleado;

public class MainEmpleado {

	private static String localip;
	private static int localport;
	private static String serverip;
	private static int serverport;

	public static void main(String[] args) {
		try {
			File myObj = new File("NetConfig.txt");
			Scanner myReader = new Scanner(myObj);
			serverip = myReader.nextLine();
			serverport = Integer.parseInt(myReader.nextLine());
			localip = myReader.nextLine();
			localport = Integer.parseInt(myReader.nextLine());
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("NetConfig.txt not found.");
			e.printStackTrace();
		}
		
		ControllerComunicacionEmpleado EmisorEmpleado = new ControllerComunicacionEmpleado(serverport,serverip,localip,localport);
	}
}

/*
 * TXT: ip server puerto server ip local puerto local
 */