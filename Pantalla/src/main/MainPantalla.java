package main;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import comunicacion_pantalla.ComunicacionPantalla;
import controller_pantalla.ControllerPantalla;
import vista_pantalla.VentanaPantalla;

public class MainPantalla {

	public static void main(String[] args) {
		int pantallaSocket = 0;
		try {
			File myObj = new File("NetConfigPantalla.txt");
			Scanner myReader = new Scanner(myObj);
			pantallaSocket = Integer.parseInt(myReader.nextLine());
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("NetConfigPantalla.txt not found.");
			e.printStackTrace();
		}
		ComunicacionPantalla comunicador = new ComunicacionPantalla(pantallaSocket);
		ControllerPantalla controller = new ControllerPantalla(comunicador);
		controller.crearVentana();
		comunicador.recibir();
		
	}

}
