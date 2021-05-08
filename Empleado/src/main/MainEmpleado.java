package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import consultas_empleado.Controller_Emisor_Empleado;

public class MainEmpleado {

	private static String localip;
	private static int localport;
	private static String serverip;
	private static int serverport;

	public static void main(String[] args) {

		Controller_Emisor_Empleado EmisorEmpleado = new Controller_Emisor_Empleado("localhost");
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
	}
}

/*
 * TXT: ip server puerto server ip local puerto local
 */