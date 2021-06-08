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

	public void generaLista() {
		Cliente cliente1 = new Cliente();
		cliente1.setNombre("Seba");
		cliente1.setPrioridad(1);
		cliente1.setDNI("38828813");
		Cliente cliente2 = new Cliente();
		cliente2.setNombre("Agus");
		cliente2.setPrioridad(2);
		cliente2.setDNI("39555671");
		Cliente cliente3 = new Cliente();
		cliente3.setNombre("Jorge");
		cliente3.setPrioridad(3);
		cliente3.setDNI("1");

		try {
			persistencia.abrirOutput("clientes.xml");
			persistencia.escribir(cliente1);
			persistencia.escribir(cliente2);
			persistencia.escribir(cliente3);
			persistencia.cerrarOutput();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Ta creando");

	}

	@Override
	public Cliente completaCliente(Cliente cliente) {
		Cliente clienteActual = null;
		try {
			persistencia.abrirInput("clientes.xml");
			try {
				clienteActual = (Cliente) persistencia.leer();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			while (!clienteActual.getDNI().equals(cliente.getDNI())) {

				try {
					clienteActual = (Cliente) persistencia.leer();
				} catch (IndexOutOfBoundsException e) {
					clienteActual = null;
					break;
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
