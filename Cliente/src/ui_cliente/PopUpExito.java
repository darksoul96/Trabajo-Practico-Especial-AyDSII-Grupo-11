package ui_cliente;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class PopUpExito extends JDialog {

	private String mensaje = "Cliente registrado con exito";


	/**
	 * Create the application.
	 */
	public PopUpExito() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(scrSize.width/2 - 50, scrSize.height/2 - 40);
	    

	    setSize(225,120);
	    setLayout(null);
	    setUndecorated(true);
	    setLayout(new GridBagLayout());
	    
	    
	    GridBagConstraints constraints = new GridBagConstraints();
	    constraints.gridx = 0;
	    constraints.gridy = 0;
	    constraints.weightx = 1.0f;
	    constraints.weighty = 1.0f;
	    constraints.insets = new Insets(5, 5, 5, 5);
	    constraints.fill = GridBagConstraints.BOTH;

	    JLabel lblExito = new JLabel(mensaje);
	    lblExito.setAlignmentX(JLabel.CENTER_ALIGNMENT);
	    Font f=new Font("Arial", Font.BOLD, 16);
	    lblExito.setFont(f);
	    lblExito.setOpaque(false);

	    add(lblExito, constraints);

	    constraints.gridx++;
	    constraints.weightx = 0f;
	    constraints.weighty = 0f;
	    constraints.fill = GridBagConstraints.NONE;
	    constraints.anchor = GridBagConstraints.NORTH;

	    setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	    setVisible(true);
	    setAlwaysOnTop(true);

	    new Thread(){
	          @Override
	          public void run() {
	               try {
	                      Thread.sleep(1800);
	                      dispose();
	               } catch (InterruptedException e) {
	                      e.printStackTrace();
	               }
	          };
	    }.start();
	}

}
