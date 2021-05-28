package ui_server;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import interfaces.IVistaServer;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class VentanaServer implements IVistaServer {

	private JFrame frame;
	JLabel lblNewLabel;

	

	/**
	 * Create the application.
	 */
	public VentanaServer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 369, 185);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Server Online");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(46, 39, 306, 52);
		panel.add(lblNewLabel);
	}

	public void setVisibleVentana() {
		this.frame.setVisible(true);
	}

	@Override
	public void setPrimario() {
		// TODO Auto-generated method stub
		this.lblNewLabel.setText("Primary Server Online");
	}

	@Override
	public void setSecundario() {
		// TODO Auto-generated method stub
		this.lblNewLabel.setText("Secondary Server Online");
	}
}
