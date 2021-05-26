package comunicacion_monitor;

import java.util.concurrent.locks.Lock;

import interfaces.Disponibilidad;

public class Monitor implements Disponibilidad {

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

	@Override
	public boolean primaryServerOnline() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean secondaryServerOnline() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void ping() {
		// TODO Auto-generated method stub
		
	}

}
