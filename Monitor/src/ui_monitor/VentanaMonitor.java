package ui_monitor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.border.SoftBevelBorder;

import interfaces.IVistaMonitor;

import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class VentanaMonitor implements IVistaMonitor {

	private JFrame frame;
	private JLabel lblNewLabel;
	private JLabel lblStatus1;
	private JLabel lblip1;
	private JLabel lblNewLabel_1;
	private JLabel lblStatus2;
	private JLabel lblip2;

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
		frame.setResizable(false);
		frame.setBounds(100, 100, 474, 263);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(10, 11, 438, 202);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(43, 25, 155, 140);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel = new JLabel("Primary Server");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(23, 11, 111, 14);
		panel_2.add(lblNewLabel);
		
		lblStatus1 = new JLabel("OFFLINE");
		lblStatus1.setForeground(Color.RED);
		lblStatus1.setFont(new Font("Arial", Font.BOLD, 15));
		lblStatus1.setBounds(23, 36, 100, 30);
		panel_2.add(lblStatus1);
		
		lblip1 = new JLabel("IP:");
		lblip1.setBounds(20, 77, 114, 30);
		panel_2.add(lblip1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(239, 25, 155, 140);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Secondary Server");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(20, 11, 135, 14);
		panel_3.add(lblNewLabel_1);
		
		lblStatus2 = new JLabel("OFFLINE");
		lblStatus2.setForeground(Color.RED);
		lblStatus2.setFont(new Font("Arial", Font.BOLD, 15));
		lblStatus2.setBounds(20, 35, 111, 30);
		panel_3.add(lblStatus2);
		
		lblip2 = new JLabel("IP:");
		lblip2.setBounds(20, 76, 111, 30);
		panel_3.add(lblip2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 6));
		panel_1.setBounds(0, 0, 458, 224);
		frame.getContentPane().add(panel_1);
		
		frame.setVisible(true);
	}

	@Override
	public void setServerPrimarioOffline() {
		// TODO Auto-generated method stub
		this.lblStatus1.setText("OFFLINE");
		this.lblStatus1.setForeground(Color.red);
		this.lblip1.setText("IP: ");
	}

	@Override
	public void setServerSecundarioOffline() {
		// TODO Auto-generated method stub
		this.lblStatus2.setText("OFFLINE");
		this.lblStatus2.setForeground(Color.red);
		this.lblip2.setText("IP: ");
	}

	@Override
	public void setServerPrimarioOnline(String ipPrimario) {
		// TODO Auto-generated method stub
		this.lblStatus1.setText("ONLINE");
		this.lblStatus1.setForeground(Color.green);
		this.lblip1.setText("IP: "+ ipPrimario);
	}

	@Override
	public void setServerSecundarioOnline(String ipSecundario) {
		// TODO Auto-generated method stub
		this.lblStatus2.setText("ONLINE");
		this.lblStatus2.setForeground(Color.green);
		this.lblip2.setText("IP: "+ipSecundario);
	}
}
