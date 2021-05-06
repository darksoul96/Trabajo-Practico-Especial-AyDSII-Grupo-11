package vista_cliente;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.border.LineBorder;

import interfaces.IVista;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaCliente implements IVista {

	private JFrame frame;
	private JTextField textFieldDNI;
	private ActionListener actionListener;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCliente window = new VentanaCliente();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 644, 492);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 628, 453);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new CompoundBorder(new LineBorder(new Color(0, 128, 128), 2), new LineBorder(new Color(255, 127, 80), 3)));
		panel_1.setBounds(10, 11, 608, 431);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese al sistema");
		lblNewLabel.setForeground(new Color(255, 99, 71));
		lblNewLabel.setBackground(new Color(230, 230, 250));
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 30));
		lblNewLabel.setBounds(36, 39, 220, 33);
		panel_1.add(lblNewLabel);
		
		JTextPane txtpnPorFavorIngrese = new JTextPane();
		txtpnPorFavorIngrese.setFont(new Font("Cambria", Font.PLAIN, 14));
		txtpnPorFavorIngrese.setBackground(new Color(255, 255, 255));
		txtpnPorFavorIngrese.setText("Por favor ingrese su DNI, luego presionar el bot\u00F3n \"Ingresar\". \r\nSer\u00E1 llamado por pantalla en breve.");
		txtpnPorFavorIngrese.setBounds(36, 83, 213, 101);
		panel_1.add(txtpnPorFavorIngrese);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new CompoundBorder(new LineBorder(new Color(0, 128, 128), 2), new LineBorder(new Color(255, 127, 80), 3)));
		panel_2.setBounds(254, 161, 332, 220);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("DNI");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel_1.setBackground(UIManager.getColor("Button.foreground"));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(29, 24, 139, 23);
		panel_2.add(lblNewLabel_1);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setBackground(new Color(230, 230, 250));
		textFieldDNI.setBounds(21, 58, 289, 34);
		panel_2.add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		JButton btnIngresarDNI = new JButton("Ingresar");
		btnIngresarDNI.setActionCommand("INGRESAR");
		btnIngresarDNI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnIngresarDNI.setBackground(new Color(255, 127, 80));
		btnIngresarDNI.setFont(new Font("Cambria", Font.PLAIN, 15));
		btnIngresarDNI.setBounds(171, 142, 139, 47);
		panel_2.add(btnIngresarDNI);
	
		//JLabel label= new JLabel();
		//label.setIcon(new ImageIcon(VentanaCliente.class.getResource("/vista_cliente/1715114.jpg")));
		//panel.add(label);
	}

	@Override
	public String getTextoDNI() {
		// TODO Auto-generated method stub
		return this.textFieldDNI.getText();
	}
	
    @Override
    public void setActionListener(ActionListener actionListener)
    {
	this.actionListener = actionListener;
    }
	
}
