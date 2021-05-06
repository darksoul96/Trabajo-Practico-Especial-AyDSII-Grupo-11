package gestion_ingreso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

import interfaces.IVista;
import vista_cliente.VentanaCliente;

public class Controller_Emisor_Cliente implements ActionListener{

	private IVista view;
	private String DNI;

	public Controller_Emisor_Cliente() {
		super();
		this.view = new VentanaCliente();
		this.view.setActionListener(this);
		this.view.setVisibleVentana();
	}
	
    public void setVista(IVista vista)
    {
        this.view = vista;
        this.view.setActionListener(this);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		
		if (command.equalsIgnoreCase("INGRESO")) {
			this.DNI.equals(view.getTextoDNI());
			System.out.println(DNI);
			try {
				Socket socket = new Socket("localhost",5005);
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out.println(DNI);
				out.close();
				socket.close();
				
			}
			catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		
	}

}
