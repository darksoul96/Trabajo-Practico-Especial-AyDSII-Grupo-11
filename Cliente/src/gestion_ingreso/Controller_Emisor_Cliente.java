package gestion_ingreso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

import vista_cliente.VentanaCliente;

public class Controller_Emisor_Cliente implements ActionListener{

	private VentanaCliente view;
	private String DNI;

	public Controller_Emisor_Cliente(VentanaCliente view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		
		if (command.equalsIgnoreCase("INGRESO")) {
			this.DNI.equals(view.getTextoDNI());
		}
	}

}
