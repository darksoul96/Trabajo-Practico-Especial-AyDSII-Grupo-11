package comunicacion_monitor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.locks.Lock;

import interfaces.ComunicacionMonitor;

public class ControllerComunicacionMonitor implements ComunicacionMonitor {

	String ipServer1;
	String ipServer2;
	int portServer1;
	int portServer2;
	int portLocal;

	@Override
	public void recibir() {
		new Thread() {
			public void run() {
				try {
					ServerSocket s = new ServerSocket(portLocal);
					while (true) {
						Socket soc = s.accept();
						BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
						
					}
				} catch (Exception e) {

				}
			}
		}.start();

	}

	@Override
	public void ping() {

	}

}
