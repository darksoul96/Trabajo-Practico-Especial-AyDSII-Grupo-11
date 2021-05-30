package controller_monitor;

import interfaces.IControllerMonitor;
import ui_monitor.VentanaMonitor;

public class ControllerMonitor implements IControllerMonitor {
	private VentanaMonitor view;
	
	public ControllerMonitor() {
		view=new VentanaMonitor();
	}

	@Override
	public void resetServerPrimario() {
		// TODO Auto-generated method stub
		view.setServerPrimarioOffline();
	}

	@Override
	public void resetServerSecundario() {
		// TODO Auto-generated method stub
		view.setServerSecundarioOffline();
	}

	@Override
	public void conexionServerPrimario(String ipPrimario) {
		// TODO Auto-generated method stub
		view.setServerPrimarioOnline(ipPrimario);
	}

	@Override
	public void conexionServerSecundario(String ipSecundario) {
		// TODO Auto-generated method stub
		view.setServerSecundarioOnline(ipSecundario);
	}
	
	
}
