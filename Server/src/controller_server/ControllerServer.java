package controller_server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import interfaces.IComunicacionServer;
import interfaces.IVistaServer;
import repository.OrdenamientoDNIStrategy;
import repository.OrdenamientoLlegadaStrategy;
import repository.OrdenamientoPrioridadStrategy;
import repository.Servidor;
import ui_server.VentanaServer;

public class ControllerServer implements ActionListener {

	private IVistaServer ventanaServer;
	private IComunicacionServer comunicador;

	public ControllerServer(IComunicacionServer comunicador) {
		super();
		this.comunicador = comunicador;
		this.comunicador.setController(this);
	}

	public void ejecutarVentana() {
		ventanaServer = new VentanaServer();
		this.ventanaServer.setVisibleVentana();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equalsIgnoreCase("Prioridad")) {
			Servidor.getInstance().setOrdenadorStrategy(new OrdenamientoPrioridadStrategy());
		} else if (command.equalsIgnoreCase("Llegada")) {
			Servidor.getInstance().setOrdenadorStrategy(new OrdenamientoLlegadaStrategy());
		} else if (command.equalsIgnoreCase("DNI")) {
			Servidor.getInstance().setOrdenadorStrategy(new OrdenamientoDNIStrategy());

		}
	}

	public void setSecundario() {
		ventanaServer.setSecundario();

	}

	public void setPrimario() {
		ventanaServer.setPrimario();

	}
}
