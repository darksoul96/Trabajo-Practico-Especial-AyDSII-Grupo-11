package interfaces;


import java.net.Socket;

import comunicacion_ingreso.Cliente;
import controller_server.ControllerServer;
import ordenes.Orden;
import paquetes.BackupPackage;


public interface IComunicacionServer {

	public void recibirServer();

	public void conectarServers();

	public void enviarServerSecundario(Socket socket, BackupPackage backup);
	
	public void backup(Cliente cliente);
	
	public void backup(Orden orden);
	
	public void backup();

	public void setController(ControllerServer controllerServer);
}
