package controller_empleado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import interfaces.IComunicacionEmpleado;
import interfaces.IVistaEmpleado;
import ordenes.Orden;
import ordenes.OrdenFactory;
import paquetes.OrdenResponsePackage;
import ui_empleado.VentanaEmpleado;

public class ControllerEmpleado implements ActionListener {
	private IVistaEmpleado view;
	private IComunicacionEmpleado comunicador;

	public ControllerEmpleado(IComunicacionEmpleado comunicador) {
		super();
		this.comunicador = comunicador;
		comunicador.setController(this);
	}

	public void crearVentana() {
		this.view = new VentanaEmpleado();
		this.view.setVisibleVentana();
		this.view.setActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) { // Se crea la orden a enviar al server
		OrdenFactory factory = new OrdenFactory();
		Orden orden = null;
		String command = e.getActionCommand();
		if (command.equalsIgnoreCase("SeleccionBox")) {
			orden = factory.createOrden("SeleccionBox", view.getNroBox(), comunicador.getLocalip(),
					comunicador.getLocalport());
		} else if (comunicador.isRegistrado()) {
			if (command.equalsIgnoreCase("LLAMAR")) {
				orden = factory.createOrden("LLAMAR", comunicador.getNroBox(), comunicador.getLocalip(),
						comunicador.getLocalport());
			} else if (command.equalsIgnoreCase("CONSULTAR")) {
				orden = factory.createOrden("CONSULTAR", comunicador.getNroBox(), comunicador.getLocalip(),
						comunicador.getLocalport());
			} else if (command.equalsIgnoreCase("CerrarSesion")) {
				orden = factory.createOrden("BAJA", comunicador.getNroBox(), comunicador.getLocalip(),
						comunicador.getLocalport());
				comunicador.setRegistrado(false);
			}
		}
		if (orden != null)
			comunicador.enviar(orden);
		if (comunicador.isServerOnline() && orden != null) {
			OrdenResponsePackage respuesta = comunicador.recibir();
			comunicador.handle(respuesta);
		}

	}

	public void setServerOffline() {
		view.setServerOffline();
	}

	public void popUpNotConnected() {
		view.popUpNotConnected();
	}

	public void popUpSuccessRegistro() {
		this.view.popUpSuccessRegistro();
	}

	public void popUpFailureRegistro() {
		this.view.popUpFailureRegistro();
	}

	public void popUpLlamadaExitosa(String string) {
		this.view.popUpLlamadaExitosa(string);

	}

	public void popUpLlamadaVacia() {
		this.view.popUpLlamadaVacia();

	}

	public void poUpConsultaExitosa(String info) {
		this.view.poUpConsultaExitosa(info);

	}

}
