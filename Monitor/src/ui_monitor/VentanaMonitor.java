package ui_monitor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class VentanaMonitor {

	private JFrame frame;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMonitor window = new VentanaMonitor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the application.
	 */
	public VentanaMonitor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 474, 454);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 438, 393);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Servidor Primario");
		lblNewLabel.setBounds(45, 35, 94, 14);
		panel.add(lblNewLabel);
		
		JLabel lblServidorSecundario = new JLabel("Servidor Secundario");
		lblServidorSecundario.setBounds(45, 74, 107, 14);
		panel.add(lblServidorSecundario);
		
		JLabel lblAppCliente = new JLabel("App Cliente");
		lblAppCliente.setBounds(45, 111, 94, 14);
		panel.add(lblAppCliente);
		
		JLabel lblAppEmpleado = new JLabel("App Empleado");
		lblAppEmpleado.setBounds(45, 146, 94, 14);
		panel.add(lblAppEmpleado);
		
		JLabel lblAppPantalla = new JLabel("App Pantalla");
		lblAppPantalla.setBounds(45, 183, 94, 14);
		panel.add(lblAppPantalla);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(29, 225, 399, 157);
		panel.add(textPane);
	}
}
