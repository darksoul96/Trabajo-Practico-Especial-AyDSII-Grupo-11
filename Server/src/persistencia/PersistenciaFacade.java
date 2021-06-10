package persistencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import comunicacion_ingreso.Cliente;
import interfaces.IAccesoBaseDatos;
import interfaces.IPersistencia;

public class PersistenciaFacade implements IAccesoBaseDatos {

	IPersistencia persistencia;
	private ArrayList<Cliente> clientesEnDB = new ArrayList<Cliente>();

	public PersistenciaFacade() {
		super();
		this.persistencia = new PersistidorXML();
	}

	public void generaLista() {

		try {
			persistencia.abrirOutput("clientes.xml");
			this.llenarBaseDeDatos();
			while (clientesEnDB.size() != 0) {
				persistencia.escribir(clientesEnDB.remove(0));
			}
			persistencia.cerrarOutput();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void llenarBaseDeDatos() {
		Cliente actual;
		String lineaTotal, linea2 = "", nombre, apellido, dni;
		int prioridad, index;

		try {
			File archivo = new File("clientes.txt");
			Scanner scan = new Scanner(archivo);
			while (scan.hasNextLine()) {
				lineaTotal = scan.nextLine();
				prioridad = Integer.parseInt(lineaTotal.substring(0, 1));
				linea2 = lineaTotal.substring(2);
				index = linea2.indexOf(' ');
				nombre = linea2.substring(0, index);
				linea2 = linea2.substring(index + 1);
				index = linea2.indexOf(' ');
				apellido = linea2.substring(0, index);
				linea2 = linea2.substring(index);
				dni = linea2;
				dni = dni.replaceAll("\\s", "");

				actual = new Cliente();
				actual.setDNI(dni);
				actual.setNombre(nombre + " " + apellido);
				actual.setPrioridad(prioridad);
				clientesEnDB.add(actual);
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Cliente completaCliente(Cliente cliente) {
		Cliente clienteActual = null;
		String horaDeRegistro = cliente.getHorarioRegistro();
		try {
			persistencia.abrirInput("clientes.xml");
			try {
				clienteActual = (Cliente) persistencia.leer();
				clienteActual.setHorarioRegistro(horaDeRegistro);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			while (!clienteActual.getDNI().equals(cliente.getDNI())) {

				try {
					clienteActual = (Cliente) persistencia.leer();
					clienteActual.setHorarioRegistro(horaDeRegistro);
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
	public void persistirHorarioRegistro(Cliente cliente) {
		System.out.println(cliente.getHorarioRegistro());
		HorarioRegistro registro = new HorarioRegistro(cliente.getHorarioRegistro(), cliente.getDNI());

		try {
			persistencia.abrirOutput("registros.xml");
			persistencia.escribir(registro);
			persistencia.cerrarOutput();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void persistirHorarioDeAtencion(Cliente cliente) {
		// TODO Auto-generated method stub

	}

}
