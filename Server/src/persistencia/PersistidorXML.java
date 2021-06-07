package persistencia;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import interfaces.IAccesoBaseDatos;
import interfaces.IPersistencia;

public class PersistidorXML implements IPersistencia, IAccesoBaseDatos  {

	private XMLEncoder xmlEncoder;
	private XMLDecoder xmlDecoder;
	private FileOutputStream fileoutput;
	private FileInputStream fileinput;
	
	@Override
	public void abrirInput(String nombre) throws IOException {
		// TODO Auto-generated method stub
		fileinput = new FileInputStream(nombre);
		xmlDecoder = new XMLDecoder(fileinput);
	} 

	@Override
	public void abrirOutput(String nombre) throws IOException {
		// TODO Auto-generated method stub
		fileoutput = new FileOutputStream(nombre);
		xmlEncoder = new XMLEncoder(fileoutput);
	}

	@Override
	public void cerrarInput() throws IOException {
		// TODO Auto-generated method stub
		this.xmlDecoder.close();
	}

	@Override
	public void cerrarOutput() throws IOException {
		// TODO Auto-generated method stub
		this.xmlEncoder.close();
	}

	@Override
	public void escribir(Object objeto) throws IOException {
		// TODO Auto-generated method stub
		this.xmlEncoder.writeObject(objeto);
	}

	@Override
	public Object leer() throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Object objeto = null;
		if (xmlDecoder != null)
			objeto = xmlDecoder.readObject();
		return objeto;
	}

	
}
