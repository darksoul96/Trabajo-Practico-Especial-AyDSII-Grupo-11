package comunicacion_monitor;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import interfaces.IComunicacionMonitor;
import modelo_monitor.Monitor;
import paquetes.MonitorPackage;
import ui_monitor.VentanaMonitor;

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
				ServerSocket s = null;
				boolean socketPrimarioCreado = false;
				while (true) {
					try { // Abro socket para escuchar Servidor Primario
						if (!socketPrimarioCreado) {
							System.out.println("Abro socket primario");
							s = new ServerSocket(portLocalPrimario);
							socketPrimarioCreado = true;
							s.setSoTimeout(5000);
						}
						Socket soc = s.accept();
						InputStream inputStream = soc.getInputStream();
						ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
						MonitorPackage monitorPackage = (MonitorPackage) objectInputStream.readObject();
						Monitor.getInstance().conexionServerPrimario(monitorPackage);
					} catch (SocketTimeoutException e) {
						// e.printStackTrace();
						Monitor.getInstance().resetServerPrimario();
						System.out.println("No hay server primario");
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		}.start();
		new Thread() { // Abro socket para escuchar Servidor Secundario
			public void run() {
				ServerSocket s = null;
				boolean socketSecundarioCreado = false;
				while (true) {
					try {
						if (!socketSecundarioCreado) {
							s = new ServerSocket(portLocalSecundario);
							socketSecundarioCreado = true;
							s.setSoTimeout(5000);
						}

						Socket soc = s.accept();
						soc.setSoTimeout(5000);
						InputStream inputStream = soc.getInputStream();
						ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
						MonitorPackage monitorPackage = (MonitorPackage) objectInputStream.readObject();
						Monitor.getInstance().conexionServerSecundario(monitorPackage);

					} catch (SocketTimeoutException e2) {
						// e2.printStackTrace();
						Monitor.getInstance().resetServerSecundario();
						System.out.println("No hay server secundario");
					} catch (Exception e3) {
						e3.printStackTrace();
					}
				}
			}
		}.start();

	}

}
