package comunicacion_monitor;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import comunicacion_server.MonitorPackage;
import interfaces.IComunicacionMonitor;

public class ComunicacionMonitor implements IComunicacionMonitor {

	String ipServer1;
	String ipServer2;
	int portServer1;
	int portServer2;
	int portLocal;

	@Override
	public void recibir() {
		new Thread() {
			public void run() {
				try { // Abro socket para escuchar Servidores
					ServerSocket s = new ServerSocket(portLocal);
					while (true) {
						Socket soc = s.accept();
						InputStream inputStream = soc.getInputStream();
						ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
						MonitorPackage monitorPackage = (MonitorPackage) objectInputStream.readObject();

					}
				} catch (Exception e) {

				}
			}
		}.start();

	}

}
