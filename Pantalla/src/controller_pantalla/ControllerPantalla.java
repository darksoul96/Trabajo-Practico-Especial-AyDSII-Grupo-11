package controller_pantalla;

import comunicacion_ingreso.Cliente;
import comunicacion_pantalla.ComunicacionPantalla;
import interfaces.IComunicacionPantalla;
import interfaces.IExhibicion;
import interfaces.IVistaPantalla;
import vista_pantalla.VentanaPantalla;

public class ControllerPantalla implements IExhibicion  {

	private IComunicacionPantalla comunicador;
	private IVistaPantalla view;
	
	
	public ControllerPantalla(ComunicacionPantalla comunicador) {
		this.comunicador = comunicador;
		this.comunicador.setController(this);
	}
	public void crearVentana() {
		this.view = new VentanaPantalla();
		this.view.setVisibleVentana();
	}
	@Override
	public void mostrarPantalla(Cliente cliente) {
		if (!comunicador.getUltimoClienteLlamado().equals(cliente.getDNI())) {
			this.view.escribeTurno(cliente.getNombre(), cliente.getBox());
			comunicador.setUltimoClienteLlamado(cliente.getDNI());
		}
	}
}
