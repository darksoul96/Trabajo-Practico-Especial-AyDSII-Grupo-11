package comunicacion_monitor;

import java.util.concurrent.locks.Lock;

import comunicacion_server.MonitorPackage;
import controller_monitor.ControllerMonitor;
import interfaces.HeartBeat;
import ui_monitor.VentanaMonitor;

public class Monitor implements HeartBeat {
	boolean serverPrimarioOnline;
	boolean serverSecundarioOnline;
	String ipServerPrimario = null;
	String ipServerSecundario = null;
	private static Monitor instance = null;
	private ControllerMonitor controllerMonitor;

	private Monitor() {

	}

	public static Monitor getInstance() {
		if (instance == null) {
			Lock lock;
			if (instance == null) {
				instance = new Monitor();
			}

		}
		return instance;

	}

	public void resetServerPrimario() {
		this.serverPrimarioOnline = false;
		this.ipServerPrimario = null;
		
	}

	public void resetServerSecundario() {
		this.serverSecundarioOnline = false;
		this.ipServerSecundario = null;
	}

	public void conexionSocketPrimario(MonitorPackage paquete) {
		this.serverPrimarioOnline = true;
		this.ipServerPrimario = paquete.getIp();
	}

	public void conexionSocketSecundario(MonitorPackage paquete) {
		this.serverSecundarioOnline = true;
		this.ipServerSecundario = paquete.getIp();

	}

	public void heartBeatTimerServerPrimario() {
		new Thread() {
			public void run() {

			}
		}.start();
	}

	public void heartBeatTimerServerSecundario() {
		new Thread() {
			public void run() {

			}
		}.start();
	}
	
	public void CreaControllerMonitor() {
		controllerMonitor = new ControllerMonitor(); 
	}

}
