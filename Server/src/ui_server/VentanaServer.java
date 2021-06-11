package ui_server;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import interfaces.IVistaServer;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.awt.event.ActionEvent;

public class VentanaServer implements IVistaServer {

	private JFrame frame;
	JLabel lblNewLabel;
	private JRadioButton rdbtnDNI;
	private JRadioButton rdbtnPrioridad;
	private JRadioButton rdbtnLlegada;
	private JRadioButton rdbtnIntercalado;
	private JLabel lblFotito;
	

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
		lblNewLabel.setBounds(10, 11, 344, 55);
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
		

		lblFotito = new JLabel("");
		lblFotito.setBounds(20, 67, 316, 214);
		
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("res/serverphoto.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		Image dimg = img.getScaledInstance(this.lblFotito.getWidth(), this.lblFotito.getHeight(),
		        Image.SCALE_SMOOTH);
		
		ImageIcon imageIcon = new ImageIcon(dimg);
		this.lblFotito.setIcon(imageIcon);
		this.lblFotito.setVisible(false);
		panel.add(lblFotito);
	}

	public void setVisibleVentana() {
		this.frame.setVisible(true);
	}

	@Override
	public void setPrimario() {
		// TODO Auto-generated method stub
		this.lblNewLabel.setText("Primary Server Online");
		this.rdbtnDNI.setVisible(true);
		this.rdbtnPrioridad.setVisible(true);
		this.rdbtnLlegada.setVisible(true);
		this.rdbtnIntercalado.setVisible(true);
		this.lblFotito.setVisible(false);
		
	}

	@Override
	public void setSecundario() {
		// TODO Auto-generated method stub
		this.lblNewLabel.setText("Secondary Server Ready");
		this.rdbtnDNI.setVisible(false);
		this.rdbtnPrioridad.setVisible(false);
		this.rdbtnLlegada.setVisible(false);
		this.rdbtnIntercalado.setVisible(false);
		this.lblFotito.setVisible(true);
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
