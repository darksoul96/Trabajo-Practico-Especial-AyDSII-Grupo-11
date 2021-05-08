package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import gestion_ingreso.Controller_Emisor_Cliente;

public class MainCliente {

	private static String ip;
	private static int port;

	public static void main(String[] args) {
		try {
			File myObj = new File("NetConfig.txt");
			Scanner myReader = new Scanner(myObj);
			ip = myReader.nextLine();
			port = Integer.parseInt(myReader.nextLine());
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("NetConfig.txt not found.");
			e.printStackTrace();
		}
		Controller_Emisor_Cliente emisor = new Controller_Emisor_Cliente(ip, port);

	}

}
