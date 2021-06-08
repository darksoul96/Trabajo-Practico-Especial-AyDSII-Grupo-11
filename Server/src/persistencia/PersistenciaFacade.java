package persistencia;

import java.io.IOException;

import comunicacion_ingreso.Cliente;
import interfaces.IAccesoBaseDatos;
import interfaces.IPersistencia;

public class PersistenciaFacade implements IAccesoBaseDatos {

	IPersistencia persistencia;

	public PersistenciaFacade() {
		super();
		this.persistencia = new PersistidorXML();
	}

	@Override
	public Cliente completaCliente(Cliente cliente) {
		Cliente clienteActual = null;
		try {
			persistencia.abrirInput("clientes.xml");
			while (!clienteActual.getDNI().equals(cliente.getDNI())) {
				try {
					clienteActual = (Cliente) persistencia.leer();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

			}
			persistencia.cerrarInput();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return clienteActual;
	}

	@Override
	public void persistirHorarioRegistro() {
		// TODO Auto-generated method stub

	}

	@Override
	public void persistirHorarioDeAtencion() {
		// TODO Auto-generated method stub

	}

}
