package modulo_comunicacion;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import gestion_ingreso.Cliente;



public class Receptor_server {

	public void recibir() {
		new Thread() {
			public void run() {
				try {
					ServerSocket s = new ServerSocket(5005);
					while(true) {
						Socket soc = s.accept();
						//PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
						//BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
						InputStream inputStream = soc.getInputStream();
						ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
						Cliente client = (Cliente) objectInputStream.readObject();
					}
				}
				catch(Exception e) {
					
				}
			}
		}
		.start();
	}
}
