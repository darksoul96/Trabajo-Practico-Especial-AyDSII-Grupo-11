package controller_cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import comunicacion_ingreso.Cliente;
import interfaces.IComunicacionCliente;
import interfaces.IVistaCliente;
import ui_cliente.VentanaCliente;

public class ControllerCliente implements ActionListener {
	private IVistaCliente view;
	private IComunicacionCliente comunicador;
	private String DNI;

	public ControllerCliente(IComunicacionCliente comunicador) {
		super();
		this.comunicador = comunicador;
		this.comunicador.setController(this);
	}

	public void crearVentana() {
		this.view = new VentanaCliente();
		this.view.setVisibleVentana();
		this.view.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if (command.equalsIgnoreCase("INGRESAR")) {
			this.DNI = (view.getTextoDNI());
			this.DNI = DNI.replaceAll("[^0-9]", "");
			Cliente client = new Cliente(DNI);
			client.setHorarioRegistro(ZonedDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE) + " "
					+ ZonedDateTime.now().truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_LOCAL_TIME));
			comunicador.enviarCliente(client);
		}

	}

	public void popUpNoRegistrado() {
		view.popUpNoRegistrado();
	}

	public void popUpExitoRegistro(String nombre) {
		view.popUpExitoRegistro(nombre);
	}

	public void popUpNotConnected() {
		view.popUpNotConnected();
	}

}
