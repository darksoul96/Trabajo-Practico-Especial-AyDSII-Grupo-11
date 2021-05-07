package vista_empleado;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaEmpleado {

	private JFrame frame;
	private JButton btnLlamar;
	private JButton btnConsultar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEmpleado window = new VentanaEmpleado();
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
	public VentanaEmpleado() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 694, 484);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 173, 445);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel labelBox = new JLabel("BOX");
		labelBox.setForeground(Color.WHITE);
		labelBox.setFont(new Font("Cambria", Font.PLAIN, 30));
		labelBox.setBounds(47, 200, 88, 34);
		panel.add(labelBox);
		
		JMenu menuBox = new JMenu("Seleccionar Box");
		menuBox.setBackground(new Color(244, 164, 96));
		menuBox.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBox.setForeground(new Color(0, 0, 0));
		menuBox.setBounds(32, 317, 115, 26);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 165, 0));
		panel_1.setBounds(172, 0, 516, 14);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(172, 11, 516, 434);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		btnLlamar = new JButton("Llamar siguiente");
		btnLlamar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLlamar.setEnabled(false);
		btnLlamar.setForeground(Color.WHITE);
		btnLlamar.setBackground(Color.DARK_GRAY);
		btnLlamar.setFont(new Font("Cambria", Font.BOLD, 25));
		btnLlamar.setBounds(128, 148, 263, 73);
		panel_2.add(btnLlamar);
		
		btnConsultar = new JButton("Consultar turnos restantes");
		btnConsultar.setEnabled(false);
		btnConsultar.setForeground(Color.WHITE);
		btnConsultar.setBackground(Color.DARK_GRAY);
		btnConsultar.setFont(new Font("Cambria", Font.BOLD, 18));
		btnConsultar.setBounds(128, 265, 263, 73);
		panel_2.add(btnConsultar);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 165, 0));
		panel_3.setBounds(23, 0, 76, 102);
		panel_2.add(panel_3);
	
		JMenuItem i1, i2, i3, i4, i5;
		i1=new JMenuItem("Box 1");
		i1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelBox.setText("BOX 1");
				btnLlamar.setEnabled(true);
				btnConsultar.setEnabled(true);
			}
		});
		i2=new JMenuItem("Box 2");
		i2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelBox.setText("BOX 2");
				btnLlamar.setEnabled(true);
				btnConsultar.setEnabled(true);
			}
		});
		i3=new JMenuItem("Box 3");
		i3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelBox.setText("BOX 3");
				btnLlamar.setEnabled(true);
				btnConsultar.setEnabled(true);
			}
		});
		i4=new JMenuItem("Box 4");
		i4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelBox.setText("BOX 4");
				btnLlamar.setEnabled(true);
				btnConsultar.setEnabled(true);
			}
		});
		i5=new JMenuItem("Box 5");
		i5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelBox.setText("BOX 5");
				btnLlamar.setEnabled(true);
				btnConsultar.setEnabled(true);
			}
		});
		menuBox.add(i1);
		menuBox.add(i2);
		menuBox.add(i3);
		menuBox.add(i4);
		menuBox.add(i5);
		JMenuBar mb=new JMenuBar(); 
		mb.add(menuBox);
		this.frame.setJMenuBar(mb);
		
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
