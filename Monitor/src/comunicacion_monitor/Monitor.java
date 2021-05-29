package comunicacion_monitor;

import java.util.concurrent.locks.Lock;

import comunicacion_server.MonitorPackage;

public class Monitor {
	boolean primaryServer;
	boolean secondaryServer;
	String ipPrimaryServer;
	String ipSecondaryServer;
	private static Monitor instance = null;

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

	public void handle(MonitorPackage monitorPackage) {
		if (monitorPackage.getServerStatus() == true) {
			this.primaryServer = true;
			this.ipPrimaryServer = monitorPackage.getIp();
		}
		else {
			if(monitorPackage.getServerStatus() == false) {
				this.secondaryServer = true;
				this.ipPrimaryServer = monitorPackage.getIp();
			}
		}
	}
}
