package vista_pantalla;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import interfaces.IVista;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPantalla implements IVista{

	private JFrame frame;
	private JFrame frameConfig;


	/**
	 * Create the application.
	 */
	public VentanaPantalla() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 547);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 684, 72);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 339, 72);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DNI");
		lblNewLabel.setForeground(new Color(248, 248, 255));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel.setBounds(144, 11, 120, 36);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(345, 0, 339, 72);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Box Nro");
		lblNewLabel_1.setForeground(new Color(248, 248, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(117, 11, 128, 38);
		panel_2.add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 83, 664, 414);
		frame.getContentPane().add(textArea);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JButton btnConfig = new JButton("Configurar");
		btnConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frameConfig=new JFrame();
				frameConfig.setResizable(false);
				frameConfig.setBounds(100, 100, 500, 300);
				frameConfig.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frameConfig.getContentPane().setLayout(null);
				
				frame.setVisible(false);
				JPanel panel22 = new JPanel();
				panel22.setBounds(0, 0, 484, 261);
				frameConfig.getContentPane().add(panel22);
				panel22.setLayout(null);
				
				//JTextField textFieldCantidad = new JTextField();
				//textFieldCantidad.setBounds(277, 60, 140, 20);
				//panel22.add(textFieldCantidad);
				//textFieldCantidad.setColumns(10);
				
				JTextField textFieldTamano = new JTextField();
				textFieldTamano.setBounds(277, 123, 140, 20);
				panel22.add(textFieldTamano);
				textFieldTamano.setColumns(10);
				
				//JLabel lblNewLabel = new JLabel("Cantidad de llamados");
				//lblNewLabel.setBounds(28, 63, 150, 14);
				//panel22.add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("Tama\u00F1o de letra");
				lblNewLabel_1.setBounds(28, 126, 103, 14);
				panel22.add(lblNewLabel_1);
				
				JButton btnLimpiar = new JButton("Limpiar Pantalla");
				btnLimpiar.setBounds(17, 178, 161, 23);
				btnLimpiar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textArea.setText("");
					}
				});
				
				panel22.add(btnLimpiar);
				
				JButton btnAplicar = new JButton("Aplicar");
				btnAplicar.setBounds(207, 178, 116, 23);
				btnAplicar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (textFieldTamano.getText()!="")
							textArea.setFont(new Font("Arial Black", Font.BOLD, Integer.parseInt(textFieldTamano.getText())));
					}
				});
				panel22.add(btnAplicar);
				
				JButton btnAceptar = new JButton("Aceptar");
				btnAceptar.setBounds(345, 178, 116, 23);
				btnAceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (textFieldTamano.getText()!="")
							textArea.setFont(new Font("Arial Black", Font.BOLD, Integer.parseInt(textFieldTamano.getText())));
						frameConfig.setVisible(false);
						frame.setVisible(true);
					}
				});
				panel22.add(btnAceptar);
				
				frameConfig.setVisible(true);
			}
		});
		menuBar.add(btnConfig);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setVisibleVentana() {
		// TODO Auto-generated method stub
		this.frame.setVisible(true);
	}
}
