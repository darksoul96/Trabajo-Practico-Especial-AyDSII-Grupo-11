package modulo_comunicacion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Receptor_server {

	public void recibir() {
		new Thread() {
			public void run() {
				try {
					ServerSocket s = new ServerSocket(5005);
					while(true) {
						Socket soc = s.accept();
						PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
						BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
						String msg = in.readLine();
						System.out.println(msg);
					}
				}
				catch(Exception e) {
					
				}
			}
		}
		.start();
	}
}
