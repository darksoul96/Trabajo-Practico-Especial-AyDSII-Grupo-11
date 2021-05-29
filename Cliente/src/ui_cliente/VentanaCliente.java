package ui_cliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.text.NumberFormatter;

import interfaces.IVistaCliente;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.border.CompoundBorder;

import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.concurrent.TimeUnit;

public class VentanaCliente implements IVistaCliente {

	private JFrame frame;
	private JFormattedTextField textFieldDNI;
	private ActionListener actionListener;
	private JButton btnIngresarDNI;
	private PopUpReintentar popReintento;
	private JPanel panel_1;
	private JPanel panel;
	private JPanel panel_5;
	private PopUpExito window;

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
		frame.setResizable(false);
		frame.setBounds(100, 100, 644, 492);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 628, 453);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		panel_5=new JPanel();
		panel_5.setBounds(0, 0, 0, 0);
		frame.add(panel_5);
		panel_5.setVisible(false);
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new CompoundBorder(new LineBorder(new Color(0, 128, 128), 2),
				new LineBorder(new Color(255, 127, 80), 3)));
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
		txtpnPorFavorIngrese.setEditable(false);
		txtpnPorFavorIngrese.setFont(new Font("Cambria", Font.PLAIN, 14));
		txtpnPorFavorIngrese.setBackground(new Color(255, 255, 255));
		txtpnPorFavorIngrese.setText(
				"Por favor ingrese su DNI, luego presionar el bot\u00F3n \"Ingresar\". \r\nSer\u00E1 llamado por pantalla en breve.");
		txtpnPorFavorIngrese.setBounds(36, 83, 213, 101);
		panel_1.add(txtpnPorFavorIngrese);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new CompoundBorder(new LineBorder(new Color(0, 128, 128), 2),
				new LineBorder(new Color(255, 127, 80), 3)));
		panel_2.setBounds(254, 161, 332, 220);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("DNI");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel_1.setBackground(UIManager.getColor("Button.foreground"));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(29, 24, 139, 23);
		panel_2.add(lblNewLabel_1);

		
		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter formateador = new NumberFormatter(format);
		formateador.setValueClass(Integer.class);
		formateador.setMinimum(0);
		formateador.setMaximum(Integer.MAX_VALUE);
		formateador.setAllowsInvalid(false);
		formateador.setCommitsOnValidEdit(true);
		textFieldDNI = new JFormattedTextField(formateador);
		textFieldDNI.setBackground(new Color(230, 230, 250));
		textFieldDNI.setBounds(21, 58, 289, 34);
		panel_2.add(textFieldDNI);
		textFieldDNI.setColumns(10);

		btnIngresarDNI = new JButton("Ingresar");
		btnIngresarDNI.setActionCommand("INGRESAR");
		btnIngresarDNI.setEnabled(true);

		btnIngresarDNI.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textFieldDNI.setText(String.valueOf(0));
			}
		});

		btnIngresarDNI.addActionListener(this.actionListener);

		btnIngresarDNI.setBackground(new Color(255, 127, 80));
		btnIngresarDNI.setFont(new Font("Cambria", Font.PLAIN, 15));
		btnIngresarDNI.setBounds(171, 142, 139, 47);
		panel_2.add(btnIngresarDNI);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldDNI.setText(textFieldDNI.getText()+"1");
			}
		});
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn1.setBounds(36, 193, 42, 23);
		panel_1.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldDNI.setText(textFieldDNI.getText()+"2");
			}
		});
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn2.setBounds(82, 193, 42, 23);
		panel_1.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldDNI.setText(textFieldDNI.getText()+"3");
			}
		});
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn3.setBounds(128, 193, 42, 23);
		panel_1.add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldDNI.setText(textFieldDNI.getText()+"4");
			}
		});
		btn4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn4.setBounds(36, 221, 42, 23);
		panel_1.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldDNI.setText(textFieldDNI.getText()+"5");
			}
		});
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn5.setBounds(82, 221, 42, 23);
		panel_1.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldDNI.setText(textFieldDNI.getText()+"6");
			}
		});
		btn6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn6.setBounds(128, 221, 42, 23);
		panel_1.add(btn6);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldDNI.setText(textFieldDNI.getText()+"7");
			}
		});
		btn7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn7.setBounds(36, 248, 42, 23);
		panel_1.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldDNI.setText(textFieldDNI.getText()+"8");
			}
		});
		btn8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn8.setBounds(82, 248, 42, 23);
		panel_1.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldDNI.setText(textFieldDNI.getText()+"9");
			}
		});
		btn9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn9.setBounds(128, 248, 42, 23);
		panel_1.add(btn9);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldDNI.setText(textFieldDNI.getText()+"0");
			}
		});
		btn0.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn0.setBounds(82, 273, 42, 23);
		panel_1.add(btn0);
		
		JButton btnBorrarDNI = new JButton("Borrar");
		btnBorrarDNI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldDNI.setText(String.valueOf(0));
			}
		});
		btnBorrarDNI.setBounds(61, 299, 89, 23);
		panel_1.add(btnBorrarDNI);

		// JLabel label= new JLabel();
		// label.setIcon(new
		// ImageIcon(VentanaCliente.class.getResource("/vista_cliente/1715114.jpg")));
		// panel.add(label);
	}

	@Override
	public String getTextoDNI() {
		// TODO Auto-generated method stub
		return this.textFieldDNI.getText();
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.btnIngresarDNI.addActionListener(actionListener);
		this.textFieldDNI.addActionListener(actionListener);
		this.actionListener = actionListener;
	}

	@Override
	public void setVisibleVentana() {
		// TODO Auto-generated method stub
		this.frame.setVisible(true);
	}

	@Override
	public void popUpNotConnected() {
		JOptionPane.showMessageDialog(null, "Servidor desconectado");

	}

	@Override
	public void MuestraPopUpReintentar() {
		// TODO Auto-generated method stub
		popReintento=new PopUpReintentar();
	}

	@Override
	public void popUpExitoRegistro() {
		// TODO Auto-generated method stub
		int x, y;
		x=frame.getLocationOnScreen().x;
		y=frame.getLocationOnScreen().y;
		window = new PopUpExito(x,y);
	}

}
