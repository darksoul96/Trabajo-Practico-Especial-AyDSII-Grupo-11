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
	private JRadioButton rdbtnIntercalado;
	

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
		frame.setBounds(100, 100, 374, 329);
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
		lblNewLabel.setBounds(10, 40, 344, 55);
		panel.add(lblNewLabel);
		
		rdbtnDNI = new JRadioButton("Llamar por DNI (ascendente)");
		rdbtnDNI.setActionCommand("STRATEGY_DNI");
		rdbtnDNI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnPrioridad.setSelected(false);
				rdbtnLlegada.setSelected(false);
				rdbtnIntercalado.setSelected(false);
			}
		});
		rdbtnDNI.setBounds(20, 113, 215, 23);
		panel.add(rdbtnDNI);
		
		rdbtnPrioridad = new JRadioButton("Llamar por prioridad");
		rdbtnPrioridad.setActionCommand("STRATEGY_PRIORIDAD");
		rdbtnPrioridad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnDNI.setSelected(false);
				rdbtnLlegada.setSelected(false);
				rdbtnIntercalado.setSelected(false);
			}
		});
		rdbtnPrioridad.setBounds(20, 147, 215, 23);
		panel.add(rdbtnPrioridad);
		
		rdbtnLlegada = new JRadioButton("Llamar por orden de llegada");
		rdbtnLlegada.setActionCommand("STRATEGY_LLEGADA");
		rdbtnLlegada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnDNI.setSelected(false);
				rdbtnPrioridad.setSelected(false);
				rdbtnIntercalado.setSelected(false);
			}
		});
		rdbtnLlegada.setBounds(20, 183, 215, 23);
		panel.add(rdbtnLlegada);
		
		rdbtnIntercalado = new JRadioButton("Llamar por prioridad intercalada (cada 2)");
		rdbtnIntercalado.setActionCommand("STRATEGY_INTERCALADO");
		rdbtnIntercalado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnDNI.setSelected(false);
				rdbtnPrioridad.setSelected(false);
				rdbtnLlegada.setSelected(false);
			}
		});
		rdbtnIntercalado.setBounds(21, 217, 282, 23);
		panel.add(rdbtnIntercalado);
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

	@Override
	public void setActionListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		this.rdbtnDNI.addActionListener(actionListener);
		this.rdbtnPrioridad.addActionListener(actionListener);
		this.rdbtnLlegada.addActionListener(actionListener);
		this.rdbtnIntercalado.addActionListener(actionListener);
	}
}
