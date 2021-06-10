package ui_server;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import interfaces.IVistaServer;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaServer implements IVistaServer {

	private JFrame frame;
	JLabel lblNewLabel;
	private JRadioButton rdbtnDNI;
	private JRadioButton rdbtnPrioridad;
	private JRadioButton rdbtnLlegada;
	

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
		frame.setBounds(100, 100, 365, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		panel.setBounds(0, 0, 359, 292);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Connecting...");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(10, 51, 344, 55);
		panel.add(lblNewLabel);
		
		rdbtnDNI = new JRadioButton("Llamar por DNI (ascendente)");
		rdbtnDNI.setActionCommand("STRATEGY_DNI");
		rdbtnDNI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnPrioridad.setSelected(false);
				rdbtnLlegada.setSelected(false);
			}
		});
		rdbtnDNI.setBounds(26, 128, 215, 23);
		panel.add(rdbtnDNI);
		
		rdbtnPrioridad = new JRadioButton("Llamar por prioridad");
		rdbtnPrioridad.setActionCommand("STRATEGY_PRIORIDAD");
		rdbtnPrioridad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnDNI.setSelected(false);
				rdbtnLlegada.setSelected(false);
			}
		});
		rdbtnPrioridad.setBounds(26, 173, 215, 23);
		panel.add(rdbtnPrioridad);
		
		rdbtnLlegada = new JRadioButton("Llamar por orden de llegada");
		rdbtnLlegada.setActionCommand("STRATEGY_LLEGADA");
		rdbtnLlegada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnDNI.setSelected(false);
				rdbtnPrioridad.setSelected(false);
			}
		});
		rdbtnLlegada.setBounds(26, 218, 215, 23);
		panel.add(rdbtnLlegada);
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
		this.lblNewLabel.setText("Secondary Server Ready");
	}
}
