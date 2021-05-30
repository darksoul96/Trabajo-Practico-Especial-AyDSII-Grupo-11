package comunicacion_monitor;

import java.util.concurrent.locks.Lock;

import comunicacion_server.MonitorPackage;
import controller_monitor.ControllerMonitor;
import interfaces.HeartBeat;

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

		controllerMonitor.resetServerPrimario();

		

	}

	public void resetServerSecundario() {
		this.serverSecundarioOnline = false;
		this.ipServerSecundario = null;
		controllerMonitor.resetServerSecundario();
	}

	public void conexionServerPrimario(MonitorPackage paquete) {
		this.serverPrimarioOnline = true;
		this.ipServerPrimario = paquete.getIp();
		controllerMonitor.conexionServerPrimario(paquete.getIp());
	}

	public void conexionServerSecundario(MonitorPackage paquete) {
		this.serverSecundarioOnline = true;
		this.ipServerSecundario = paquete.getIp();
		controllerMonitor.conexionServerSecundario(paquete.getIp());
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
