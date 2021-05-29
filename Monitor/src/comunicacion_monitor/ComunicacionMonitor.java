package comunicacion_monitor;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import comunicacion_server.MonitorPackage;
import interfaces.IComunicacionMonitor;

public class ComunicacionMonitor implements IComunicacionMonitor {

	String ipServer1;
	String ipServer2;
	int portLocalPrimario;
	int portLocalSecundario;
	
	
	

	public ComunicacionMonitor(String ipServer1, String ipServer2, int portLocalPrimario, int portLocalSecundario) {
		super();
		this.ipServer1 = ipServer1;
		this.ipServer2 = ipServer2;
		this.portLocalPrimario = portLocalPrimario;
		this.portLocalSecundario = portLocalSecundario;
	}




	@Override
	public void recibir() {
		new Thread() {
			public void run() {
				try { // Abro socket para escuchar Servidor Primario
					System.out.println("Abro socket primario");
					System.out.println(portLocalPrimario);
					ServerSocket s = new ServerSocket(portLocalPrimario);
					while (true) {
						Socket soc = s.accept();
						soc.setSoTimeout(5000);
						InputStream inputStream = soc.getInputStream();
						ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
						MonitorPackage monitorPackage = (MonitorPackage) objectInputStream.readObject();
						Monitor.getInstance().conexionSocketPrimario(monitorPackage);
					}
				} catch (SocketTimeoutException e) {
					e.printStackTrace();
					Monitor.getInstance().resetServerPrimario();
					System.out.println("No hay server primario");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}.start();
		new Thread() { // Abro socket para escuchar Servidor Secundario
			public void run() {
				try {
					ServerSocket s = new ServerSocket(portLocalSecundario);
					while (true) {
						Socket soc = s.accept();
						soc.setSoTimeout(5000);
						InputStream inputStream = soc.getInputStream();
						ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
						MonitorPackage monitorPackage = (MonitorPackage) objectInputStream.readObject();
						Monitor.getInstance().conexionSocketSecundario(monitorPackage);
					}
				} catch (SocketTimeoutException e2) {
					e2.printStackTrace();
					Monitor.getInstance().resetServerSecundario();
					System.out.println("No hay server secundario");
				} catch (Exception e3) {
					e3.printStackTrace();
				}

			}
		}.start();

	}

}
