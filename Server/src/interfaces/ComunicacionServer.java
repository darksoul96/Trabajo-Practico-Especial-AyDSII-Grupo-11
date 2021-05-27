package interfaces;

import java.net.ServerSocket;
import java.net.Socket;

import comunicacion_ingreso.Cliente;
import comunicacion_server.BackupPackage;
import comunicacion_server.OrdenResponsePackage;
import ordenes.Orden;

public interface ComunicacionServer {

	public void recibir();

	public void enviarBox(Orden orden, OrdenResponsePackage response);

	public void enviarPantalla(Cliente cliente);
	
	public void conectarServers();

	public void enviarServerSecundario(Socket socket, BackupPackage backup);
	
	public void backup(Cliente cliente);
	
	public void backup(Orden orden);
	
	public void backup();
}
