package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import gestion_ingreso.Controller_Emisor_Cliente;

public class MainCliente {

	public static void main(String[] args) {
		try {
			File myObj = new File("NetConfig.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		Controller_Emisor_Cliente emisor = new Controller_Emisor_Cliente("localhost",5005);

	}

}
