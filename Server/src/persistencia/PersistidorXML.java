package persistencia;

import java.io.IOException;

import interfaces.IAccesoBaseDatos;
import interfaces.IPersistencia;

public class PersistidorXML implements IPersistencia, IAccesoBaseDatos  {

	@Override
	public void abrirInput(String nombre) throws IOException {
		// TODO Auto-generated method stub
		
	} 

	@Override
	public void abrirOutput(String nombre) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cerrarInput() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cerrarOutput() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void escribir(Object objeto) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object leer() throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
