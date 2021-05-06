package modulo_comunicacion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Receptor_server {

	private void recibir() {
		try {
			ServerSocket serverSocket = new ServerSocket();
			while (true) {
				Socket socket = serverSocket.accept();
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out.println("TEXTO RECIBIDO");
				out.close();
				socket.close();
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
