package consultas_empleado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import interfaces.IVista;
import vista_empleado.VentanaEmpleado;

public class Controller_Emisor_Empleado implements ActionListener {

	private String nroBox;
	private IVista view;

	public Controller_Emisor_Empleado() {
		super();
		this.view = new VentanaEmpleado();
		this.view.setActionListener(this);
		this.view.setVisibleVentana();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		OrdenFactory factory = new OrdenFactory();
		Orden orden = null;
		String command = e.getActionCommand();
		if (command.equalsIgnoreCase("SeleccionBox")) {
			JButton a = (JButton) e.getSource();
			nroBox = a.getText();
			orden = factory.createOrden("SeleccionBox", nroBox);
		} else if (command.equalsIgnoreCase("LLAMAR")) {
			orden = factory.createOrden("LLAMAR", nroBox);
		} else if (command.equalsIgnoreCase("CONSULTAR")) {
			orden = factory.createOrden("CONSULTAR", nroBox);
		}
		try {
			Socket socket = new Socket("localhost", 5006);
			OutputStream outputStream = socket.getOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(orden);
			socket.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
}
