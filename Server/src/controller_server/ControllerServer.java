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
		this.ventanaServer.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equalsIgnoreCase("STRATEGY_PRIORIDAD")) {
			Servidor.getInstance().setOrdenadorStrategy(new OrdenamientoPrioridadStrategy());
		} else if (command.equalsIgnoreCase("STRATEGY_LLEGADA")) {
			Servidor.getInstance().setOrdenadorStrategy(new OrdenamientoLlegadaStrategy());
		} else if (command.equalsIgnoreCase("STRATEGY_DNI")) {
			Servidor.getInstance().setOrdenadorStrategy(new OrdenamientoDNIStrategy());

		}
		comunicador.backup();
	}

	public void setSecundario() {
		ventanaServer.setSecundario();

	}

	public void setPrimario() {
		ventanaServer.setPrimario();
	}
}
