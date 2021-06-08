package comunicacion_server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import comunicacion_ingreso.Cliente;
import interfaces.IAccesoBaseDatos;
import interfaces.IComunicacionServer;
import interfaces.Monitoreable;
import ordenes.Orden;
import paquetes.BackupPackage;
import paquetes.MonitorPackage;
import paquetes.OrdenResponsePackage;
import persistencia.PersistenciaFacade;
import repository.Servidor;
import ui_server.VentanaServer;

public class ControllerComunicacionServer implements IComunicacionServer, Monitoreable {
	int portReceptorCliente;
	int portReceptorEmpleado;
	int portEmisorPantalla;
	int portMonitor;
	int portMonitor2;
	String ipMonitor;
	String ipPantalla;
	String ipLocalServer;
	String ipServer2;
	VentanaServer ventanaServer;
	Socket clientSecondaryServerSocket;
	IAccesoBaseDatos persistidor;

	public ControllerComunicacionServer(int portReceptorCliente, int portReceptorEmpleado, int portEmisorPantalla,
			String ipPantalla, String ipMonitor, int portMonitor, int portMonitor2, String ipLocalServer,
			String ipServer2) {
		super();
		this.portReceptorCliente = portReceptorCliente;
		this.portReceptorEmpleado = portReceptorEmpleado;
		this.portEmisorPantalla = portEmisorPantalla;
		this.ipPantalla = ipPantalla;
		this.ipMonitor = ipMonitor;
		this.portMonitor = portMonitor;
		this.ipLocalServer = ipLocalServer;
		this.portMonitor2 = portMonitor2;
		this.ipServer2 = ipServer2;
		this.persistidor = new PersistenciaFacade();
	}

	public void ejecutarVentana() {
		ventanaServer = new VentanaServer();
		this.ventanaServer.setVisibleVentana();
	}

	@Override
	public void recibir() { // Abro el server para recibir peticiones de Cliente y Empleado
		PackageHandler packageHandler = new PackageHandler();
		new Thread() {
			public void run() { // Puerto para recibir peticiones desde la Estacion Cliente
				try {
					ServerSocket s = new ServerSocket(portReceptorCliente);
					while (true) {
						Socket soc = s.accept();
						InputStream inputStream = soc.getInputStream();
						ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
						Cliente client = (Cliente) objectInputStream.readObject();
						Cliente clientePersistido = persistidor.completaCliente(client);
						if (clientePersistido != null) {
							backup(clientePersistido);
							packageHandler.handle(persistidor.completaCliente(clientePersistido));
						}
						OutputStream outputStream = soc.getOutputStream();
						ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
						objectOutputStream.writeObject(clientePersistido);

					}
				} catch (Exception e) {

				}
			}
		}.start();
		new Thread() {
			public void run() { // Puerto para recibir peticiones desde los Boxes
				try {
					ServerSocket s = new ServerSocket(portReceptorEmpleado);
					while (true) {
						Socket soc = s.accept();
						InputStream inputStream = soc.getInputStream();
						ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
						Orden orden = (Orden) objectInputStream.readObject();
						backup(orden);
						OrdenResponsePackage response = packageHandler.handle(orden);
						enviarBox(orden, response);
						if (response.type.equals("LLAMAR")) {
							enviarPantalla(Servidor.getInstance().getLastCalledClient());
						}

					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
		new Thread() {
			public void run() { // Puerto para conectar Server Primario y Secundario
				try {
					ServerSocket s = new ServerSocket(5000);
					while (true) {
						Socket soc = s.accept();
						System.out.println(soc.getLocalAddress());
						clientSecondaryServerSocket = soc;
						BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
						if (in.readLine().equals("connected"))
							backup();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	@Override
	public void enviarBox(Orden orden, OrdenResponsePackage response) { // Comunicar con un box
		try {
			Socket socket = new Socket(orden.getIp(), orden.getPort());
			OutputStream outputStream = socket.getOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(response);
			socket.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void enviarPantalla(Cliente cliente) { // Envio a la pantalla
		try {
			Socket socket = new Socket(ipPantalla, portEmisorPantalla);
			OutputStream outputStream = socket.getOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(cliente);
			socket.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	@Override
	public void conectarServers() {
		new Thread() {
			public void run() {
				try { // Conectarme al server principal, si no puede, es porque no hay principal
					Socket socket = new Socket(ipServer2, 5000);
					Servidor.getInstance().setSecondary();
					ventanaServer.setSecundario();
					PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
					out.println("connected");
					heartbeat(portMonitor2, ipMonitor);
					while (true) {
						InputStream inputStream = socket.getInputStream();
						ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
						BackupPackage backup = (BackupPackage) objectInputStream.readObject();
						PackageHandler packageHandler = new PackageHandler();
						packageHandler.handle(backup);
						System.out.println("Me llego msj del server");
					}
				} catch (SocketException e1) {
					ventanaServer.setPrimario();
					Servidor.getInstance().setPrimary();
					recibir();
					heartbeat(portMonitor, ipMonitor);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}.start();

	}

	@Override
	public void enviarServerSecundario(Socket socket, BackupPackage backup) {
		try {
			OutputStream outputStream = socket.getOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(backup);
			System.out.println("Envie desde el principal");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void backup(Cliente cliente) {
		if (clientSecondaryServerSocket != null) {
			BackupPackage backup = new BackupPackage();
			backup.setCliente(cliente);
			enviarServerSecundario(clientSecondaryServerSocket, backup);
		}

	}

	@Override
	public void backup(Orden orden) {
		if (clientSecondaryServerSocket != null) {
			BackupPackage backup = new BackupPackage();
			backup.setOrden(orden);
			enviarServerSecundario(clientSecondaryServerSocket, backup);
		}
	}

	@Override
	public void backup() {
		if (clientSecondaryServerSocket != null) {
			BackupPackage backup = new BackupPackage();
			backup.sincronizarServer(Servidor.getInstance().getClientes(), Servidor.getInstance().getBoxes(),
					Servidor.getInstance().getLastCalledClient());
			enviarServerSecundario(clientSecondaryServerSocket, backup);
		}

	}

	@Override
	public void heartbeat(int portMonitor, String ipMonitor) {
		new Thread() {
			public void run() {
				boolean isPrimary = Servidor.getInstance().isPrimary();
				while (isPrimary == Servidor.getInstance().isPrimary()) {
					try {
						Socket socket = new Socket(ipMonitor, portMonitor);
						OutputStream outputStream = socket.getOutputStream();
						ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
						MonitorPackage paqueteMonitor = new MonitorPackage(ipLocalServer,
								Servidor.getInstance().isPrimary());
						objectOutputStream.writeObject(paqueteMonitor);
						socket.close();
					} catch (Exception e2) {
						// e2.printStackTrace();
					} finally {
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e3) {
							e3.printStackTrace();
						}
					}
				}
			}
		}.start();
	}

}
