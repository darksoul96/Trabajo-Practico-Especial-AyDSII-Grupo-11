package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import comunicacion_monitor.ComunicacionMonitor;
import modelo_monitor.Monitor;
import ui_monitor.VentanaMonitor;

public class MainMonitor {
	static String ipServer1;
	static String ipServer2;
	static int portLocalPrimario;
	static int portLocalSecundario;

	public static void main(String[] args) {
		
		Monitor.getInstance().CreaControllerMonitor();
		try {
			File myObj = new File("NetConfigMonitor.txt");
			Scanner myReader = new Scanner(myObj);
			portLocalPrimario = Integer.parseInt(myReader.nextLine());
			portLocalSecundario = Integer.parseInt(myReader.nextLine());
			ipServer1 = myReader.nextLine();
			ipServer2 = myReader.nextLine();
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("NetConfigMonitor.txt not found.");
			e.printStackTrace();
		}
		ComunicacionMonitor comunicacionMonitor = new ComunicacionMonitor(ipServer1, ipServer2, portLocalPrimario, portLocalSecundario);
		comunicacionMonitor.recibir();
		
		
	}

}
